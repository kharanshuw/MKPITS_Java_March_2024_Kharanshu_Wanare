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

void insert_at_end();
int main()
{
    int choice=0;

    while (1)
    {
        printf("enter choice \n 1.insert node at begining");
        printf("\n2.display\n");
        printf("3. exit ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            insert_at_begining();
            break;
        case 2:
            display();
            break;
        case 3:
           return 0;
        default:
            printf("\nwrong choice\n");
            break;
        }
    }
    
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
       printf("\nptr is null memory not allocated\n");
    }
    else
    {
        ptr->data=data;
        ptr->ptr=head;
        head=ptr;
        printf("\n node inserted \n");
    }
    
}

void insert_at_end()
{
    
}

void display(){
    struct mynode *ptr;
    ptr=head;
    if (ptr==NULL)
    {
        printf("\nnothing to print\n");
    }
    else
    {
        while (ptr != NULL)
        {
            printf("\n %d \n",ptr->data);
            ptr=ptr->ptr;
        }
        
    }
    
}