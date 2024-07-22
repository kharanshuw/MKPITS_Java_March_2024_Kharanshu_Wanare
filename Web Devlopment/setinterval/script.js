let myInterval=setInterval(displayHello, 500);

function displayHello() {
  document.getElementById("demo").innerHTML += "Hello";
  console.log("hello");
}

function myStop() {
    clearInterval(myInterval);
  }

function clearInterval(){
    myInterval();
}