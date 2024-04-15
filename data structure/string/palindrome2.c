#include<stdio.h>
void palindromecheck();
int main()
{
    palindromecheck();
}

void palindromecheck()
{
     char str[20]={"abcba"};
     char str2[20];
     int i,j;
     int palindrome=1;
    int length=0;
    while (str[length] != '\0')
    {
        length=length+1;
    }
    for (i=length-1,j=0;j<=length-1,i>=0;i--,j++)
    {
        str2[j]=str[i];
    }
    str2[j]='\0';

    for (int k = 0; k < length-1; k++)
    {
        if (str2[k] != str[k])
        {
            palindrome=0;
            break;
        }
        
    }

    if (palindrome==1)
    {
        printf("is palindrome");
    }
    else if (palindrome == 0)
    {
        printf("not palindrome");
    }
    
    
    
}