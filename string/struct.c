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
    struct student s1={"abc",10,55.5};

    printf("%s %d %f",s1.name,s1.marks,s1.fees);
}