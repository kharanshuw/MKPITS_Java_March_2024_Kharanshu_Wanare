#include <stdio.h>
void prime();
int main()
{
    prime(5);
    return 0;
}
void prime(int x)
{
    int count = 0;
    for (int i = 1; i <= x; i++)
    {
        if (x % i == 0)
        {
            count++;
        }
    }
    if (count > 2)
    {
        printf("this is not prime no ");
    }
    else
    {
        printf("this is prime no");
    }
}