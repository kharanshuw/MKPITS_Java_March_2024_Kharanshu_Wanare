#include <stdio.h>

int main() {
  int pin, choice, withdrawal_amount, deposit_amount;
  float current_balance = 1000.00; 


  printf("Enter your PIN: ");
  scanf("%d", &pin);

  if (pin != 1234) {
    printf("Invalid PIN\n");
    return 0;
  }

  printf("Welcome to the ATM!\n");

  do {
   
    printf("\n1. Check Balance\n");
    printf("2. Withdraw Cash\n");
    printf("3. Deposit Cash\n");
    printf("4. Exit\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice) {
      case 1:
        printf("Your current balance is: $%.2f\n", current_balance);
        break;
      case 2:
        printf("Enter amount to withdraw (multiples of $100): ");
        scanf("%d", &withdrawal_amount);

      
        if (withdrawal_amount % 100 != 0) {
          printf("Withdrawal amount must be in multiples of $100\n");
        } else if (withdrawal_amount > current_balance) {
          printf("Insufficient funds. Your current balance is: $%.2f\n", current_balance);
        } else {
          current_balance -= withdrawal_amount;
          printf("Withdrawal successful. Please collect your cash.\n");
          printf("Your new balance is: $%.2f\n", current_balance);
        }
        break;
      case 3:
        printf("Enter amount to deposit: ");
        scanf("%d", &deposit_amount);

        if (deposit_amount <= 0) {
          printf("Deposit amount must be positive.\n");
        } else {
          current_balance += deposit_amount;
          printf("Deposit successful. Your new balance is: $%.2f\n", current_balance);
        }
        break;
      case 4:
        printf("Thank you for using the ATM. Goodbye!\n");
        break;
      default:
        printf("Invalid choice. Please enter a number between 1 and 4.\n");
    }
  } while (choice != 4);

  return 0;
}
