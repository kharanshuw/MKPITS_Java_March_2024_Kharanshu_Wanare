#include<stdio.h>
void bigno(int a,int b);
int main()
{
    bigno(6,5);
    return 0;
}

void bigno(int a,int b)
{
    if (a>b)
    {
       printf("%d is bigger than %d",a,b);
    }
    else if (b>a)
    {
        printf("%d is bigger than %d",b,a);
    }
    else
    {
        printf("both are equal");
    }
    
}