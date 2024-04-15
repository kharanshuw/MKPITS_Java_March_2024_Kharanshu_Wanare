//c program to find occurence of each element in array
#include<stdio.h>
void occurenced()
{
    int arr[10]={10,10,50,60,10,90,50,60,90,60};
    int freq[10]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    for (int i = 0;i < 10;i++)
    {
        int count=1;
        for (int j = i+1; j < 10; j++)
        {
            if (arr[i]==arr[j])
            {
                count=count+1;
                freq[j]=0;
            }
            if (freq[i]!=0)
            {
                freq[i]=count;
            }            
        }     
    }

    for (int i = 0; i < 10; i++)
    {
        if (freq[i]!=0)
        {
            printf("%d occurs %d times\n", arr[i], freq[i]);
        }
        
    }
    
    
}
int main()
{
    occurenced();
    return 0;
}