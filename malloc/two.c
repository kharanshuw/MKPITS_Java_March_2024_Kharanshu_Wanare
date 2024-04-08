#include <stdio.h> 
#include <stdlib.h> 

int main() 
{ 
	int sum=0;
	int size=0;
    int difference=0;
    int multiplication=1;
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
    for (int i = 0; i < size; i++)
	{
		sum=sum+ptr[i];
	}
	printf("sum of all element is %d",sum);
    for (int i = 0; i < size; i++)
	{
		difference=difference-ptr[i];
	}
    for (int i = 0; i < size; i++)
	{
		multiplication=multiplication*ptr[i];
	}
	
}
