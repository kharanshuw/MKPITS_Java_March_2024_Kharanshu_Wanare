#include<stdio.h>
void loop1();
void loop2();
void loop3();
int main()
{

loop1();
loop2();   
loop3(); 
}


void loop1(){
   for (int i = 1; i <= 5; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            printf("%d ",i);
            
        }
        printf("\n");
        
    } 
}


void loop2(){
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j <= i; j++) {
            printf("%d ", j + 1);
        }
        printf("\n");
    }

    
    
}

void loop3(){
    for (int i = 1; i <= 5; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            printf("* ");
            
        }
        printf("\n");
        
    } 
} 