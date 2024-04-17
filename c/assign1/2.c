#include <stdio.h>
#include <math.h>

void findRoots(double a, double b, double c) {
    double discriminant, root1, root2, realPart, imagPart;
    discriminant = b * b - 4 * a * c;
    if (discriminant > 0) {
        root1 = (-b + sqrt(discriminant)) / (2 * a);
        root2 = (-b - sqrt(discriminant)) / (2 * a);
        printf("Root 1 = %.2lf\nRoot 2 = %.2lf\n", root1, root2);
    } 
  else if (discriminant == 0) {
        root1 = root2 = -b / (2 * a);
        printf("Root 1 = Root 2 = %.2lf\n", root1);
    }
    else {
        realPart = -b / (2 * a);
        imagPart = sqrt(-discriminant) / (2 * a);
        printf("Root 1 = %.2lf + %.2lfi\nRoot 2 = %.2lf - %.2lfi\n", realPart, imagPart, realPart, imagPart);
    }
}
int main() {
    double a, b, c;
    printf("Enter coefficients (a, b, and c): ");
    scanf("%lf %lf %lf", &a, &b, &c);    
    findRoots(a, b, c);
    return 0;
}
