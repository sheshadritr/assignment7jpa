package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" ng-app=\"myApp\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<title>SO: AngularJS Dashboard</title>\n");
      out.write("\t<link href=\"assets/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"assets/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"assets/css/main.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"header\">\n");
      out.write("\t\t<div class=\"navbar navbar-fixed-top navbar-bg\" role=\"navigation\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<div class=\"navbar-header navbar-brand-width\">\n");
      out.write("\t\t\t\t\t<span class=\"navbar-brand\">AngularJS Dashboard </span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right navbar-center\">\n");
      out.write("\t\t\t\t\t\t<li class=\"active\"><a href=\"#/tagchart\">Tags</a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#/questionchart\">Questions</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div ng-view></div>\n");
      out.write("\t\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.0.7/angular.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"https://www.google.com/jsapi\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/js/controllers.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/js/ngGoogleCharts.js\" type=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/js/jquery-1.8.3.js\"></script>\n");
      out.write("\t<script src=\"assets/js/bootstrap.js\"></script>\n");
      out.write("\t<script src=\"assets/js/app.js\"></script>\n");
      out.write("\t<script src=\"assets/js/services.js\"></script>\n");
      out.write("\t<script src=\"assets/js/controllers.js\"></script>\n");
      out.write("\t<script src=\"assets/js/filters.js\"></script>\n");
      out.write("\t<script src=\"assets/js/directives.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
