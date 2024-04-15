#include<stdio.h>
#include<string.h>
void myarray();

int main()
{
    myarray();
}

void myarray(){
    int x;
    char str[5][10],temp[10];
    
    for (int i = 0; i < 5; i++)
    {
        printf("enter name\n");
        scanf("%s",str[i]);
    }
    printf("before sorting array");
    for (int i = 0; i < 5; i++)
    {
        printf("\n%s",str[i]);
    }

    for (int i = 0; i <5; i++)
    {
        for (int j = 0; j <5-1-i; j++)
        {
            x=strcmp(str[j],str[j+1]);
            if (x<0)
            {
                strcpy(temp,str[j]);
                strcpy(str[j],str[j+1]);
                strcpy(str[j+1],temp);
            }
            
        } 
    }
    printf("\n**************************\n");
    printf("after sorting");
    for (int i = 0; i <5; i++)
    {
        printf("%s \n",str[i]);
    }
    
}
