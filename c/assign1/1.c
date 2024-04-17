#include <stdio.h>
#include <math.h>

void checkTypeOfTriangle(int a, int b, int c) {
    int sqa = pow(a, 2);
    int sqb = pow(b, 2);
    int sqc = pow(c, 2);

    if (sqa == sqb + sqc || sqb == sqc + sqa || sqc == sqa + sqb) {
        printf("Right-angled Triangle\n");
    } else if (sqa > sqc + sqb || sqb > sqa + sqc || sqc > sqa + sqb) {
        printf("Obtuse-angled Triangle\n");
    } else {
        printf("Acute-angled Triangle\n");
    }
}

int main() {
    int a, b, c;
    a = 2;
    b = 2;
    c = 2;

    // Function Call
    checkTypeOfTriangle(a, b, c);
    return 0;
}
