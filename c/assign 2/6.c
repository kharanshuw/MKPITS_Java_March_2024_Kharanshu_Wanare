#include <stdio.h>
#include <math.h>

int isPrime(int num) {
  if (num <= 1) {
    return 0;
  }
  for (int i = 2; i <= sqrt(num); i++) {
    if (num % i == 0) {
      return 0; 
    }
  }
  return 1; 
}

int main() {
  int n;

  printf("Enter an upper limit (N): ");
  scanf("%d", &n);

  printf("Prime numbers between 1 and %d are: \n", n);

  for (int i = 2; i <= n; i++) {
    if (isPrime(i)) {
      printf("%d ", i);
    }
  }

  printf("\n");
  return 0;
}
