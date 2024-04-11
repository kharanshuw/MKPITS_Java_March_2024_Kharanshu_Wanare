#include <stdio.h>
void odd_position_sum();
int main()
{
    odd_position_sum();
    return 0;
}
void odd_position_sum()
{
    int arr[7] = {10, 20, 30, 40, 50, 60, 70};
    int sum = 0;
    for (int i = 0; i < 7; i++)
    {
        if (i % 2 != 0)
        {
            sum = sum + arr[i];
        }
    }
    printf("sum %d", sum);
}