

<b>from a.jsp</b>
<!-- create different scopes of attributes-->
<%
  pageContext.setAttribute("attr1", "val1"); //default scope is page scope
  pageContext.setAttribute("attr2", "val2",pageContext.REQUEST_SCOPE); //request scope
  pageContext.setAttribute("attr3", "val3",pageContext.SESSION_SCOPE); //session scope
  pageContext.setAttribute("attr4", "val4",pageContext.APPLICATION_SCOPE); //application scope
%>
<!-- forwarding request to b.jsp  -->
<jsp:forward page="b.jsp"/>