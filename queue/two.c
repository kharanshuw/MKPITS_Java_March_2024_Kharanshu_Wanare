#include <stdio.h>

int queue[100];
int front = -1, rear = -1;
int size;

int isFull()
{
    if (rear == size - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int isEmpty()
{
    if (front == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void enqueue(int data)
{
    int result=isFull();
    if (result==1)
    {
        printf("Queue overflow\n");
        return;
    }
    if (front == -1)
    {
        front = 0;
    }
    rear++;
    queue[rear] = data;
    printf("Inserted %d in queue\n", data);
}

int dequeue()
{
    int result=isEmpty();
    if (result==1)
    {
        printf("Queue underflow\n");
        return -1;
    }
    int data = queue[front];
    if (front == rear)
    {
        front = rear = -1;
    }
    else
    {
        front++;
    }
    printf("Deleted %d from queue\n", data);
    return data;
}

void display()
{
    if (isEmpty())
    {
        printf("Queue is empty\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = front; i <= rear; i++)
    {
        printf("%d ", queue[i]);
    }
    printf("\n");
}

int main()
{
    printf("enter size");
    scanf("%d",&size);
    int data;
    int choice = 0;
    while (choice !=3)
    {
        printf("\nenter choice \n 1.enque 2.deque 3.exit 4.display ");
        scanf("%d",&choice);
        switch (choice)
        {
        case 1:
            printf("enter data");
            scanf("%d",&data);
            enqueue(data);
            break;
        case 2:
            dequeue();
            break;
        case 3:
            return 0;
            break;
        case 4:
            display();
            break;
        default:
            break;
        }
    }
    return 0;
}
