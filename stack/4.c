//stack implementattion using linkedlist

#include <stdio.h>
#include <stdlib.h>

struct mynode
{
    int data;
    struct mynode *next;
};

struct mynode *head;

void push();

void pop();

void display();

int main()
{
    int choice = 0;
    printf("\n*********Stack operations using linked list*********\n");
    printf("\n----------------------------------------------\n");
    while (1)
    {
        printf("\n\nChose one from the below options...\n");
        printf("\n1.Push\n2.Pop\n3.Show\n4.Exit");
        printf("\n Enter your choice \n");
        scanf("%d", &choice);
        switch (choice)
        {
        case 1:
        {
            push();
            break;
        }
        case 2:
        {
            pop();
            break;
        }
        case 3:
        {
            display();
            break;
        }
        case 4 :
        return 0 ;
        break;
        default:
        {
            printf("Please Enter valid choice ");
            break;
        }
        }
    }
    return 0;
}

void push()
{
    int userdata;
    struct mynode *ptr;
    ptr = (struct mynode *)malloc(sizeof(struct mynode *));
    if (ptr == NULL)
    {
        printf("not able to push the element");
    }
    else
    {
        printf("enter no");
        scanf("%d", &userdata);
        ptr->data = userdata;
        if (head == NULL)
        {
            head = ptr;
            ptr->next = NULL;
        }
        else
        {
            ptr->next = head;
            head = ptr;
        }
    }
}

void pop()
{

    struct mynode *ptr;
    int popdata;
    ptr = head;
    if (ptr == NULL)
    {
        printf("stack is empty");
    }
    else
    {
        popdata = ptr->data;
        head = ptr->next;
        free(ptr);
    }
}

void display()
{
    int i;
    struct mynode *ptr;
    ptr = head;
    if (ptr == NULL)
    {
        printf("Stack is empty\n");
    }
    else
    {
        printf("Printing Stack elements \n");
        while (ptr != NULL)
        {
            printf("%d\n", ptr->data);
            ptr = ptr->next;
        }
    }
}