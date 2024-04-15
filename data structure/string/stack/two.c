// stack using array
#include <stdio.h>
int size;
int mystack[100];
int top = -1;
int i, j;

void push();
void pop();
void show();
int main()
{
    printf("enter size");
    scanf("%d", &size);
    int choice;
    choice = 0;
    while (1)
    {
        printf("enter choice \n 0.exit 1.push 2.pop 3.show");
        scanf("%d", &choice);
        switch (choice)
        {
        case 0:
            return 0;
            break;
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
            show();
            break;
        default:
            break;
        }
    }
    return 0;
}

void push()
{
    int no;
    printf("\nenter no");
    scanf("%d", &no);
    if (top == size)
    {
        printf("\nstack is full");
    }
    else
    {
         printf("\nenter no");
    scanf("%d", &no);
        top = top + 1;
        mystack[top] = no;
    }
}
void pop()
{
    if (top == -1)
    {
        printf("\nstack is empty");
    }
    else
    {
        printf("%d removed", mystack[top]);
        top = top - 1;
    }
}

void show()
{
    for (i = top; i >= 0; i--)
    {
        printf("\n%d", mystack[top]);
    }
    if (top == -1)
    {
        printf("\nStack is empty");
    }
}