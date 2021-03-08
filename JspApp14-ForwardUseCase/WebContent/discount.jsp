
<%
  //read form data from request object and also  addtional req param value
    String iname=request.getParameter("iname");
     float price=Integer.parseInt(request.getParameter("iprice"));
     float qty=Integer.parseInt(request.getParameter("iqty"));
     float billAmt=Float.parseFloat(request.getParameter("bamt"));
      //calcuate   discount  amount and final amount
      float  discount=billAmt*0.2f;
      float  finalAmount=billAmt-discount;
%>
  <!-- Disply Bill details -->
  <h1 style="color:red;text-align:center">Bill Details are</h1>
  
  <b> Item  name ::  <%=iname %>  </b> <br>
   <b> Item price ::  <%=price %>  </b> <br>
    <b> Item qty ::  <%=qty %>  </b> <br>
    <b> Bill amount ::  <%=billAmt %> </b> <br>
    <b> Discount :: <%=discount %></b> <br>
    <b> Final amount :: <%=finalAmount %></b> <br>
    
     <br><br>  <a href="form.html"> home</a>       
    
