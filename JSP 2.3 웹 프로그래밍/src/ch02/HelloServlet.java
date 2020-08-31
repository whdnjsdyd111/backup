package ch02;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HelloServlet"})
public class HelloServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html; charset=utf-8");
    PrintWriter out = response.getWriter();
    out.print("<HTML>");
    out.print("<HEAD><TITLE>처음으로 작성하는 Servlet</TITLE></HEAD>");
    out.print("<BODY>");
    out.print("처음 작성하는 Servlet");
    out.print("</BODY>");
    out.print("<HTML>");
    out.close();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }
}