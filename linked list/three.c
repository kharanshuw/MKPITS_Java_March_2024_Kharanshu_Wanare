#include<stdio.h>
#include<stdlib.h>
struct mynode
{
    int data;
    struct mynode *ptr;
};
struct mynode *head;

void insert_at_begining();

void display();


int main()
{
    return 0;
}

void insert_at_begining(){
    struct mynode *ptr;
    int data;
    printf("enter no ");
    scanf("%d",&data);
    ptr=(struct mynode *)malloc(sizeof (struct mynode *));
    if (ptr==NULL)
    {
       printf("ptr is null memory not allocated");
    }
    else
    {
        ptr->data=data;
        ptr->ptr=head;
        head=ptr;
        printf("\n node inserted");
    }
    
}