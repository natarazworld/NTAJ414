<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

 <!-- For DB connection -->
  <sql:setDataSource  var="ds" 
                                      driver="oracle.jdbc.driver.OracleDriver"
                                      url="jdbc:oracle:thin:@localhost:1521:xe"
                                      user="system"
                                      password="manager"/>
<!-- Execute non-select SQL query --> 
 <sql:update  dataSource="${ds}"  sql="UPDATE EMP SET  SAL=SAL+?  WHERE EMPNO=? "  var="count">
    <sql:param value="1000"/>
    <sql:param>7499</sql:param>
 </sql:update>
 <b> no.of records that are effected :: ${count}</b>
 
