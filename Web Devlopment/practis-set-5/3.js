let arr=[20,30,40,54,28,90,63,10];

for (let index = 0; index < arr.length; index++) {
    const element = arr[index];
    if(element%10==0){
        console.log(element+" "+"from arr is divisible by 10");
    }
}
