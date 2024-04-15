#include<stdio.h>
void smallest()
{
    int arr[5]={10,20,30,40,50};
    int smallests=arr[0];
    for (int i = 1; i < 5; i++)
    {
        if (smallests>arr[i])
        {
            smallests=arr[i];
        }
        
    }
printf("%d",smallests);
    
}
int main(){
smallest();
}