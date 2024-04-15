//7. Find duplicates in an array

#include<stdio.h>

void remove_duplicate();

int main()
{
    remove_duplicate();
}

void remove_duplicate(){
    int arr1[5]={1,6,3,3,1};
    int arr2[5];
    int x,count=0;
    for (int i = 0; i < 5; i++)
    {
        int index=i;
        for (int j =i+1; j < 5; j++)
        {
            if (arr1[j]<arr1[i])
            {
                index=j;
            }
            
        }
        int smallestnpo=arr1[i];
        arr1[i]=arr1[index];
        arr1[index]=smallestnpo;          
    }
    // for (int i = 0; i < 5; i++)
    // {
    //     printf("%d",arr1[i]);
    // }

    for (int i = 0; i < 5; i++)
    {
        if (arr1[i]==0)
        {
            continue;
        }

        for (int j = i+1; j < 5; j++)
        {
            if (arr1[i]==arr1[j])
            {
                arr1[j]=0;
            }
        }     
    }
    for (int i = 0; i < 5; i++)
    {
        printf("%d",arr1[i]);
    }
    
    
    
    
}