#include <stdio.h>

void selection()
{
    int arr[5] = {10, 60, 20, 90, 88};

    for (int i = 0; i < 5-1; i++)
    {
        for (int j = i+1; j <5 ; j++)
        {
           if (arr[i]>arr[j])
           {
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
           }
           
        }
        
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d ", arr[i]);
    }
}
int main()
{
    selection();
    return 0;
}