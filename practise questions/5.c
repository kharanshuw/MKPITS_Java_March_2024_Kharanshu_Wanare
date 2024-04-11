//find those 4 elment whose sum is smallest
 #include<stdio.h>
void sum()
{
    int arr[10]={10,60,90,74,56,46,93,88};
    int sum=0;
    for (int i = 0; i < 10-1; i++)
    {
        int index=i;
        for (int j = i+1; j < 10; j++)
        {
            if (arr[j]>arr[index])
            {
                index=j;
            }
        }
        int smallest=arr[index];
        arr[index]=arr[i];
        arr[i]=smallest; 
    }
    for (int i = 0; i < 3; i++)
    {
        sum=sum+arr[i];
        printf("%d\t",arr[i]);
    }
    printf("%d",sum);
    
}
int main()
{
    sum();
    return 0;
}