/*function function1(x){
    return x*x;
}

let y=function1(5);
console.log(y);
*/
//Object by object literal
// let school={
//     schoolname:"abcd",
//     location:'nagpur',
//     established:'1971',
//     displayinfo: function () {
//         console.log("name of school is "+ school.schoolname+" location is "+school.location+ "established in "+this.established);
//     }
// }

// console.log(school);

// console.log(school.displayinfo())

/*

object with new keyword
let school=new Object();

school.schoolname='priyadarshni';
school.esablished='1971';
school.location='nagpur';
school.details=function(){
    console.log("school name " +school.schoolname+" established in :"+school.esablished+" location : "+school.location);
}


console.log(school.details());

object with constructor
function myobject(title,price){
    this.price=price;
    this.title=title;
}

myobject1=new myobject("let us c",450);
console.log(myobject);
console.log(myobject.title);

*/

/*
defining method in JavaScript Object
function book(title,price)
{
    this.title=title;
    this.price=price;
    this.changeprice=changeprice;
  function changeprice(p)
    {
        this.price=p;
    }   
}

b=new book("let us c",450);

console.log(b.title);
console.log(b.price);
b.changeprice(850);
console.log(b.price);

*/

/*
object assign method
let obj1={
    a:1,
    b:2,
    c:3
}

let obj2=Object.assign({c:9,d:10},obj1);

console.log(obj2);


*/

/*object assign method
let obj1={
    a:1,
    b:2,
    c:3
}

let obj2=Object.assign({c:9,d:10},obj1);

console.log(obj2);
*/

/* 
 */

let obj1={
    title:'let us c',
    price:700
}
let obj2={};
Object.create(obj1);
console.log(obj2);