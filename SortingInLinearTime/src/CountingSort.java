import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 5, 7, 6, 4, 4, 6, 3, 2, 4};
        int[] arr2 = new int[]{1, 1, 2, 0};
        int[] arr3 = new int[]{0, 0, 1, 5, 6, 7, 2, 2, 3, 7, 3, 6, 8, 9, 1, 0, 2, 2, 3, 4};
        int[] sortedArr1 = countingSort(arr1, getUpperBound(arr1));
        int[] sortedArr2 = countingSort(arr2, getUpperBound(arr2));
        int[] sortedArr3 = countingSort(arr3, getUpperBound(arr3));
        System.out.println(Arrays.toString(sortedArr1));
        System.out.println(Arrays.toString(sortedArr2));
        System.out.println(Arrays.toString(sortedArr3));
    }

    private static int[] countingSort(int[] arr, int upperBound) {
        int[] sortedArr = new int[arr.length];
        int[] counts = new int[upperBound+1];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i]+=counts[i-1];
        }
        for(int i = arr.length-1; i>=0; i--){
            sortedArr[--counts[arr[i]]] = arr[i];
        }
        return sortedArr;
    }

    private static int getUpperBound(int[] arr) {
       int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
