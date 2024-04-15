#include <stdio.h>

void removeDuplicates() {
    int arr[5]={10,20,10,40,50};
    int temparr[5];
    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 4; j++)
        {
            if (arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j+1]=arr[j];
                arr[j+1]=temp;
            } 
        }
    }
    for (int i = 0; i < 4; i++)
    {
        if (arr[i] != arr[i+1])
        {
            temparr[i]=arr[i];
        }
        
    }
    temparr[4]=arr[4];

    for (int i = 0; i < 5; i++)
    {
        printf("%d  ",temparr[i]);
    }
    
    
    
}

int main() {
  removeDuplicates();
}
