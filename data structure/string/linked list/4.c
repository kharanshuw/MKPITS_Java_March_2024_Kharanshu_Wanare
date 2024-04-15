#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Function prototypes
void createList(struct Node** head, int data);
void searchAndPrintPosition(struct Node* head, int searchData);

int main() {
    struct Node* head = NULL; // Initially empty list

    // Create a linked list with some sample data (modify as needed)
    createList(&head, 10);
    createList(&head, 20);
    createList(&head, 30);
    createList(&head, 40);

    printf("Original linked list: ");
    // Print the list (optional for demonstration)
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    int searchValue;
    printf("Enter the number to search: ");
    scanf("%d", &searchValue);

    searchAndPrintPosition(head, searchValue);

    return 0;
}

// Function to create a new node and insert it at the beginning of the list
void createList(struct Node** head, int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = *head;
    *head = newNode;
}

// Function to search for a number in the linked list and print its position
void searchAndPrintPosition(struct Node* head, int searchData) {
    int position = 1;
    struct Node* current = head;

    while (current != NULL) {
        if (current->data == searchData) {
            printf("%d found at position %d\n", searchData, position);
            return; // Exit the function if found
        }
        current = current->next;
        position++;
    }

    printf("%d not found in the linked list.\n", searchData);
}
