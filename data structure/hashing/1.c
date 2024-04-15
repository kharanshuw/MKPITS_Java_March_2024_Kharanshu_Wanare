#include<stdio.h>
void myhashing();
int main()
{
myhashing();
}
void myhashing(){
    int no,i;
    int mymod;
    int arr[10];
    for ( i = 0; i < 10; i++)
    {
        printf("enter a no");
        scanf("%d",&no);
        mymod=no%10;
        arr[mymod]=no;
    }
    for ( i = 0; i < 10; i++)
    {
        printf("\n%d",arr[i]);
    }
    
}