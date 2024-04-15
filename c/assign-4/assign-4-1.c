#include<stdio.h>

void sort()
{
    int arr[5]={791,198,229,264,878};
    for (int i = 0; i < 5; i++)
    {
        for (int j = i+1; j < 5; j++)
        {
            if (arr[i]>arr[j])
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            
        }
        
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d \n",arr[i]);
    }
    
}
int main()
{
    sort();
return 0;
}