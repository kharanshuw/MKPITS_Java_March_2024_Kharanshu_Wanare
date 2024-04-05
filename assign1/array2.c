#include<stdio.h>

void myarray();

int main()
{
  myarray();
}

void myarray()
{
    int arr[5];
    for (int i = 0; i < 5; i++)
    {
        printf("enter no for index %d",i);
        scanf("%d",&arr[i]);
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d \n",arr[i]);
    }
    
        
}