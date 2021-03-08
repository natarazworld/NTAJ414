

<%
   //read form data
     String iname=request.getParameter("iname");
     float price=Integer.parseInt(request.getParameter("iprice"));
     float qty=Integer.parseInt(request.getParameter("iqty"));
     //calculate bill amount
       float  billAmt=price*qty;
       if(billAmt>=50000){
%>
        <jsp:forward page="discount.jsp">
            <jsp:param name="bamt"  value="<%=billAmt %>"/>
        </jsp:forward> 
 <%
       }//if
       else{  %>
    	   <h1 style="color:red;text-align:center">Bill Details </h1>
    	      <b> Item  name ::  <%=iname %>  </b> <br>
    	       <b> Item price ::  <%=price %>  </b> <br>
    	       <b> Item qty ::  <%=qty %>  </b> <br>
    	       <b> Bill amount ::  <%=billAmt %> </b> <br>
   <%      }
               %>        
               
 <br><br>  <a href="form.html"> home</a>               