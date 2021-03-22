<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

 <!-- For DB connection -->
  <sql:setDataSource  var="ds" 
                                      driver="oracle.jdbc.driver.OracleDriver"
                                      url="jdbc:oracle:thin:@localhost:1521:xe"
                                      user="system"
                                      password="manager"/>
 <!-- For executing SQL query -->
 <sql:query dataSource="${ds}"  var="rs" sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP"  />
 
 <!-- Processs the ResultSEt -->
 <table border="1" align="center">
   <c:forEach  var="row"  items="${rs.rows}">
      <tr>
        <td>${row.empno} </td>
        <td>${row.ename} </td>
        <td>${row.job} </td>
        <td>${row.sal} </td>
      </tr>
   </c:forEach>
 </table>                                      
                                      
 
