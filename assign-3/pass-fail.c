#include<stdio.h>

void result(int marks);

int main()
{
    int no;
    printf("enter no");
    scanf("%d",&no);
    result(no);
    return 0;
}

void result(int marks)
{
    if (marks>=50)
    {
        printf("pass");
    }
    else
    {
        printf("fail");
    }
    
}
