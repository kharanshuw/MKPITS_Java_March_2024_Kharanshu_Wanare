#include <stdio.h>
#include <math.h>

float calculateBMI(float height, float weight) {
    float result= weight / pow(height, 2);
	return float;
}

void categorizeBMI(float bmi) {
    if (bmi < 18.5) {
        printf("Underweight\n");
    } else if (bmi < 24.9) {
        printf("Normal weight\n");
    } else if (bmi < 30) {
        printf("Overweight\n");
    } else {
        printf("Obese\n");
    }
}

int main() {
    float height, weight;
    printf("Enter height (in meters): ");
    scanf("%f", &height);
    printf("Enter weight (in kilograms): ");
    scanf("%f", &weight);

    float bmi = calculateBMI(height, weight);
    printf("The BMI is %.2f, so ", bmi);
    categorizeBMI(bmi);

    return 0;
}
