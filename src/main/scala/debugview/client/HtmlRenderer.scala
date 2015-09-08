package debugview.client

import poly.util.typeclass._

/**
 * @author Tongfei Chen (ctongfei@gmail.com).
 */
trait HtmlRenderer[-T] extends Formatter[T]

trait SvgRenderer[-T] extends Formatter[T]

trait GraphvizRenderer[-T] extends Formatter[T]
