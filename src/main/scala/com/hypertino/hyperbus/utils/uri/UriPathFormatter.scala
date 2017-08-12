package com.hypertino.hyperbus.utils.uri

import com.hypertino.hyperbus.utils.uri.UriPathParser.tokens

object UriPathFormatter {
  def format(pattern: String, args: Map[String, String]): String = format(tokens(pattern), args)

  def format(patternTokens: Iterator[Token], args: Map[String, String]): String = patternTokens map {
    case TextToken(s) ⇒ s
    case ParameterToken(p) ⇒ args(p)
    case SlashToken ⇒ '/'
  } mkString
}
