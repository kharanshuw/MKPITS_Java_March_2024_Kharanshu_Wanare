#include <stdio.h>

#include <math.h>

void perfect();

int main()
{
    perfect();
    return 0;
}

void perfect()
{
    int  number;
    printf("enter no");
    scanf("%d", &number);
    
   int y= sqrt(number);

   if (y%2==0)
   {
    printf("this is perfect square");
   }
   else
   {
    printf("this is not perfect square");
   }
   

        
}