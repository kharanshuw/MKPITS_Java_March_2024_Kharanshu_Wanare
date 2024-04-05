#include <stdio.h>
int reverse(int no);
int main()
{
    int result = 0;
    result = reverse(459);
    printf("%d", result);
    return 0;
}
int reverse(int no)
{
    int rev = 0;
    int remainder;
    while (no != 0)
    {
        remainder = no % 10;
        rev = rev * 10 + remainder;
        no = no / 10;
    }
    return rev;
}