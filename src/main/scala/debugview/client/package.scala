package debugview

import debugview.server._
import poly.util.io.FileIO

import scala.sys.process._


/**
 * @author Tongfei Chen (ctongfei@gmail.com).
 */
package object client {

  def renderHtml[T](x: T)(implicit f: HtmlRenderer[T]) = {
    RenderService.renderHtmlContent(x.getClass.getName, f.str(x))
  }

  def renderHtmlAtPath(path: String) = RenderService.renderHtmlAtPath("", path)

  def renderSvg[T](x: T)(implicit f: SvgRenderer[T]) = {
    RenderService.renderSvgContent(x.getClass.getName, f.str(x))
  }

  def renderSvgAtPath(path: String) = RenderService.renderSvgAtPath("", path)

  def renderGraphviz[T](x: T)(implicit r: GraphvizRenderer[T]) = {
    val dot = r.str(x)
    FileIO.writeAll("./tmp.dot")(dot)
    "dot -Tsvg ./tmp.dot -o ./tmp.svg".!
    renderSvgAtPath("./tmp.svg")
  }

}
