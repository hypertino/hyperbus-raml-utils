import com.hypertino.hyperbus.utils.uri._
import org.scalatest.{FlatSpec, Matchers}

class UriPathFormatterSpec extends FlatSpec with Matchers{
  "UriPatFormatter" should "format string with arguments" in {
    val s = "abc/{def}/ekl"
    UriPathFormatter.format(s, Map("def" → "100500")) shouldBe "abc/100500/ekl"
  }
}
