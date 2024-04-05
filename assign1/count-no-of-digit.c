#include<stdio.h>
int countdigit();
int main()
{
int count=0;
count=countdigit(555556);
printf("count is %d",count);
}

int countdigit(int no)
{
   int count=0;
   while (no>0)
   {
    count++;
    no=no/10;
   }
   return count;
}