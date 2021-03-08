<table border="0" width="100%" height="100%"  rows="3" cols="3">
  <tr  height="20%">
    <td colspan="3"><jsp:include page="headerurl"/>   </td>
  </tr>
  <tr  height="70%">
     <td width="20%">
         <%@include  file="menu.html" %>
       </td>
     <td  width="40%"> 
        <jsp:include page="dotnet_content.jsp"/>
      </td>
     <td>  
       <table>
         <tr>
           <td><jsp:include page="sports.jsp"/>  </td>
         </tr>
         <tr>
           <td><jsp:include page="weather_report.jsp"/>  </td>
         </tr>       
       </table>
      </td>
  </tr>
  <tr height="10%">
     <td colspan="3"> <%@include file="footer.html" %> </td>
  </tr>
  

</table>

