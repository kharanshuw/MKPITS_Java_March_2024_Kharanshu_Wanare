#include<stdio.h>

void merge();
int main()
{
    merge();
return 0;
}
void merge()
{
    int j=0;
    int arr1[5]={10,20,30,40,50};
    int arr2[20]={60,70,80,90,100};

    for (int i = 0,j=5; i < 5 && j<20; i++,j++)
    {
        arr2[j]=arr1[i];
    }

    for (int i = 0; i < 20; i++)
    {
        printf("%d \n",arr2[i]);
    }
    
    
}