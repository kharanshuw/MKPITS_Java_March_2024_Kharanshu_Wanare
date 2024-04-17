#include <stdio.h>

void calculate(double basic, double allowance , double deduction) {
    double net_salary;

    
    net_salary = basic +allowance-deduction;

   
    printf("Net Salary is", net_salary);
}

int main() {
    double basic,allowance, deduction;

   
    printf("Enter Basic Salary");
    scanf("%lf", &basic);
    
    printf("allowance: ");
    scanf("%lf", &allowance);
    printf("deduction: ");
    scanf("%lf", &deduction);

    
    calculate(basic, allowance,deduction);

    return 0;
}
