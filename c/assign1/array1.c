#include<stdio.h>

void myarray();

int main()
{
  myarray();
}

void myarray()
{
    int num[5]={10,20,30,40,50};
    for (int i = 0; i < 5; i++)
    {
        printf("array values %d ",num[i]);

    }
    
}