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

void search();

void insert_at_end();

void insertatrandon();

void delete();
int main()
{
    int choice = 0;

    while (1)
    {
        printf("\nenter choice \n 1.insert node at begining");
        printf("\n2.display");
        printf("\n3.exit ");
        printf("\n4.insert_at_end");
        printf("\n5.search");
        printf("\n6.add at given position");
        printf("\n7.delete");

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
        case 5:
            search();
            break;
        case 6:
            insertatrandon();
            break;
        case 7:
            delete ();
            break;
        
        default:
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

void search()
{
    int no = 0;
    struct mynode *temp;
    temp = head;
    int count = 1;
    if (head == NULL)
    {
        printf("linked list is empty");
    }
    else
    {
        printf("enter no");
        scanf("%d", &no);
        while (temp != NULL)
        {
            if (temp->data == no)
            {
                printf("no found at location %d", count);
                return;
            }

            count++;
            temp = temp->next;
        }
    }
}

void insertatrandon()
{
    struct mynode *ptr, *current;
    int data;
    int position;
    int count = 1;
    printf("enter position");
    scanf("%d", &position);
    if (head == NULL)
    {
        printf("linked list is empty");
    }
    else if (position < 1)
    {
        printf("Invalid position: Position cannot be less than 1.\n");
        return;
    }
    ptr = (struct mynode *)malloc(sizeof(struct mynode *));
    printf("enter data");
    scanf("%d", &data);
    ptr->data = data;
    if (position == 1)
    {
        ptr->next = head;
        head = ptr;
        return;
    }
    current = head;
    while (current != NULL && count < position - 1)
    {
        count++;
        current = current->next;
    }

    if (current == NULL)
    {
        printf("Invalid position: Position exceeds list length.\n");
        return;
    }

    ptr->next = current->next;
    current->next = ptr;
}

void delete()
{
    int position;
    int count=1;
    struct mynode *current, *prev;
    current=head;
    prev=NULL;
    printf("enter position");
    scanf("%d",&position);
    if (position<1)
    {
        printf("Invalid position: Position cannot be less than 1.\n");
        return;
    }
    
    else if (position==1)
    {
        head=current->next;
        free(current);
        return;
    }
    
    while (current != NULL && count < position)
    {
        count++;
        prev=current;
        current=current->next;
    }
    
 if (current == NULL) {
        printf("Invalid position: Position exceeds list length.\n");
        return;
    }
    
    prev->next=current->next;
    free(current);
    
}