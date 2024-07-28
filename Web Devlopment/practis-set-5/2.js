let arr=[1,2,3,4,5];

function add_element(arr)
{
    let no=prompt("add a no");
    if(no!=0)
    {
        arr.push(no);
        add_element(arr);
    }
    else{
        arr.push(no);
    }
}


add_element(arr);

console.log(arr);