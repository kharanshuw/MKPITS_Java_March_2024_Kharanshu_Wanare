#include <stdio.h>

int  factorial(int num);


int sumOfSeries(int N) ;

int main() {
    int N;
    printf("Enter the value of N: ");
    scanf("%d", &N);

    int result = sumOfSeries(N);
    printf("Sum %d", result);

    return 0;
}

int  factorial(int num){
 int  fact = 1;
    for (int i = 1; i <= num; ++i) {
        fact *= i;
    }
    return fact;

}

int sumOfSeries(int N){
 int sum = 0.0;
    for (int i = 1; i <= N; ++i) {
        int term = i / factorial(i);
        sum=sum+term;
    }
    return sum;
}