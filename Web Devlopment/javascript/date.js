let myspan=document.getElementById('txt');
//let date=new date();
myspan.innerHTML=date;

console.log(new Date(8.64e15).toString()); // "Sat Sep 13 275760 00:00:00 GMT+0000 (Coordinated Universal Time)"
console.log(new Date(8.64e15 + 1).toString());



var date=new Date();  
let date2=date.getDate();
console.log(date2);
console.log(date.getDay());
console.log(date.getDate());
console.log(date.getFullYear());
console.log(date.getHours());
console.log(date.getMilliseconds());
console.log(date.getMinutes());
console.log(date.getMonth());
console.log(date.getSeconds());

console.log(date.getUTCDate());

date=date.setDate(6);
console.log(date);