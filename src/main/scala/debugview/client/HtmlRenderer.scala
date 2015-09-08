package debugview.client

import poly.util.typeclass._

/**
 * @author Tongfei Chen (ctongfei@gmail.com).
 */
trait HtmlRenderer[-T] extends Formatter[T]
object HtmlRenderer {

  implicit object StringHtmlRenderer extends HtmlRenderer[String] {
    def str(x: String) = x
  }

  implicit def SeqHtmlRenderer[T]: HtmlRenderer[Seq[T]] = new HtmlRenderer[Seq[T]] {
    def str(x: Seq[T]) = "<ol>" + x.map(e => s"<li>$e</li>").mkString("\n") + "</ol>"
  }

}

trait SvgRenderer[-T] extends Formatter[T]

trait GraphvizRenderer[-T] extends Formatter[T]
