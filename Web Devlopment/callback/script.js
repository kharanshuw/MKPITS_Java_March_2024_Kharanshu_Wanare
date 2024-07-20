 
function getData(x, y, callback){  
document.write(" The multiplication of the numbers " + x + " and " + y + " is: " + (x*y) + "<br><br>" );  
callback();  
}  
function showData(){  
document.write(' This is the showData() method execute after the completion of getData() method.');  
}  
//getData(20, 30, showData);  

function showData1(name, amt) {  
    alert(' Hello ' + name + '\n Your entered amount is ' + amt);  
    }  
      
    function getData1(callback) {  
    var name = prompt(" Welcome to the javaTpoint.com \n What is your name?");  
    var amt = prompt(" Enter some amount...");  
    callback(name, amt);  
    }  
      
    getData1(showData);  