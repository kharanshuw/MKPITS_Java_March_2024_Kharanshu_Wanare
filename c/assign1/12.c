#include <stdio.h>

int main() {
  int month_number, year;

  printf("Enter month number (1-12): ");
  scanf("%d", &month_number);

  printf("Enter year: ");
  scanf("%d", &year);

  int days;
  switch (month_number) {
    case 1: days = 31;
      break; 
    case 3: days = 31;
      break; 
    case 5: days = 31;
      break; 
    case 7: days = 31;
      break; 
    case 8: days = 31;
      break; 
    case 10: days = 31;
      break;
    case 12:days = 31;
      break; 
      
    case 4:days = 30;
      break;  
    case 6:days = 30;
      break;  
    case 9:  days = 30;
      break;
    case 11:days = 30;
      break; 
      
    case 2:  
      if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
        days = 29; 
      } else {
        days = 28;  
      }
      break;
    default:
      days = -1;  
  }

  if (days == -1) {
    printf("Invalid month number. Please enter a number between 1 and 12.\n");
  } else {
    printf("The month %d in the year %d has %d days.\n", month_number, year, days);
  }

  return 0;
}
