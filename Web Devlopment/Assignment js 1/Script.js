
function rotate(arr,start,end)
{
    while (start < end) {
        [arr[start], arr[end]] = [arr[end], arr[start]]; 
        start++;
        end--;
      }  
}

function rotateArray(arr, k) {
    let n =arr.length; 
    rotate(arr,0,n-1);
    rotate(arr,0,k-1);
    rotate(arr,k,n-1)

    return arr;
}



const arr = [1, 2, 3, 4, 5];
const k = 2;

const rotatedArr = rotateArray(arr, k);
console.log(rotatedArr); 
