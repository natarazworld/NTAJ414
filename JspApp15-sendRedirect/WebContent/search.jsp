<%@ page isELIgnored="true" %>

<%
  //read form data
  String ss=request.getParameter("ss");
//perform sendRirection with Google
   response.sendRedirect("https://www.google.com/search?q="+ss);
%>

 