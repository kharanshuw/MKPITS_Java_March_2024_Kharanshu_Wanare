#include <stdio.h>
#include <stdlib.h>

struct mynode {
    int data;
    struct mynode* next;
};

// Function prototypes
void createList(struct mynode** head);
void displayList(struct mynode* head);


int main() {
    struct mynode* head = NULL;  // Initially empty list
    int choice, data, position;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Create List\n");
        printf("2. Display List\n");
        printf("3.exit \n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                createList(&head);
                break;
            case 2:
                displayList(head);
                break;        
            case 3:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }

    return 0;
}

// Function to create a linked list
void createList(struct mynode** head) {
    int data, num;

    printf("Enter the number of mynodes: ");
    scanf("%d", &num);

    for (int i = 0; i < num; i++) {
        printf("Enter data for mynode %d: ", i + 1);
        scanf("%d", &data);

        struct mynode* newmynode = (struct mynode*)malloc(sizeof(struct mynode));
        newmynode->data = data;
        newmynode->next = NULL;

        if (*head == NULL) {
            *head = newmynode;  // If list is empty, make newmynode the head
        } else {
            struct mynode* temp = *head;
            while (temp->next != NULL) {  // Traverse to the last mynode
                temp = temp->next;
            }
            temp->next = newmynode;  // Link the last mynode to the newmynode
        }
    }
}

// Function to display the linked list
void displayList(struct mynode* head) {
    if (head == NULL) {
        printf("List is empty\n");
        return;
    }

    struct mynode* temp = head;
    printf("List: ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}

// Function to insert a mynode at the beginning of the linked list
void insertAtBeginning(struct mynode** head, int data) {
    struct mynode* newmynode = (struct mynode*)malloc(sizeof(struct mynode));
    newmynode->data = data;
    newmynode->next = *head;
    *head = newmynode;
}