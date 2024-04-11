// add every 3rd element in array and print sum of that no
//add even and odd position element
//find those 4 elment whose sum is gretest 
//find those 4 elment whose sum is minimum 
#include <stdio.h>
void sum();
int main()
{
    sum();
    return 0;
}
void sum()
{
    int mysum = 0;
    int arr[10] = {10, 20, 30, 40, 50,60,70,80,90,100}; 

    for (int i = 2; i < 10; i=i+3)
    {   
        mysum=mysum+arr[i];   
    }
    printf("sum is %d", mysum);
}