#include<stdio.h>
int bigno(int a,int b,int c);
int main()
{
    int result=0;
    result=bigno(5,6,7);
    printf("%d",result);
    return 0;
}

int bigno(int a,int b,int c)
{
    int result=0;
    if (a>b && a>c)
    {
       result=a;
    }
    else if(b>a && b>c)
    {
        result=b;
    }
    else if(c>a && c>b)
    {
        result=c;
    }
    else
    {
        printf("all are equal");
    }
    return result;
}
