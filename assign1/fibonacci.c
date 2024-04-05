#include<stdio.h>

void fibonacci();
int main()
{
    fibonacci(8);
}

void fibonacci(int x)
{
    int n,f,f1,f2;
    f1=-1;
    f2=1;
    printf("fibonacci series");
    do{
        f=f1+f2;
        f1=f2;
        f2=f;
        printf("\n %d",f);
        x--;
    }while(x>0);
    
}