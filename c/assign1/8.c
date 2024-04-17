#include <stdio.h>

int main() {
  
  float entree_price = 15.99;
  float appetizer_price = 8.50;
  float dessert_price = 5.25;

  
  float tax_rate = 0.07;  // 7%
  float tip_rate = 0.18;  // 18%

  
  int has_entree = 1;  // 1 - ordered, 0 - not ordered
  int has_appetizer = 0;
  int has_dessert = 1;

  
  float subtotal = 0.0;
  if (has_entree) {
    subtotal += entree_price;
  }
  if (has_appetizer) {
    subtotal += appetizer_price;
  }
  if (has_dessert) {
    subtotal += dessert_price;
  }

 
  float tax = subtotal * tax_rate;

  
  float tip = subtotal * tip_rate;

  
  float total_cost = subtotal + tax + tip;

  
  printf("Subtotal:        $%.2f\n", subtotal);
  printf("Tax (%.2f%%):      $%.2f\n", tax_rate * 100, tax);
  printf("Tip (%.2f%%):      $%.2f\n", tip_rate * 100, tip);
  printf("Total Cost:      $%.2f\n", total_cost);

  return 0;
}
