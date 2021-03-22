<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

 <fmt:setLocale value="hi-IN"/>
 
 <!-- format the number -->
 <fmt:formatNumber var="fnumber"  value="4000656564"   type="currency"/>
 <br>
  Formatted number is :: ${fnumber} <br>
  
  <!-- format date -->
  <jsp:useBean id="dt"  class="java.util.Date"/>
 <fmt:formatDate var="fdt"  value="${dt}"  type="both"  />
 <br>
 Formatted date is :: ${fdt} <br>
 
 <fmt:setBundle basename="com/nt/commons/App"/>
 <fmt:message key="welcome.msg" var="msg1"/>
 <fmt:message key="goodbye.msg" var="msg2"/>
  Message1 :: ${msg1}  &nbsp;&nbsp;  Message2 :: ${msg2}
 
 
 
 
   
