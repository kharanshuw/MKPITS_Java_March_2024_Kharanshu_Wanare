function myfunction3(){
    alert("hello from external js");
}
function m(){  
    window.x=100;//declaring global variable by window object  
    }  

//  m();
    
//accessing global variable from other function  
// console.log(window.x);


function myfunction4(){
   let x= prompt("enter your name");
   alert(x);
}

// myfunction4();

function myfunction5(){
    let x = prompt("enter marks");
    if(x>35){
        alert("you are pass");
    }
    else
    {
        alert("you are fail")
    }
}

// myfunction5();



   

  function myfunction6() {
    let tableBody = document.querySelector('.mytbody');
    for (let i = 0; i < 11; i++) {
      let element1=i;
        for (let index = 1; index < 11; index++) {
            let element = element1 * index;
            let tableRow = `<tr><td>${element}</td></tr>`; 
            tableBody.innerHTML += tableRow;
          }
        
    }
    
  }
//  myfunction6();


 function printPyramid(rows) {
    for (let i = 1; i <= rows; i++) {
      let row = "";
  
      for (let j = 1; j <= rows - i; j++) {
        row += " ";
      }
  
      for (let k = 1; k <= 2 * i - 1; k++) {
        row += "*";
      }
  
      console.log(row);
    }
  }
  
  const rows = 5;
  
  printPyramid(rows);
  

  function printRightPyramid(rows, containerId) {
    const container = document.getElementById(containerId);
    let pyramidContent = "";

    for (let i = 1; i <= rows; i++) {
      let row = "";
    //   for (let j = 1; j <= rows - i; j++) {
    //     row += " ";
    //   }
      for (let k = 1; k <= i; k++) {
        row += "*";
      }
      pyramidContent += row + "<br>"; 
    }

    container.innerHTML = pyramidContent;
  }

  const pyramidRows = 5; 
  printRightPyramid(pyramidRows, 'pyramid-container');
