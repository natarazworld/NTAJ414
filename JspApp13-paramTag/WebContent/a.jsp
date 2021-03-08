

  <b> from a.jsp</b>
  
  <% float radius=5.77f;
        float  area=3.14f*radius*radius;  %>
   
   <!-- forwarding request -->
   <jsp:forward  page="b.jsp">
       <jsp:param name="bkName" value="CRJ"/>
       <jsp:param value="<%=area%>" name="carea"/>
   </jsp:forward>         
        