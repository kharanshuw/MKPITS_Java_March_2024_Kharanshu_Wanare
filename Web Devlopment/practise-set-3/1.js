let obj={
    a:98,
    b:70,
    c:85
}
let result=Object.entries(obj);
console.log(result)
for (const r of result) {
    console.log("key is: "+r[0]+" value is"+r[1]);
}