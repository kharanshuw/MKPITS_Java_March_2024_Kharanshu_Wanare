#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Function prototypes
void createList(struct Node** head, int data);
void deleteAtPosition(struct Node** head, int position);
void printList(struct Node* head);

int main() {
    struct Node* head = NULL; // Initially empty list

    // Create a sample linked list (modify as needed)
    createList(&head, 10);
    createList(&head, 20);
    createList(&head, 30);

    printf("Original linked list: ");
    printList(head);

    int position;

    printf("Enter the position of the node to delete (1-based): ");
    scanf("%d", &position);

    deleteAtPosition(&head, position);

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

// Function to delete a node at the specified position in the linked list
void deleteAtPosition(struct Node** head, int position) {
    if (position < 1) {
        printf("Invalid position: Position cannot be less than 1.\n");
        return;
    }

    struct Node* temp = *head;
    struct Node* prev = NULL;

    // Handle deletion of the head node (position 1)
    if (position == 1) {
        *head = temp->next;
        free(temp);
        return;
    }

    // Find the node at the position before the deletion point
    int count = 1;
    while (temp != NULL && count < position) {
        prev = temp;
        temp = temp->next;
        count++;
    }

    // Check if the position is beyond the list length
    if (temp == NULL) {
        printf("Invalid position: Position exceeds list length.\n");
        return;
    }

    // Handle deletion from the middle or end of the list
    prev->next = temp->next;
    free(temp);
}

// Function to print the contents of the linked list
void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}
