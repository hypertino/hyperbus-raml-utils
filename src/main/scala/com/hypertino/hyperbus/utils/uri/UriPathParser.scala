package com.hypertino.hyperbus.utils.uri

sealed trait Token

case object SlashToken extends Token

case class TextToken(value: String) extends Token

case class ParameterToken(value: String) extends Token

case class UriPathParserException(message: String, cause: Throwable = null) extends RuntimeException(message, cause)

object UriPathParser {
  def extractParameters(pattern: String): Iterator[String] = tokens(pattern) collect {
    case ParameterToken(str) ⇒ str
  }

  def tokens(pattern: String): Iterator[Token] = new TokenIterator(pattern.iterator)
}

private [uri] class TokenIterator(sourceIterator: Iterator[Char]) extends Iterator[Token] {
  private val sb = new StringBuilder
  var unprocessed: Option[Char] = None

  override def hasNext: Boolean = unprocessed.isDefined || sourceIterator.hasNext

  override def next(): Token = {
    nextChar() match {
      case '/' ⇒ SlashToken
      case '{' ⇒ nextParameterToken()
      case c ⇒ nextTextToken(c)
    }
  }

  private def nextChar(): Char = unprocessed.map { c ⇒
    unprocessed = None
    c
  } getOrElse {
    sourceIterator.next()
  }

  private def nextParameterToken(): ParameterToken = {
    sb.clear()
    var continue = true
    while (hasNext && continue) {
      nextChar() match {
        case '}' ⇒
          continue = false

        case ci ⇒
          sb.append(ci)
      }
    }
    ParameterToken(sb.toString())
  }

  private def nextTextToken(c: Char): TextToken = {
    sb.clear()
    sb.append(c)
    var continue = true
    while (hasNext && continue) {
      nextChar() match {
        case ci @ ('/' | '{') ⇒
          unprocessed = Some(ci)
          continue = false

        case ci ⇒
          sb.append(ci)
      }
    }
    TextToken(sb.toString)
  }
}