<%@ page isELIgnored="false"   import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

  <!-- tradtional for loop -->
    <table border="1" bgcolor="cyan">
   <c:forEach var="i"  begin="1"  end="10"  step="1">
          <tr>
            <td>2 * ${i}=</td>
            <td>${2*i} </td>
          </tr>
   </c:forEach>
   </table>

<!--  Enhanced for loop -->
<jsp:scriptlet>
  <![CDATA[
      String names[]=new String[]{"raja","rani","suresh","naresh"};
      request.setAttribute("namesList",names);
      List<String>  sizesList=new ArrayList();
      sizesList.add("M"); sizesList.add("S"); sizesList.add("L"); sizesList.add("XL");
      request.setAttribute("sizesList",sizesList);
      ]]>
</jsp:scriptlet>

<b>the names are :: </b> <br>
   <c:forEach var="name" items="${namesList}">
          ${name} <br>
   </c:forEach>
   <br>
   <b>the sizes are :: </b> <br>
   <c:forEach var="size" items="${sizesList}">
          ${size} <br>
   </c:forEach>
   <br>
   
   
 
