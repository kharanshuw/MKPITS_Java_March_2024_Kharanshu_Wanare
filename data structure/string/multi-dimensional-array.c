#include<stdio.h>

void marray();
int main()
{
    marray();
return 0;
}
void marray(){
       int num[3][3];

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            scanf("enter no %d",&num[i][j]);
        }
        
    }
    

    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            printf("%d \t" ,num[i][j]);
            
        }   
        printf("\n");    
    }
    
}