#include <stdio.h>
void intersection();
int main()
{
    intersection();
    return 0;
}
void intersection()
{
    int arr1[5] = {10, 20, 30, 40, 50};
    int arr2[5] = {10, 30, 60, 20, 90};
    int arr3[5];

    for (int i = 0; i < 5; i++)
    {
        for (int k = 0; k < 5; k++)
        {
            if (arr1[i] == arr2[k])
            {
                printf("%d ", arr1[i]);
            }
        }
    }
}
