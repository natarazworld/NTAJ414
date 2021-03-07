


<h1 style="color:red;text-align:center">Html to Servlet to DB communication using Approach3</h1>

<h1 style="color:red;text-align:center">Customer Registration Form</h1>

<form action="customerurl" method="POST">
  <table border="1">
       <tr>
          <td>Customer name::  </td>
          <td><input type="text" name="cname">  </td>
       </tr>
       <tr>
          <td>Customer Address::  </td>
          <td><input type="text" name="cadd">  </td>
       </tr>
       <tr>
          <td>Customer BillAmt::  </td>
          <td><input type="text" name="billAmt">  </td>
       </tr>
       <tr>
          <td colspan="2"><input type="submit" value="Register Customer"/> </td>
       </tr>
  </table>
       <input type="hidden"  name="cToken"  value="${sessionScope.sToken}" />

</form>
