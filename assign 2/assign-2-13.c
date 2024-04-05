#include <stdio.h>

int main() {
     int no;
     int fact=1;
     int digit;
     printf("enter no");
     scanf("%d",&no);
     for (int i = 1; i <=no; i++)
     {
        fact=fact*i;
     }

     while (fact != 0)
     {
        digit++;
        fact=fact/10;
     }

     printf("digit of no are %d",digit);
     
           
}
