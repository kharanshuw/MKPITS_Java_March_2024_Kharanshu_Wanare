#include<stdio.h>

void mystruct();
int main()
{
    mystruct();
    return 0;
}
void mystruct()
{
    struct student
    {
        char name[10];
        int marks;
        float fees ;
    };

    struct student s1[3];

    for (int i = 0; i < 3; i++)
    {
        printf("enter values of structure \n");
        scanf("%s",s1[i].name);
        scanf("%d",&s1[i].marks);
        scanf("%f",&s1[i].fees);
    }
    for (int i = 0; i < 3; i++)
    {
        printf("values are \t");
        printf("%s,%d,%f \n",s1[i].name,s1[i].marks,s1[i].fees);
    }
    
}