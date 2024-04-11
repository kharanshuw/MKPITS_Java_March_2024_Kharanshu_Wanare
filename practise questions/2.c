// program to add every element which is present at even position

#include <stdio.h>

void evenposition();

int main()
{
    evenposition();
    return 0;
}
void evenposition()
{
    int sum = 0;
    int arr[9] = {10, 20, 30, 40, 50, 60, 70, 80, 90};
    for (int i = 0; i < 9; i = i + 2)
    {
        if (i % 2 == 0)
        {
            sum = sum + arr[i];
        }
    }
    printf("sum is %d", sum);
}