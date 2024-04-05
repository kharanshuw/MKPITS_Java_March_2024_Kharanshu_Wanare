#include<stdio.h>
void median();
int main()
{
    median();
return 0;
}
void median()
{
    int arr[5]={10,5,20,15,25};
    int count=0;
    int midno=0;
    int mymidian=0;
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 4-i; j++)
        {
            if (arr[j]>arr[j+1])
        {
            int temp=arr[j];
            arr[j]=arr[j+1];
            arr[j+1]=temp;
        }                        
            
    }
        
    }
    
    count=sizeof(arr)/sizeof(arr[0]);

    if (count%2 != 0)
    {
        midno=count/2;
        mymidian=(arr[midno]+arr[midno+1])/2;
        printf(mymidian);
    }
    else
    {
        mymidian=arr[midno];
    }
    
    
    
}