#include <stdio.h>
#include <stdlib.h>

// Define the node structure
struct Node {
  int data;
  struct Node* next;
};

// Function prototypes
struct Node* newNode(int data);
int isEmpty(struct Node* head);
void push(struct Node** head, int data);
int pop(struct Node** head);
void display(struct Node* head);

int main() {
  struct Node* head = NULL;

  push(&head, 10);
  push(&head, 20);
  push(&head, 30);

  printf("Stack elements: \n");
  display(head);

  printf("Popped element: %d\n", pop(&head));

  printf("Stack elements after pop: \n");
  display(head);

  return 0;
}

// Function to create a new node
struct Node* newNode(int data) {
  struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
  temp->data = data;
  temp->next = NULL;
  return temp;
}

// Check if the stack is empty
int isEmpty(struct Node* head) {
  return head == NULL;
}

// Push an element onto the stack
void push(struct Node** head, int data) {
  struct Node* new_node = newNode(data);
  new_node->next = *head;
  *head = new_node;
  printf("Pushed %d to stack\n", data);
}

// Pop an element from the stack
int pop(struct Node** head) {
  if (isEmpty(*head)) {
    printf("Stack underflow\n");
    return -1;
  }
  struct Node* temp = *head;
  int popped_data = temp->data;
  *head = temp->next;
  free(temp);
  return popped_data;
}

// Display the elements of the stack
void display(struct Node* head) {
  if (isEmpty(head)) {
    printf("Stack is empty\n");
    return;
  }
  while (head != NULL) {
    printf("%d ", head->data);
    head = head->next;
  }
  printf("\n");
}
