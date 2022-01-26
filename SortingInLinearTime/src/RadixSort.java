import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1329, 5457, 657, 39, 4436, 111112, 111113};
        radixSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr, int d) {
        for(int i = 1; i<=d; i++){
            countingSortBasedOnRadix(arr, i);
        }
    }

    private static void countingSortBasedOnRadix(int[] arr, int radix) {
        int[] sortedArr = new int[arr.length];
        int[] count = new int[11];
        for (int i = 0; i < arr.length; i++) {
            count[extractDigit(arr[i], radix)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i]+=count[i-1];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            sortedArr[--count[extractDigit(arr[i], radix)]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
    }

    private static int extractDigit(int number, int radix) {
        return (int)(number%(Math.pow(10, radix))/(Math.pow(10, radix-1)));
    }

}
