package org.universAAL.AALapplication.medication_manager.servlet.ui.impl.servlets;

import org.universAAL.AALapplication.medication_manager.servlet.ui.impl.parser.HtmlParser;
import org.universAAL.AALapplication.medication_manager.servlet.ui.impl.parser.Util;
import org.universAAL.AALapplication.medication_manager.servlet.ui.impl.parser.script.forms.ScriptForm;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author George Fournadjiev
 */
public abstract class BaseServlet extends HttpServlet {

  private final HtmlParser htmlParser;

  protected BaseServlet(String htmlFileName) {
    String htmlText = Util.getHtml(htmlFileName);
    htmlParser = new HtmlParser(htmlText);
  }

  public void sendResponse(HttpServletResponse resp,
                           ScriptForm scriptForm) throws IOException {

    try {

      String scriptText = scriptForm.createScriptText();

      sendSuccessfulResponse(resp, scriptText);

    } catch (Exception e) {

      sendErrorResponse(resp, e);

    }

  }

  public void sendErrorResponse(HttpServletResponse resp, Exception e) throws IOException {
    StringBuffer sb = new StringBuffer();

    sb.append("Internal error - an exception occurred: ");
    sb.append('\n');
    sb.append("class: ");
    sb.append(e.getClass().getName());
    sb.append('\n');
    sb.append("message: ");
    String message = e.getMessage();
    if (message == null || message.trim().isEmpty()) {
      sb.append("Missing message");
    } else {
      sb.append(message);
    }

    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, sb.toString());
  }

  private void sendSuccessfulResponse(HttpServletResponse resp, String script) throws IOException {
    String htmlOutput = htmlParser.addScriptElement(script);

    PrintWriter writer = resp.getWriter();

    writer.println(htmlOutput);
  }


}
