#include <stdio.h>
#include <math.h>

void armstrong(int no);

int main() {
    armstrong(371);
}

void armstrong(int no)
{
    int digit=0;
    int originalno=no;
    int remainder=0;
    int sum=0;

    while(no!=0)
    {
        digit++;
        no=no/10;
    }
    no=originalno;

    while (no!=0)
    {
        remainder=no%10;
        sum=sum+pow(remainder,digit);
        no=no/10;
    }

    if (sum==originalno)
    {
        printf("this is armstrong no");
    }
    else
    {
        printf("this is not armstrong no ");
    }
    
    
}
