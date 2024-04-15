#include <stdio.h>

void primecheck(int no);
int main()
{
    primecheck(6);
}

void primecheck(int no)
{
    int count=0;
    for (int i = 1; i <=no; i++)
    {
        if (no%i==0)
        {
            count++;
        }
        
    }
    if (count>2)
    {
        printf("this is not prime no");
    }
    else
    {
        printf("this is prime no ");
    }
    
    
}