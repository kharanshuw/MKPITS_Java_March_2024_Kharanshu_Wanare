#include <stdio.h>
#include<string.h>
void palindrome()
{
    char str[20]={
        "abcba"
    };
    int length=0;
    int last=strlen(str)-1;
    while (last>1)
    {
        if(str[length++]!=str[last--])
        {
            printf("this is not palindrome");
        }
    }
    printf("this is palindrome");
}
int main()
{
    palindrome();
}
