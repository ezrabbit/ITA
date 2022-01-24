import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    public void heapSort(int[] arr){
        int[] tmp = new int[arr.length];
        Heapify.buildMaxHeap(arr);
        for (int i = arr.length-1; i >= 1; i--) {
            Heapify.swap(arr, i, 0);

            tmp = Arrays.copyOfRange(arr, 0, i);
            Heapify.maxHeapify(tmp, 0);
            for (int j = 0; j < i; j++) {
                arr[j] = tmp[j];
            }
        }
    }

    @Test
    public void test(){
        int[] arr = new int[]{16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        int[] arr1 = new int[]{5, 13, 2, 25, 7, 17, 20, 8, 4};
        heapSort(arr);
        heapSort(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
}
