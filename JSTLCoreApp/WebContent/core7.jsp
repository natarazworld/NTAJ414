<%@ page isELIgnored="false"   import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- Define  URL -->
<c:url  var="googleUrl"  value="https://www.google.com/search"  scope="request"/>

<!-- Perform sendRedirection -->
<c:redirect url="${googleUrl}"/> 
