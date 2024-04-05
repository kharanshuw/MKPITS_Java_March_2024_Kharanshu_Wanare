#include<stdio.h>

void secondlargest(){
    int largest=0,secondlargest=0;
    int arr[5]={10,20,90,40,50};
    if (arr[0]>arr[1])
    {
        largest=arr[0];
        secondlargest=arr[1];
    }
   else if (arr[1]>arr[0])
    {
        largest=arr[1];
        secondlargest=arr[0];
    }

    for (int i = 2; i < 5; i++)
    {
        if (arr[i]>largest)
        {
           secondlargest=largest;
           largest=arr[i];
        }
        else if (secondlargest<arr[i])
        {
            secondlargest=arr[i];
        }
        
        
    }
    printf("%d",secondlargest);
    
    
}

int main()
{
    secondlargest();
    return 0;
}