#include <stdio.h>

int main() {
    int n;
    int sum=0;
    printf("enter the value of n");
    scanf("%d",&n);
    for (int i = 1; i <= n; i++)
    {
        sum=sum+i*i;
    }

    printf("sum is %d",sum);       
}
