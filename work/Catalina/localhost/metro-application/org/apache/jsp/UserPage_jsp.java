/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2024-11-29 08:04:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/Users/NEW/.m2/repository/javax/servlet/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1308849601000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("            <head>\r\n");
      out.write("                <meta charset=\"UTF-8\">\r\n");
      out.write("                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("                <title>Metro Home Page</title>\r\n");
      out.write("                <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\r\n");
      out.write("            </head>\r\n");
      out.write("\r\n");
      out.write("            <body class=\"bg-light text-dark\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Navigation Bar -->\r\n");
      out.write("                <div>\r\n");
      out.write("                    <nav class=\"navbar navbar-expand-lg navbar-dark\" style=\"background-color: rgb(127, 134, 138);\">\r\n");
      out.write("                        <div class=\"container-fluid\">\r\n");
      out.write("                            <a class=\"navbar-brand\" href=\"getIndex\">\r\n");
      out.write("                                <img src=\"https://www.x-workz.in/Logo.png\" alt=\"Company Logo\" style=\"max-height: 40px;\">\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <h1 class=\"h3 text-white mx-2\">User Page</h1>\r\n");
      out.write("\r\n");
      out.write("                            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\"\r\n");
      out.write("                                data-bs-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\"\r\n");
      out.write("                                aria-label=\"Toggle navigation\">\r\n");
      out.write("                                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("                            </button>\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("                                <ul class=\"navbar-nav ms-auto text-center align-items-center\">\r\n");
      out.write("\r\n");
      out.write("                                    <li class=\"nav-item mx-auto\">\r\n");
      out.write("                                        <img src=\"getImage/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.userImage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"User Image\"\r\n");
      out.write("                                            class=\"rounded-circle border border-warning shadow-sm\"\r\n");
      out.write("                                            style=\"width: 50px; height: 50px; cursor: pointer;\" data-bs-toggle=\"modal\"\r\n");
      out.write("                                            data-bs-target=\"#profileImageModal\">\r\n");
      out.write("                                    </li>\r\n");
      out.write("\r\n");
      out.write("                                    <!-- Dropdown Menu -->\r\n");
      out.write("                                    <li class=\"nav-item dropdown mx-3\">\r\n");
      out.write("                                        <a class=\"nav-link dropdown-toggle btn btn-primary text-light\" href=\"#\"\r\n");
      out.write("                                            id=\"userDropdown\" role=\"button\" data-bs-toggle=\"dropdown\"\r\n");
      out.write("                                            aria-expanded=\"false\">\r\n");
      out.write("                                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                                        </a>\r\n");
      out.write("                                        <ul class=\"dropdown-menu dropdown-menu-end\" aria-labelledby=\"userDropdown\">\r\n");
      out.write("                                            <li><a class=\"dropdown-item\"\r\n");
      out.write("                                                    href=\"?emailId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.emailId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Profile</a></li>\r\n");
      out.write("                                            <li><a class=\"dropdown-item\" href=\"getUserLogin\">Log out</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </nav>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- image enlarge card -->\r\n");
      out.write("                <div class=\"modal fade\" id=\"profileImageModal\" tabindex=\"-1\" aria-labelledby=\"profileImageModalLabel\"\r\n");
      out.write("                    aria-hidden=\"true\">\r\n");
      out.write("                    <div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("                        <div class=\"modal-content\">\r\n");
      out.write("                            <div class=\"modal-header\">\r\n");
      out.write("                                <h5 class=\"modal-title\" id=\"profileImageModalLabel\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'s\r\n");
      out.write("                                    Profile</h5>\r\n");
      out.write("                                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\"\r\n");
      out.write("                                    aria-label=\"Close\"></button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"modal-body\">\r\n");
      out.write("                                <div class=\"card\">\r\n");
      out.write("                                    <img src=\"getImage/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.userImage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"card-img-top\"\r\n");
      out.write("                                        alt=\"User Image\">\r\n");
      out.write("                                    <div class=\"card-body text-center\">\r\n");
      out.write("                                        <h5 class=\"card-title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h5>\r\n");
      out.write("\r\n");
      out.write("                                        <!-- <a href=\"editProfile?emailId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verifyUserOtpDto.emailId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"btn btn-primary\">Edit Profile</a> -->\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div class=\"card container-fluid  p-3\" style=\"width:50%; margin:6rem;\">\r\n");
      out.write("                    <form id=\"stationForm\">\r\n");
      out.write("                        <h3 class=\"text-dark justify-content-center py-3\"> Want to book your ticket </h3>\r\n");
      out.write("                        <div class=\"row \">\r\n");
      out.write("\r\n");
      out.write("                            <!-- Source Selection -->\r\n");
      out.write("                            <div class=\" col-md-6 mb-3 \">\r\n");
      out.write("                                <select id=\"sourceId\" class=\"form-select rounded-0 shadow border-warning\" name=\"source\">\r\n");
      out.write("                                    <option value=\"\" disabled selected>Select Source</option>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!-- Destination Selection -->\r\n");
      out.write("                            <div class=\" col-md-6 mb-3  \">\r\n");
      out.write("                                <select id=\"destinationId\" class=\"form-select rounded-0 shadow border-warning\"\r\n");
      out.write("                                    name=\"destination\" onblur=\"checkPrice()\">\r\n");
      out.write("                                    <option value=\"\" disabled selected>Select Destination</option>\r\n");
      out.write("                                    ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                </select>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            \r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"row \">\r\n");
      out.write("                            <div class=\"col-md-4 mb-3 mx-3\">\r\n");
      out.write("                                <h3 id=\"price\" class=\"justify-content-center \"></h3>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <!-- Footer Section -->\r\n");
      out.write("                <footer class=\" text-white py-3 fixed-bottom\" style=\"background-color: rgb(87, 93, 95);\">\r\n");
      out.write("                    <div class=\"container text-center\">\r\n");
      out.write("                        <p class=\"mb-1\">&copy; 2024 Metro Service. All rights reserved.</p>\r\n");
      out.write("                        <nav>\r\n");
      out.write("                            <a href=\"PrivacyPolicy.jsp\" class=\"text-white me-3\">Privacy Policy</a>\r\n");
      out.write("                            <a href=\"TermsOfService.jsp\" class=\"text-white me-3\">Terms of Service</a>\r\n");
      out.write("                        </nav>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </footer>\r\n");
      out.write("\r\n");
      out.write("                <!-- Bootstrap JS -->\r\n");
      out.write("                <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\">\r\n");
      out.write("                </script>\r\n");
      out.write("                <script src=\"https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <script>\r\n");
      out.write("                    const checkPrice = async () => {\r\n");
      out.write("                        var sourceId = document.getElementById(\"sourceId\").value;\r\n");
      out.write("                        var destinationId = document.getElementById(\"destinationId\").value;\r\n");
      out.write("                        console.log(\"source is  =============== \" + sourceId);\r\n");
      out.write("                        console.log(\"destination  is  =============== \" + destinationId);\r\n");
      out.write("                        if (sourceId && destinationId) {\r\n");
      out.write("                            const response = await axios('http://localhost:8083/metro-application/isPriceExists?source=' + sourceId + '&destination=' + destinationId);\r\n");
      out.write("\r\n");
      out.write("                            if (response.data) {\r\n");
      out.write("                                var price = response.data;\r\n");
      out.write("                                console.log(\"response price given is \" + price);\r\n");
      out.write("                                document.getElementById(\"price\").textContent = \"Amount is :-  \"+ price;\r\n");
      out.write("                            } else {\r\n");
      out.write("                                document.getElementById(\"price\").textContent =  \"Amount is:  not found\";\r\n");
      out.write("                            }\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </script>\r\n");
      out.write("            </body>\r\n");
      out.write("\r\n");
      out.write("            </html>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /UserPage.jsp(92,36) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("station");
      // /UserPage.jsp(92,36) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/UserPage.jsp(92,36) '${stationDetailsDtoList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${stationDetailsDtoList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                                        <option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${station.stationName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${station.stationName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                                    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f1_reused = false;
    try {
      _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f1.setParent(null);
      // /UserPage.jsp(102,36) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setVar("station");
      // /UserPage.jsp(102,36) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/UserPage.jsp(102,36) '${stationDetailsDtoList}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${stationDetailsDtoList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
        if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                                        <option name=\"destination\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${station.stationName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${station.stationName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\r\n");
            out.write("                                        </option>\r\n");
            out.write("                                    ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
      _jspx_th_c_005fforEach_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f1_reused);
    }
    return false;
  }
}
