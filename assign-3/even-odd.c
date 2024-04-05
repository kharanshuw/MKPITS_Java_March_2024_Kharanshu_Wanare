#include<stdio.h>

void evenodd(int no);

int main()
{
    evenodd(45);
    return 0;
}

void evenodd(int no){
    if (no%2==0)
    {
        printf("this no is even no ");
    }
    else{
        printf("this no is odd no ");
    }
    
}