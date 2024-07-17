/*let arr1=['arun','arjun','ratan'];

console.log(arr1);

let arr2=new Array();
arr2[0]="abc";
arr2[1]=44;
arr2[3]='rr';

console.log(arr2);

let arr3=new Array('abc','def');

console.log(arr3);


let x=arr1.concat(arr2,arr3);
console.log('array concat is'+x);
console.log(typeof x);
*/
/*JavaScript Array copyWithin() method

The JavaScript array copyWithin() method copies the part of the given array with its own elements and returns the modified array. This method doesn't change the length of the modified array.

var arr=["AngularJS","Node.js","JQuery","Bootstrap"]  
// place at 0th position, the element between 1st and 2nd position.
let result=['abc'];
arr.copyWithin(2,1,2);  
console.log(arr);  

*/


/*
var arr=['John','Michael','Embrose','Herry','Lewis'];  
var itr=arr.entries();  
document.write("After applying the entries method:"+"<br>");  
console.log(itr);
for(var e of itr) //for loop using var.  
{  
    console.log(e);  
}  
*/
/*

var marks=[50,40,45,37,20];
function check(value)  
{  
  return value>30; 
}  
  
document.writeln(marks.every(check));  

*/
/*
var arr=['a','b',['c','d'],['e','g','a','c','d'],'f']; //given 2D array  
var newArr=arr.flat(); //using flat() method  
document.write("After flattening the array:  "+newArr);  
*/
/*

var arr=["AngularJS","Node.js","JQuery"];  
var result=arr.fill("Bootstrap");  
document.writeln(arr);  

var arr=["AngularJS","Node.js","JQuery"];  
var result=arr.fill("Bootstrap",0,1);  
document.writeln(arr); 

*/

let arr1=['abc','def','gih'];

let arr2=Array.from(arr1);
console.log(arr2);