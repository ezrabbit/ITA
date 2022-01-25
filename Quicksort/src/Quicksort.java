import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Quicksort {
    public static int partition(int[] arr, int p, int r){
        if(p < 0 || r>=arr.length)  throw new RuntimeException("invalid index");
        int pivot = arr[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if(arr[j]<=pivot)
                swap(arr, ++i, j);
        }
        swap(arr, i+1, r);
        return i+1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int p, int r){
        if(r > p){
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
