#include<stdio.h>
int main()
{
    int arr[5]={10,20,30,40,50};
    int temp[5];
    
 for (int i = 4 - 3; i < 5; i++)
  {
    temp[i - 4 + 3] = arr[i];
  }
  for (int i = 4 - 3 - 1; i >= 0; i--)
  {
    arr[i + 3] = arr[i];
  }
  for (int i = 0; i < 3; i++)
  {
    arr[i] = temp[i];
  }
}