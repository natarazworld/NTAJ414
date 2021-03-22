<%@ page isELIgnored="false"   import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<b> all request headers and values are</b>
<br>
 <c:forEach  var="h" items="${headerValues}" >
      header name :: ${h.key} <br>
      header values are ::
    <c:forEach  var="hv"  items="${h.value}">
         ${hv} &nbsp;&nbsp; 
    </c:forEach>      
      <br>
 </c:forEach>   
 
