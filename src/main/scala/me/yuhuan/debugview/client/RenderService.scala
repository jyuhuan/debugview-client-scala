package me.yuhuan.debugview.client

import debugview.server._
import me.yuhuan.debugview.server._

import me.yuhuan.util.net.TcpMessenger
import poly.util.io.FileIO

/**
 * Methods for rendering. Clients, please use these methods to render your objects.
 * Please ensure that the rendering server is running before calling these methods.
 *
 * @author Yuhuan Jiang (jyuhuan@gmail.com).
 */
object RenderService {

  def renderHtmlContent(className: String, content: String) = {
    val messenger = TcpMessenger("127.0.0.1", Ports.RenderServicePort)
    val segmentSize = 1024
    messenger.sendInt(TaskCode.RenderHtml)
    val segments = content.grouped(segmentSize).toSeq
    messenger.sendString(className)
    messenger.sendStrings(segments)
  }

  def renderHtmlAtPath(className: String, path: String) = {
    val htmlContent = FileIO.readAll(path)
    renderHtmlContent(className, htmlContent)
  }

  def renderSvgContent(className: String, content: String) = {
    val messenger = TcpMessenger("127.0.0.1", Ports.RenderServicePort)
    val segmentSize = 1024
    messenger.sendInt(TaskCode.RenderSvg)
    val segments = content.grouped(segmentSize).toSeq
    messenger.sendString(className)
    messenger.sendStrings(segments)
  }

  def renderSvgAtPath(className: String, path: String) = {
    val svgContent = FileIO.readAll(path)
    renderSvgContent(className, svgContent)
  }

  def renderGraphViz(className: String, content: String) = {
    val messenger = TcpMessenger("127.0.0.1", Ports.RenderServicePort)
    val segmentSize = 1024
    messenger.sendInt(TaskCode.RenderGraphviz)
    val segments = content.grouped(segmentSize).toSeq
    messenger.sendString(className)
    messenger.sendStrings(segments)
  }

}
