#include<stdlib.h>
#include<stdio.h>
void mymalloc(){
    int size=0;
    int no=0;
    printf("enter the size of array");
    scanf("%d",&size);
    int *ptr;
    ptr=malloc(size*sizeof(int));
    for (int i = 0; i < size; i++)
    {
        printf("enter array element");
        scanf("%d",&no);
        ptr[i]=no;
    }
      printf("element of dynamic array ");
    for (int j = 0; j < size; j++)
    {
        printf("%d\t",ptr[j]);
    }

    free(ptr);
}


int main(){
    mymalloc();
    return 0;
}