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

    struct student s1;

    printf("enter struct value");
    scanf("%s",s1.name);
    scanf("%d",&s1.marks);
    scanf("%f",&s1.fees);

    printf("%s,%d,%f",s1.name,s1.marks,s1.fees);
}