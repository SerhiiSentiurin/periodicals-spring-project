/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.48
 * Generated at: 2022-09-11 12:28:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/Серёга/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153374282000L));
    _jspx_dependants.put("file:/C:/Users/Серёга/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar", Long.valueOf(1653232043533L));
    _jspx_dependants.put("/WEB-INF/tag/language.tld", Long.valueOf(1662408800805L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Admin page</title>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <p>\r\n");
      out.write("            ");
      if (_jspx_meth_lang_005fprint_005f0(_jspx_page_context))
        return;
      out.write(',');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.login}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("        <p>\r\n");
      out.write("            <form action = \"/app/periodicals/admin/managePeriodicals\" method = \"GET\">\r\n");
      out.write("                <input type = \"submit\" value = '");
      if (_jspx_meth_lang_005fprint_005f1(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("            </form><br>\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("        <p>\r\n");
      out.write("            <form action = \"/app/periodicals/admin/manageReaders\" method = \"GET\">\r\n");
      out.write("                <input type = \"submit\" value = '");
      if (_jspx_meth_lang_005fprint_005f2(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("            </form><br>\r\n");
      out.write("        </p>\r\n");
      out.write("\r\n");
      out.write("        <p>\r\n");
      out.write("            <form action = \"/app/periodicals/logout\" method = \"POST\">\r\n");
      out.write("                <input type = \"submit\" value = '");
      if (_jspx_meth_lang_005fprint_005f3(_jspx_page_context))
        return;
      out.write("'>\r\n");
      out.write("            </form><br>\r\n");
      out.write("        </p>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_lang_005fprint_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  lang:print
    org.periodicals.epam.spring.project.infra.web.LanguageTag _jspx_th_lang_005fprint_005f0 = (org.periodicals.epam.spring.project.infra.web.LanguageTag) _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.get(org.periodicals.epam.spring.project.infra.web.LanguageTag.class);
    boolean _jspx_th_lang_005fprint_005f0_reused = false;
    try {
      _jspx_th_lang_005fprint_005f0.setPageContext(_jspx_page_context);
      _jspx_th_lang_005fprint_005f0.setParent(null);
      // /admin/adminHome.jsp(11,12) name = message type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_lang_005fprint_005f0.setMessage("admin.adminHome.jsp.welcome_home_page");
      int _jspx_eval_lang_005fprint_005f0 = _jspx_th_lang_005fprint_005f0.doStartTag();
      if (_jspx_th_lang_005fprint_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.reuse(_jspx_th_lang_005fprint_005f0);
      _jspx_th_lang_005fprint_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_lang_005fprint_005f0, _jsp_getInstanceManager(), _jspx_th_lang_005fprint_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_lang_005fprint_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  lang:print
    org.periodicals.epam.spring.project.infra.web.LanguageTag _jspx_th_lang_005fprint_005f1 = (org.periodicals.epam.spring.project.infra.web.LanguageTag) _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.get(org.periodicals.epam.spring.project.infra.web.LanguageTag.class);
    boolean _jspx_th_lang_005fprint_005f1_reused = false;
    try {
      _jspx_th_lang_005fprint_005f1.setPageContext(_jspx_page_context);
      _jspx_th_lang_005fprint_005f1.setParent(null);
      // /admin/adminHome.jsp(16,48) name = message type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_lang_005fprint_005f1.setMessage("admin.adminHome.jsp.button.manage_periodicals");
      int _jspx_eval_lang_005fprint_005f1 = _jspx_th_lang_005fprint_005f1.doStartTag();
      if (_jspx_th_lang_005fprint_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.reuse(_jspx_th_lang_005fprint_005f1);
      _jspx_th_lang_005fprint_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_lang_005fprint_005f1, _jsp_getInstanceManager(), _jspx_th_lang_005fprint_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_lang_005fprint_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  lang:print
    org.periodicals.epam.spring.project.infra.web.LanguageTag _jspx_th_lang_005fprint_005f2 = (org.periodicals.epam.spring.project.infra.web.LanguageTag) _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.get(org.periodicals.epam.spring.project.infra.web.LanguageTag.class);
    boolean _jspx_th_lang_005fprint_005f2_reused = false;
    try {
      _jspx_th_lang_005fprint_005f2.setPageContext(_jspx_page_context);
      _jspx_th_lang_005fprint_005f2.setParent(null);
      // /admin/adminHome.jsp(22,48) name = message type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_lang_005fprint_005f2.setMessage("admin.adminHome.jsp.button.manage_readers");
      int _jspx_eval_lang_005fprint_005f2 = _jspx_th_lang_005fprint_005f2.doStartTag();
      if (_jspx_th_lang_005fprint_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.reuse(_jspx_th_lang_005fprint_005f2);
      _jspx_th_lang_005fprint_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_lang_005fprint_005f2, _jsp_getInstanceManager(), _jspx_th_lang_005fprint_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_lang_005fprint_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  lang:print
    org.periodicals.epam.spring.project.infra.web.LanguageTag _jspx_th_lang_005fprint_005f3 = (org.periodicals.epam.spring.project.infra.web.LanguageTag) _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.get(org.periodicals.epam.spring.project.infra.web.LanguageTag.class);
    boolean _jspx_th_lang_005fprint_005f3_reused = false;
    try {
      _jspx_th_lang_005fprint_005f3.setPageContext(_jspx_page_context);
      _jspx_th_lang_005fprint_005f3.setParent(null);
      // /admin/adminHome.jsp(28,48) name = message type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_lang_005fprint_005f3.setMessage("admin.adminHome.jsp.button.logout");
      int _jspx_eval_lang_005fprint_005f3 = _jspx_th_lang_005fprint_005f3.doStartTag();
      if (_jspx_th_lang_005fprint_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005flang_005fprint_0026_005fmessage_005fnobody.reuse(_jspx_th_lang_005fprint_005f3);
      _jspx_th_lang_005fprint_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_lang_005fprint_005f3, _jsp_getInstanceManager(), _jspx_th_lang_005fprint_005f3_reused);
    }
    return false;
  }
}
