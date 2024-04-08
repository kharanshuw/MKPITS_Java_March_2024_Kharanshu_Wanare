#include<stdio.h>

void buuble_sort()
{
    int arr[5]={10,60,20,90,88};


    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5-i-1; j++)
        {
            if (arr[j]>arr[j+1])
            {
            int temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
            }         
        }
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d ",arr[i]);
    }
    
    
}
int main()
{
    buuble_sort();
    return 0;
}