const myTimeout = setTimeout(myGreeting, 500);

function myGreeting() {
  document.getElementById("demo").innerHTML = "Happy Birthday!"
  console.log("calling timeour");
}


function myStopFunction() {
  clearTimeout(myTimeout);
}


function startimeout(){
myTimeout();
}