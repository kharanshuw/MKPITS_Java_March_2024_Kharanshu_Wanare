#include<stdio.h>

void palindromecheck()
{
    int start=0;
    int end=4;
    int arr[5]={10,20,30,20,10};
    while (start<end)
    {
        if (arr[start]==arr[end])
        {
            start++;
            end--;
        }
        else if (arr[start]!=arr[end])
        {
            printf("not palindrome");
            break;
        }
        
        printf("is palindrome");
        break;
        
    }
    
    
}
int main()
{
    palindromecheck();
return 0;
}
