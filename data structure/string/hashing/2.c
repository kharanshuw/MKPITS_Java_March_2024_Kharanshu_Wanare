#include <stdio.h>

void countOccurrences(int arr[], int size) {
    
    int count[100] = {0}; // Assuming numbers in the array are between 0 to 99

    // Count occurrences of each number
    for (int i = 0; i < size; i++) {
        count[arr[i]]++;
    }

    // Display the count of occurrences of each number
    printf("Number   Occurrences\n");
    for (int i = 0; i < 100; i++) { // Assuming numbers in the array are between 0 to 99
        if (count[i] > 0) {
            printf("%d   %d\n", i, count[i]);
        }
    }
}

int main() {
    int size;
    printf("Enter the size of the array: ");
    scanf("%d", &size);

    int arr[size];
    printf("Enter %d elements of the array: ", size);
    for (int i = 0; i < size; i++) {
        scanf("%d", &arr[i]);
    }

    countOccurrences(arr, size);

    return 0;
}
