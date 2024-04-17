#include <stdio.h>

int main() {
  int n, t1 = 0, t2 = 1, nextTerm;

  printf("Enter the number of terms for the Fibonacci Series: ");
  scanf("%d", &n);


  do {
    printf("%d ", t1);
    nextTerm = t1 + t2;
    t1 = t2;
    t2 = nextTerm;
  } while (--n > 0);

  printf("\n");

  return 0;
}
