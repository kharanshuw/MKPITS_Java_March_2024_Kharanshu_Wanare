#include <stdio.h>
void countoccurence();
int main()
{
    countoccurence();
}
void countoccurence()
{
    int arr[5] = {10, 20, 10, 20, 10};

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5 - 1 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
    for (int i = 0; i < 5; i++)
    {
        int count = 1;
        while (i < 4 && arr[i] == arr[i + 1])
        {
            i++;
            count++;
        }

        printf("%d : %d\n", arr[i], count);
    }
}
