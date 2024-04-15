#include<stdio.h>
#include<math.h>

int armstrong(int no);
void range(int a,int b);
int main()
{
    range(5,154);
}

int armstrong(int no)
{
    int digit=0;
    int originalno=no;
    int remainder=0;
    int sum=0;
    int result;

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
        result=1;
        
    }
    else
    {
        result=0;
        
    }
    
    return result;
}

void range(int a,int b)
{
    int result;
    for (int i = a; i <= b; i++)
    {
        result=armstrong(i);
        if (result==1)
        {
            printf("%d is armstrong \n",i);
        }
        
    }
    
}