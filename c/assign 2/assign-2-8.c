#include <stdio.h>

int main() {
    int n;
    double sum = 0.0;

    printf("Enter a positive integer N: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; ++i) {
        sum =sum + 1.0 / i;
    }

    printf("Sum is %lf\n", n, sum);

    return 0;
}
