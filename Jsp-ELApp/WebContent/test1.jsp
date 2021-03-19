<%@page isELIgnored="false"  %>

  uname requset param value ::  ${param.uname}  <br>

  address request param values : ${paramValues.addrs[0]}, ${paramValues.addrs[1]}  <br>
<hr>
   user-agent request header value ::  ${header['user-agent']} <br>
   accept request header values  ::  ${headerValues.accept[0]},${headerValues.accept[1]}
   
   <hr>
    Cookie name :: ${cookie.JSESSIONID.name } <br>
    Cookie value :: ${cookie.JSESSIONID.value } <br>
    <hr>
      context param dbuser value :: ${initParam.dbuser} 
      context param dbpwd value :: ${initParam.dbpwd} 
      
    