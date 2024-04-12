// write a program to check duplicate value in arrary and if found replace it with 0 and then add those non 0 to other dynamic array

#include <stdio.h>
#include <stdlib.h>

void remove_duplicate();

int main()
{
    remove_duplicate();
}

void remove_duplicate()
{
    int arr1[5] = {1, 6, 3, 3, 1};
    int count = 0;
    int* ptr;
    int index=0;
    for (int i = 0; i < 5; i++)
    {
        if (arr1[i] == 0)
        {
            continue;
        }

        for (int j = i + 1; j < 5; j++)
        {
            if (arr1[i] == arr1[j])
            {
                arr1[j] = 0;
            }
        }
    }
    for (int i = 0; i < 5; i++)
    {
        if (arr1[i]!=0)
        {
            count++;
        }
    }

    ptr =(int*) malloc (sizeof(int)*count);
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    for (int i = 0; i < count ; i++)
    {
        if (arr1[i]!=0)
        {
            ptr[index++]=arr1[i];
        }
    }
    printf("non 0 element");
    for (int i = 0;i <count;i++)
    {
        printf("\n%d\n",ptr[i]);
    }
    free(ptr);
}