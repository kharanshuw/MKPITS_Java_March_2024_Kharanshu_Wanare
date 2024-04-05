#include<stdio.h>
#include<math.h>

int primecheck(int no);
int range(int no1,int no2);

int main()
{
    range(5,15);
    return 0;
}
int primecheck(int no)
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
        return 0;
    }
    else
    {
        return 1;
    }
    
    
}

int range(int no1,int no2)
{
    int result;
    for (int i = no1; i <=no2; i++)
    {
        result=primecheck(i);
        if (result==1)
        {
            printf("%d is prime \n",i);
        }
        
    }
    
}