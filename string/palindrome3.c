#include<stdio.h>
#include<string.h>

void palindromecheck3();
int main()
{
    palindromecheck3();
}

void palindromecheck3()
{
     char str[20]={"abcba"};
     char str2[20];
     int i,j;
     int palindrome=1;
    int length=0;
    length=strlen(str);
    
    for (i=length-1,j=0;j<=length-1,i>=0;i--,j++)
    {
        str2[j]=str[i];
    }
    palindrome=strcmp(str2,str);
   
   if (palindrome==0)
   {
    printf("string is palindrome");
   }
   else
   {
    printf("string is not palindrome");
   }
    

}