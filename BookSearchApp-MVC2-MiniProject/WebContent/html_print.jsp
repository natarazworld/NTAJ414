<%@page isELIgnored="false"  import="java.util.*, com.nt.dto.BookDetailsDTO"  %>

<%
    //read results from  request scope
     List<BookDetailsDTO> list=(List<BookDetailsDTO>)request.getAttribute("booksList");
     String  category=request.getParameter("category");
     
     if(list!=null && list.size()!=0){  %>
    	  <h1 style="color:red;text-align:center">Books Beloging to <%=category %> Category  </h1>
    	  <table border="1" align="center" bgcolor="cyan">
    	      <tr>
    	        <th>BookId </th><th> BookName </th><th>Category</th><th>Author </th><th> Price </th><th>Status </th> 
    	      </tr>
          <%
              for(BookDetailsDTO dto:list){   %>
            	  <tr>
            	    <td><%=dto.getBookId() %>  </td>
            	    <td><%=dto.getBookName() %>  </td>
            	    <td><%=dto.getCategory() %>  </td>
            	    <td><%=dto.getAuthor() %>  </td>
            	    <td><%=dto.getPrice()%>  </td>
            	    <td><%=dto.getStatus()%>  </td>
            	  </tr>
   <%    }//for
          %>    	      
    	  </table>
    	  <br>
    <center><a  href="JavaScript:doPrint()">print</a> </center>             
      <script language="JavaScript">
         function doPrint(){
        	  frames.focus();
        	  frames.print();
         }
      </script>
   <%    } //if
         else{  %>
        	   <h1 style="color:red;text-align:center">Records not found </h1>
       <%  }
             %>

                