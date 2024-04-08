#include<stdio.h>
void linearsearch1(){
    int index=-1;
    int flag=0;
    int no=0;
    printf("enter no");
    scanf("%d",&no);
    int arr[5]={10,20,30,40,50};
    for (int i = 0; i < 5; i++)
    {
        if (arr[i]==no)
        {
            flag=1;
            index=i;
            break;
        }           
    }
    if (flag==1)
    {
        printf("no found at %d ",index);
    }
    else if (flag==0)
    {
        printf("not found ");
    }   
}
int main()
{
    linearsearch1();
    return 0;
}
