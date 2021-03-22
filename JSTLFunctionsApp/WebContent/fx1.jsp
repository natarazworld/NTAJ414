<%@page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<c:set var="msg"  value="welcome to JSTL" />

 length ::  ${fn:length(msg)} <br>
 uppcase ::  ${fn:toUpperCase(msg)} <br>
lowercase ::  ${fn:toLowerCase(msg)} <br>
 substring ::  ${fn:substring(msg,0,8)} <br>
  starts with "welcome"?  ${fn:startsWith(msg,"welcome")} <br>



