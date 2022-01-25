import java.util.Arrays;
import java.util.Random;

public class RandomizedQuickSort {
    public static int randomizedPartition(int[] arr, int p, int r){
        Random rand = new Random();
        int index = p + rand.nextInt(r-p+1);
        Quicksort.swap(arr, index, r);
        return Quicksort.partition(arr, p, r);
    }

    public static void randomizedQuickSort(int[] arr, int p, int r){
        if(r > p){
            int q = randomizedPartition(arr, p, r);
            randomizedQuickSort(arr, p, q-1);
            randomizedQuickSort(arr, q+1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        randomizedQuickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
