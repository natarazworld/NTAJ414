


<b> from c.jsp</b>
  <br>
   <b> attr1 (pagescope) value :: <%=pageContext.getAttribute("attr1") %></b> <br>
   <b> attr1 (pagescope) value :: <%=pageContext.findAttribute("attr1") %></b> <br>
   <hr>
   <b> attr2 (request scope) value :: <%=request.getAttribute("attr2") %></b> <br>
   <b> attr2 (request scope) value :: <%=pageContext.getAttribute("attr2",pageContext.REQUEST_SCOPE) %></b> <br>
   <b> attr2 (request scope) value :: <%=pageContext.findAttribute("attr2") %></b> <br>
   <hr>
   <b> attr3 (session scope) value :: <%=session.getAttribute("attr3") %></b> <br>
   <b> attr3 (session scope) value :: <%=pageContext.getAttribute("attr3",pageContext.SESSION_SCOPE) %></b> <br>
   <b> attr3 (session scope) value :: <%=pageContext.findAttribute("attr3") %></b> <br>
   
   <hr>
   <b> attr4 (application scope) value :: <%=application.getAttribute("attr4") %></b> <br>
   <b> attr4 (application scope) value :: <%=pageContext.getAttribute("attr4",pageContext.APPLICATION_SCOPE) %></b> <br>
   <b> attr4 (application scope) value :: <%=pageContext.findAttribute("attr4") %></b> <br>
   
   
   
       