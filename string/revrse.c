#include<stdio.h>
void revrse()
{
    char str[10]="kaustup";
    char str2[10];
int count=0;
    for (int i = 0; i < 10; i++)
    {
        if (str[i]!=0)
        {
            count++;
        } 
    }
    for (int j = count-1,i=0; j >= 0 && i < count ; j-- ,i++)
    {
        str2[i]=str[j];
    }
    printf("reverse string %s ",str2);
      
}
int main()
{
    revrse();
}
