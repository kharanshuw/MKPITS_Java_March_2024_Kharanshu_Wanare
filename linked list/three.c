#include <stdio.h>
#include <stdlib.h>
struct mynode
{
    int data;
    struct mynode *next;
};
struct mynode *head;

void insert_at_begining();

void display();

void insert_at_end();
int main()
{
    int choice = 0;

    while (1)
    {
        printf("\nenter choice \n 1.insert node at begining");
        printf("\n2.display");
        printf("\n3.exit ");
        printf("\n4.insert_at_end\n");

        scanf("%d", &choice);
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
            break;
        case 4:
            insert_at_end();
            break;
        default:
            printf("\nwrong choice\n");
            break;
        }
    }

    return 0;
}

void insert_at_begining()
{
    struct mynode *next;
    int data;

    next = (struct mynode *)malloc(sizeof(struct mynode *));
    if (next == NULL)
    {
        printf("\nnext is null memory not allocated\n");
    }
    else
    {
        printf("enter no ");
        scanf("%d", &data);
        next->data = data;
        next->next = head;
        head = next;
        printf("\n node inserted \n");
    }
}

void insert_at_end()
{
    struct mynode *ptr, *temp;
    int data;
    ptr = (struct mynode *)malloc(sizeof(struct mynode *));
    printf("\nenter value\t");
    scanf("%d", &data);
    if (ptr == NULL)
    {
        printf("overloded");
    }
    else
    {
        temp = head;
        ptr->data = data;
        if (head == NULL)
        {
            head = ptr;
            ptr->next = NULL;
            printf("\nnode inserted");
        }
        else
        {
            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = ptr;
            ptr->next = NULL;
            printf("\nnode added at last position");
        }
    }
}

void display()
{
    struct mynode *next;
    next = head;
    if (next == NULL)
    {
        printf("\nnothing to print\n");
    }
    else
    {
        while (next != NULL)
        {
            printf("\n %d \n", next->data);
            next = next->next;
        }
    }
}