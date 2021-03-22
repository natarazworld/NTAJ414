<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

 <c:set var="msg" value="welcome"  scope="request"/>
 
 <c:if test="${!empty param.uname}">
       <c:out value="${msg}"/> &nbsp; <c:out value="${param.uname}"/> <br>
       ${msg}  &nbsp;${param.uname}
 </c:if>
 
 
 
 
