
<!-- <%!  public  String  generateWishMessage(String user){
	    //get System Date and time
	    java.util.Calendar cal=java.util.Calendar.getInstance();
	    // get current hour of the day
	    int hour=cal.get(java.util.Calendar.HOUR_OF_DAY);  //24 hrs form
	    //generate wish message
	      if(hour<12)
	    	  return "Good Morning ::"+user;
	    else if(hour<16)
	    	return "Good afternoon ::"+user;
	    else if(hour<20)
	    	return "Good evening ::"+user;
	    else 
	    	return "Good nignt ::"+user;  
}
%>   -->

<%-- <h1 style="color:red;text-align:center">Welcome to    jsp pages  </h1> <br> --%>
<h1 style="color:green;text-align:center"> Date and time ::  <%=new java.util.Date() %> <br>

<%  String  user=request.getParameter("uname"); %>
<br>
<h3 style="color:green;text-align:center"> The Wish Message is ::  <%=generateWishMessage(user) %> 
 <br>
 <!-- request object class name :: --> <%=request.getClass() %> <br>
  out object object class name ::  /*  <%=out.getClass() %>  */ <br> 
 

 

