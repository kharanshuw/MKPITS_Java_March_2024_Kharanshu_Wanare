let arr1=[1,2,3,4,5,6,7,9];

let arr2=[];

for (let index = 0; index < arr1.length; index++) {
    const element = arr1[index];
    arr2.push(element*element);
}

console.log("sq of all element present in arr1 ="+" " +arr2);