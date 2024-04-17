#include <stdio.h>

int main() {
    long long int num; 

    printf("Enter a number: ");
    scanf("%lld", &num);

    int count = 0;

    
    if (num < 0) {
        num = -num; 
        count++;  
    }

 
    while (num != 0) {
        num /= 10;
        count++;
    }

    printf("The number of digits is: %d\n", count);

    return 0;
}
