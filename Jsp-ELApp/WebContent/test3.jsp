<%@ page isELIgnored="false" %>
 
 <%
   pageContext.setAttribute("attr0", "val0",pageContext.PAGE_SCOPE);
 %>
 
 <!-- Read and display different scope of attribute values -->
    attr0 (pageScope) value ::  ${pageScope.attr0} <br>
    attr1 (requestScope) value ::  ${requestScope.attr1} <br>
    attr2 (sessionScope) value ::  ${sessionScope.attr2} <br>
    attr3 (applicationScope) value ::  ${applicationScope.attr3} <br>
    
    