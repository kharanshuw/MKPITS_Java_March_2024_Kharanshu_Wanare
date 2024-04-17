#include <stdio.h>

int main() {
  float temperature;
  char choice;

  printf("Enter temperature: ");
  scanf("%f", &temperature);

  printf("Enter 'C' to convert from Celsius to Fahrenheit or 'F' to convert from Fahrenheit to Celsius: ");
  scanf(" %c", &choice);

  switch (choice) {
    case 'c': 
      printf("%.2f degrees Celsius is equal to %.2f degrees Fahrenheit.\n", temperature, (temperature * 1.8) + 32);
      break;
    
    case 'f': 
      printf("%.2f degrees Fahrenheit is equal to %.2f degrees Celsius.\n", temperature, (temperature - 32) / 1.8);
      break;
    default:
      printf("Invalid choice. Please enter 'C' or 'F'.\n");
  }

  return 0;
}
