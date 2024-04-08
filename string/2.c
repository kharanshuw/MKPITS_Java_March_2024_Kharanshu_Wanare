#include<stdio.h>
void length()
{
    char str[10];
    int count=0;
    printf("enter a string");
    scanf("%s",str);
    printf("%s \n",str);
    for (int i = 0; i < 10; i++)
    {
        if (str[i]!=0)
        {
            count++;
        }
        
    }
    printf("length is %d ",count);
    
}
int main()
{
    length();
return 0;
}