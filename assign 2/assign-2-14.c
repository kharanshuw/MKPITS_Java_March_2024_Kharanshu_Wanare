#include <stdio.h>

int sumOfDivisibleNumbers(int n);

int main() {
    int N;
    printf("Enter the value of N: ");
    scanf("%d", &N);

    int result = sumOfDivisibleNumbers(N);
    printf("sum is %d",result);

    return 0;
}
int sumOfDivisibleNumbers(int n)
{
    int sum = 0;
    for (int i = 1; i <= n; ++i) {
        if (i % 3 == 0 && i % 5 == 0) {
            sum += i;
        }
    }
    return sum;
}