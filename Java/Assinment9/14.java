package assignment9;

public interface SortingAlgorithm {
    public void sort(int arr[],int l,int m);

}


package assignment9;

public class MergeSort implements SortingAlgorithm{

    void merge(int arr[], int l, int m, int r)
    {
        
        int n1 = m - l + 1;
        int n2 = r - m;

      
        int L[] = new int[n1];
        int R[] = new int[n2];

       
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

      

        
        int i = 0, j = 0;

        
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

       
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    @Override
    public void sort(int[] arr, int l, int r) {
        if (l < r) {

           
            int m = l + (r - l) / 2;

            
            sort(arr, l, m);
            sort(arr, m + 1, r);

            
            merge(arr, l, m, r);
        }
    }
}

package assignment9;

public class QuickSort implements SortingAlgorithm{
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {

        int pivot = arr[high];


        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {


            if (arr[j] < pivot) {


                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    @Override
    public void sort(int[] arr, int low, int high) {
        if (low < high) {


            int pi = partition(arr, low, high);


            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
