function validate(frm){
	 alert("client side...")
     //empty the form validation error messages
      document.getElementById("nameErr").innerHTML="";
      document.getElementById("ageErr").innerHTML="";
	
       //read form data
       let name=frm.pname.value;
       let age=frm.page.value;
       let  flag=true;
       //client side form validation logic
       if(name==""){  //required rule
        document.getElementById("nameErr").innerHTML="<i>person name is required</i>";
        frm.pname.focus(); //text box gains the focus
        flag=false;
       }
       else if(name.length<5){  // min length
          document.getElementById("nameErr").innerHTML="person name must have min of 5 chars";
          frm.pname.focus(); //text box gains the focus
          flag=false;
       }
       
       if(age==""){   //required rule
           document.getElementById("ageErr").innerHTML="person age is required";
           frm.page.focus();
           flag=false;
       }
       else if(isNaN(age)){   //numer value rule
          document.getElementById("ageErr").innerHTML="person age must be numeric value";
           frm.page.focus();
           flag=false;
       }
       else if(age<1  || age>125){  // age range rule
          document.getElementById("ageErr").innerHTML="person age must be between 1 throuhg 125";
           frm.page.focus();
           flag=false;
       }
       //change  vflag (hidden box) value to "yes"  to indicate client side form validations are done
         frm.vflag.value="yes"; 
       return flag;    //true --> no form validations , false for form validation errors
    }//function
