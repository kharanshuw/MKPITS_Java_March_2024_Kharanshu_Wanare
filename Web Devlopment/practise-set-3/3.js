let x;
function callingprompt(){
    x=prompt("enter no ");
if(x==5){
    document.write("correct no")
}
else 
{
    document.write("try again")
    callingprompt()
}
}

callingprompt();