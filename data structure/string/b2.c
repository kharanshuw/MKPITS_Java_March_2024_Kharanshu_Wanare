#include<stdio.h>

void mybinarysearch()
{
    int arr[5]={10,20,30,40,50};
    int no=40;
    int mid,min,max,size;
    min=0;
    int flag=0;
    max= 5;
    mid=(min+max)/2;
    for ( mid=(min+max)/2; min<=max ;mid=(min+max)/2)
    {
        
       if (arr[mid]==no)
       {
            flag=1;
            break;
       }
       if (arr[mid]<no)
       {
        min=mid+1;
       }
       else
       {
        max=mid-1;
       }

    }
    
  
    if (flag==1)
    {
        printf("no found at %d",mid);
    }
    else
    {
        printf("no not found");
    }
    
}

int main()
{
mybinarysearch();
return 0;
}