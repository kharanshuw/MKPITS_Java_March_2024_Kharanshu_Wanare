#include <stdio.h>

int main() {
  int base, exponent;
  float power = 1.0; 
  printf("Enter base number: ");
  scanf("%d", &base);

  printf("Enter exponent: ");
  scanf("%d", &exponent);

  
  if (exponent < 0) {
    printf("Error: Exponent cannot be negative.\n");
    return 1; 
  }

  
  for (int i = 0; i < exponent; i++) {
    power *= base;
  }

  printf("%d raised to the power of %d is: %.2f\n", base, exponent, power);

  return 0;
}
