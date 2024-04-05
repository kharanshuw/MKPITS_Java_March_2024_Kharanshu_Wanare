#include <stdio.h>

long fact(int no);

int main()
{
    long result = 1;
    int no = 0;
    printf("enter no");
    scanf("%d", &no);
    result = fact(no);
    printf("factorial is %d", result);
    return 0;
}

long fact(int no)
{

    long result = 1;

    for (int i = 1; i <= no; i++)
    {
        result = result * i;
    }
    return result;
}