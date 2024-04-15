#include <stdio.h>

int main()
{
    char str1[10] = "abcdefg";
    char str2[10] = "abcdefg";
    int count1 = 0;
    int count2 = 0;

    for (int i = 0; i < 10; i++)
    {
        if (str1[i] != 0)
        {
            count1++;
        }
    }

    for (int i = 0; i < 10; i++)
    {
        if (str2[i] != 0)
        {
            count2++;
        }
    }

    if (count1 == count2)
    {
        int x = 0;

        for (int k = 0; k < count1; k++)
        {
            if (str1[k] != str2[k])
            {
                x = 1;
            }
        }
        if (x == 1)
        {
            printf("not same");
        }
        else
        {
            printf("both are same");
        }
    }
    else
    {
        printf("both are not same");
    }
}