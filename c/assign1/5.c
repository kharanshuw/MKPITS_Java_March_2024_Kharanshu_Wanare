#include <stdio.h>
#include <math.h>

void isPerfectSquare(int number) {
    int i;
    for (i = 0; i <= number; i++) {
        if (number == i * i) {
            printf("%d is a perfect square.\n", number);
            return; 
        }
    }
    printf("%d is not a perfect square", number);
}

int main() {
    int n;
    printf("Enter a number: ");
    scanf("%d", &n);
    isPerfectSquare(n);
    return 0;
}
