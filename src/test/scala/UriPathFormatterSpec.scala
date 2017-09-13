import com.hypertino.hyperbus.utils.uri._
import org.scalatest.{FlatSpec, Matchers}

class UriPathFormatterSpec extends FlatSpec with Matchers{
  "UriPatFormatter" should "format string with arguments" in {
    val s = "abc/{def}/ekl"
    UriPathFormatter.format(s, Map("def" → "100500")) shouldBe "abc/100500/ekl"
  }

  it should "format string with parameters and text between" in {
    val s = "abc/{def}:{klm}/ekl"
    UriPathFormatter.format(s, Map("def" → "100500", "klm" → "yey")) shouldBe "abc/100500:yey/ekl"
  }
}
