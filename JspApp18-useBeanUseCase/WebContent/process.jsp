
<%@page import="com.nt.dto.*, com.nt.service.*" %>

<!-- create /Locate DTO class object class obj -->
 <jsp:useBean id="dto"   class="com.nt.dto.EmployeeDetailsDTO"  scope="request"/>
 
 <!-- Write the recived form data to DTO class object -->
 <jsp:setProperty name="dto"   property="*"/>
 
 <!-- create /Locate service class object -->
 <jsp:useBean id="service"  class="com.nt.service.SalaryDetailsGeneratorImpl"  scope="application"/>
 
 <%
    //invoke the business method
         service.generateSalaryDetails(dto);
 %>
 
 <!-- Display salary deteials -->
 
   <table border="1"  align="center"  bgcolor="cyan">
      <caption> Salay Details   are</caption>
       <tr>
         <td>Employee name::  </td>
         <td><jsp:getProperty property="ename" name="dto"/>  </td>
       </tr>
        <tr>
         <td>Employee Desg::  </td>
         <td><jsp:getProperty property="desg" name="dto"/>  </td>
       </tr>
        <tr>
         <td>Employee Basic Salary::  </td>
         <td><jsp:getProperty property="bsalary" name="dto"/>  </td>
       </tr>
       <tr>
         <td>Employee Gross Salary::  </td>
         <td><jsp:getProperty property="grossSalary" name="dto"/>  </td>
       </tr>
       <tr>
         <td>Employee Net Salary::  </td>
         <td><jsp:getProperty property="netSalary" name="dto"/>  </td>
       </tr>
   </table>

<br><br>
<a href="employee_form.html">home</a>
