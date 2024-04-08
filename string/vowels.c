#include<stdio.h>
void vowels()
{
    char str[30]={"abdvjfmfkv"};
    int count=0;
    for (int i = 0; i<10; i++)
    {
        if (str[i] == 'a' || str[i]== 'e' || str[i] == 'i' || str[i]== 'o' || str[i] == 'u' )
        {
            count++;
        }
        
    }
    printf("%d",count);
    
}
int main()
{
vowels ();
return 0;
}

