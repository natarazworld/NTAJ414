<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

  <c:choose>
    <c:when  test="${!empty booksList}" >
    	  <h1 style="color:red;text-align:center">Books Beloging to ${param.category} Category  </h1>
    	  <table border="1" align="center" bgcolor="cyan">
    	      <tr>
    	        <th>BookId </th><th> BookName </th><th>Category</th><th>Author </th><th> Price </th><th>Status </th> 
    	      </tr>
          <c:forEach  var="dto" items="${booksList}">              
          <tr>
            	    <td>${dto.bookId}  </td>
            	    <td> ${dto.bookName} </td>
            	    <td>${dto.category}  </td>
            	    <td>${dto.author}  </td>
            	    <td> ${dto.price} </td>
            	    <td> ${dto.status}  </td>
            	  </tr>
         </c:forEach>            	  
    	  </table>
    	  <br>
    <center><a  href="JavaScript:doPrint()">print</a> </center>             
      <script language="JavaScript">
         function doPrint(){
        	  frames.focus();
        	  frames.print();
         }
      </script>
</c:when>
  <c:otherwise>
      	   <h1 style="color:red;text-align:center">Records not found </h1>
  </c:otherwise>        	   
 </c:choose>
                