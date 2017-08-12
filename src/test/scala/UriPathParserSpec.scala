import com.hypertino.hyperbus.utils.uri._
import org.scalatest.{FlatSpec, Matchers}

class UriPathParserSpec extends FlatSpec with Matchers{
  "UriPathParser" should "parse string with parameters" in {
    val s = "abc/{def}/ekl"

    UriPathParser.tokens(s).toSeq shouldBe Seq(TextToken("abc"),
      SlashToken,
      ParameterToken("def"),
      SlashToken,
      TextToken("ekl")
    )

    val s2 = "abc/{def}~/ekl"

    UriPathParser.tokens(s2).toSeq shouldBe Seq(TextToken("abc"),
      SlashToken,
      ParameterToken("def"),
      TextToken("~"),
      SlashToken,
      TextToken("ekl")
    )
  }
}
