let no=9;
let arr=[9,1,5,7,8];
function calculateFactorial(fact,number){
    for (let index = 1; index <= number; index++) {
        fact=fact*no;
    }
    console.log(fact+"factorial of "+number);
}
let fact=1;
arr.reduce((accu,current)=>{
    fact=1;
    for (let index = 1; index <= current; index++) {
        fact=fact*index;
    }
    console.log(fact+"factorial of "+current);
},1);
