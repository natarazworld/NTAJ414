<%@ page isELIgnored="false"   import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<b> all request params and values are</b>
<br>
 <c:forEach  var="p" items="${paramValues}" >
      param name :: ${p.key} <br>
      param values are ::
    <c:forEach  var="pv"  items="${p.value}">
         ${pv} &nbsp;&nbsp; 
    </c:forEach>      
      <br>
 </c:forEach>   
 
