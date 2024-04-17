#include <stdio.h>

int main() {
    float amount, discount, amountToBePaid;

    
    printf("How much shopping amount have you done here? $");
    scanf("%f", &amount);

    
    if (amount <= 100) {
        printf("You have to pay", amount);
    } else {
        if (amount > 100 && amount <= 200) {
            discount = (amount * 5) / 100;
        } else if (amount > 200 && amount <= 400) {
            discount = (amount * 10) / 100;
        } else if (amount > 400 && amount <= 800) {
            discount = (amount * 20) / 100;
        } else {
            discount = (amount * 25) / 100;
        }
        amountToBePaid = amount - discount;
        printf("After applying the discount, you have to pay", amountToBePaid);
    }

    return 0;
}
