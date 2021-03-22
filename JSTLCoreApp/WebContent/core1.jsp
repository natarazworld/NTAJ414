<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!-- creating data having scope and name -->
<c:set var="msg"  value="welcome to jsp"  scope="request"/>
<!-- display the message -->
 value ::<c:out value="${msg}"/>  &nbsp;&nbsp;&nbsp;  value::  ${msg}   <br>
 <!-- remove the data from scope -->
 <c:remove var="msg" scope="request"/>
<!-- display the message -->
 value ::<c:out value="${msg}"/>  &nbsp;&nbsp;&nbsp;  value::  ${msg}  <br>
 

