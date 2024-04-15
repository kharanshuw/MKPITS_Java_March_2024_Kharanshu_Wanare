#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Function prototypes
void createList(struct Node** head, int data);
void addAtPosition(struct Node** head, int data, int position);
void printList(struct Node* head);

int main() {
    struct Node* head = NULL; // Initially empty list

    // Create a sample linked list (modify as needed)
    createList(&head, 10);
    createList(&head, 20);
    createList(&head, 30);

    printf("Original linked list: ");
    printList(head);

    int number, position;

    printf("Enter the number to add: ");
    scanf("%d", &number);

    printf("Enter the position to add (1-based): ");
    scanf("%d", &position);

    addAtPosition(&head, number, position);

    printf("Modified linked list: ");
    printList(head);

    return 0;
}

// Function to create a new node and insert it at the beginning of the list
void createList(struct Node** head, int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

// Function to add a new node at the specified position in the linked list
void addAtPosition(struct Node** head, int data, int position) {
    if (position < 1) {
        printf("Invalid position: Position cannot be less than 1.\n");
        return;
    }

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;

    // Handle insertion at the beginning (position 1)
    if (position == 1) {
        newNode->next = *head;
        *head = newNode;
        return;
    }

    // Find the node at the position before the insertion point
    struct Node* current = *head;
    int count = 1;
    while (current != NULL && count <position - 1) {
        current = current->next;
        count++;
    }

    // Check if the position is beyond the list length
    if (current == NULL) {
        printf("Invalid position: Position exceeds list length.\n");
        return;
    }

    // Insert the new node after the current node
    newNode->next = current->next;
    current->next = newNode;
}

// Function to print the contents of the linked list
void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}
