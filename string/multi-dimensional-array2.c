#include<stdio.h>

void marray();
int main()
{
    marray();
return 0;
}
void marray(){
     int num1[2][2]={
        {10,20},
        {30,40},
        
     };

     int num2[2][2]={
        {70,80},
        {90,100},
        
     };

     int num3[2][2];
     for (int i = 0; i < 2; i++)
     {
        for (int j = 0; j < 2; j++)
        {
            int sum=num1[i][j]+num2[i][j];
            num3[i][j]=sum;
        }
        
     }

     for (int i = 0; i < 2; i++)
    {
        for (int j = 0; j < 2; j++)
        {
            printf("%d \t" ,num3[i][j]);
            
        }   
        printf("\n");    
    }
     
}