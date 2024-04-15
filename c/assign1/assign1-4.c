#include <stdio.h>

void purchanse();

int main() {
    purchanse();
}

void purchanse()
{
    int amount,totalpurchase,discount;
    printf("enter purchase amount");
    scanf("%d",amount);
    if (amount>=500)
    {
        discount=(10/100)*amount;
        totalpurchase=amount-discount;
    }
    else
    {
        totalpurchase=amount;
    }
    printf("%d",totalpurchase);
}