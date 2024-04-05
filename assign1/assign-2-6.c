#include<stdio.h>
char prime(int x);
int main()
{
    char result;
   result= prime(5);
   printf("this no is %c",result);
}
char prime(int x)
{
    for (int i = 2; i <x; i++)
    {
        if (x%i==0)
        {
            return 'y';
        }
        else
        {
            return  'n';
        }
        
    }
    
}