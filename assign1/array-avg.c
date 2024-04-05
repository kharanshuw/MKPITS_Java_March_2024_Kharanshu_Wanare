#include<stdio.h>

void avg()
{
    int sum=0;
    int average=0;

    int arr[5]={10,20,30,40,50};
    for (int i = 0; i < 5; i++)
    {
        sum=sum+arr[i];
    }
    average=sum/5;
    printf("sum of array %d ",sum);
    printf("average of array is %d ",average);
    
}
int main()
{
    avg();
}
