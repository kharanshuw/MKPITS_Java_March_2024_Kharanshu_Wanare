
let username = document.getElementById('myname');
let address = document.getElementById('address');
let email = document.getElementById('email');
let password = document.getElementById('password');
let contact = document.getElementById('contact');
let confirmpassword=document.getElementById('password2');
let nameerror = document.getElementById('name-error');
let addresserror = document.getElementById('address-error');

let emailerror = document.getElementById("email-error");
let passworderror = document.getElementById('password-error');
let myform = document.getElementById('myform');
let isvalid = false;




function isEmpty(value) {
  return value === null || value.trim() === "";
}


function validateform(event) {
  event.preventDefault();

  let email_regex_pattern = '^[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$';
  let regexmail = new RegExp(email_regex_pattern);

  // Validate email format
  if (regexmail.test(email.value) == false) {
    alert("Invalid email format!");
    return false;
  }

  // Validate password length
  if (password.value.length < 8) {
    alert("Password must be at least 8 characters long!");
    return false;
  }

  // Validate contact number length (modify if needed)
  if (contact.value.length !== 10) { // Use strict comparison (===)
    alert("Contact number should be exactly 10 digits!");
    return false;
  }

  // Check for empty fields (moved to the bottom)
  if (isEmpty(password.value) || isEmpty(username.value) || isEmpty(address.value) || isEmpty(email.value ) || isEmpty(contact.value)) {
    alert("Please fill out all required fields!");
    return false;
  }

  // If all validations pass, form submission logic can go here
  alert("Form submitted successfully!"); 
  return true;
}













































/*

function testing(){
  let email_regex_pattern=' ^[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$'
  let regexmail=new RegExp(email_regex_pattern);

  if(regexmail.test(email)==false){
    alert ("email format is wrong")
  }
}

*/

/*function validatename(username){
     let message ='';
     //check username empty or not
  if (username==='' || username.length===0) {
    console.log("do not leave username empty");
    nameerror.innerHTML="username must not be empty";
    return false;
  }

  // Check username length
  if (username.length < 3 || username.length > 20) {
    result=false
    message="Username must be between 3 and 20 characters long."
    nameerror.innerHTML=message;
    return false;
  }

  // Loop through each character and validate
  for (let i = 0; i < username.length; i++) {
    const char = username[i];
    const isValidChar = (char >= 'a' && char <= 'z') ||
                       (char >= 'A' && char <= 'Z') ||
                       (char >= '0' && char <= '9') ||
                       char === '_' || char === '-';
    if (!isValidChar) {
        result=false;
        message="Username can only contain letters (a-z, A-Z), numbers (0-9), underscores (_), and hyphens (-)."
        nameerror.innerHTML=message;
      return false;
    }
  }
  return true;
}

function validateaddress(address){
  if(address.length==0 || address=='')
    {
      console.log("address should not be empty");
      addresserror.innerHTML="address should not be empty";
      return false;
    }
    else{
      return true;
    }
}

myform.addEventListener('submit',function(e){
    e.preventDefault();
    isvalid=true;
    let validatenameresult=validatename(username);
    console.log(validateaddress);

})

*/

/*
function validateform(event) {
  event.preventDefault();
    let email_regex_pattern = ' ^[a-zA-Z0-9._%±]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$'
  let regexmail = new RegExp(email_regex_pattern);

  if ( isEmpty(password) || isEmpty(username) || isEmpty(address) || isEmpty(email) || isEmpty(contact) || isEmpty(conf) )
  {
    alert("do not leave any field empty");
    return false;
  }
  else if (regexmail.test(email) == false) {
    alert("email format is wrong")
    return false;
  }

  else if(password.length<8){
    alert ("password length must be greter than 8 ");
  }

  else if(contact.length<10){
    alert("contact no should be exactly 10 digit")
  }



  return true;
}
*/
