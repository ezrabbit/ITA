import org.junit.Test;

import java.util.Arrays;

public class Heapify {
    private int[] arr11 = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
    private int[] arr12 = new int[]{27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
    private int[] arr22 = new int[]{3, 1, 2};
    private int[] arr21 = new int[]{1, 6, 10, 2, 3, 12, 13, 4, 5};

    public void maxHeapify(int[] arr, int i){
        int largest = i, left = getLeftChild(arr, i), right = getRightChild(arr, i);
        if(left > arr[largest])  largest = 2*(i+1)-1;
        if(right > arr[largest]) largest = 2*(i+1)+1-1;
        if(largest!=i){
            swap(arr, i, largest);
            maxHeapify(arr, largest);
        }
    }

    private int getRightChild(int[] arr, int i) {
        return 2*(i+1)+1-1<arr.length ? arr[2*(i+1)+1-1] : Integer.MIN_VALUE;
    }

    private int getLeftChild(int[] arr, int i) {
        return 2*(i+1)-1<arr.length ? arr[2*(i+1)-1] : Integer.MIN_VALUE;
    }

    //iteration
    //1 3 2
    public void maxHeapify1(int[] arr, int i){
        int cur = i, largest, left, right;
        while(true){
            largest = cur;
            left = getLeftChild(arr, cur);
            right = getRightChild(arr, cur);
            if(left > arr[largest]) largest = 2*(cur+1)-1;
            if(right > arr[largest])    largest = 2*(cur+1)+1-1;
            if(largest!=cur){
                swap(arr, cur, largest);
                cur = largest;
            }else{
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test11(){
        //find the node that needs to be max-heapified
        int node, left, right;
        for (int i = 0; i < arr11.length; i++) {
            node = arr11[i];
            left = getLeftChild(arr11, i);
            right = getRightChild(arr11, i);
            if(node < left || node < right){
                maxHeapify1(arr11, i);
                break;
            }
        }
        System.out.println(Arrays.toString(arr11));
    }

    @Test
    public void test12(){
        //find the node that needs to be max-heapified
        int node, left, right;
        for (int i = 0; i < arr12.length; i++) {
            node = arr12[i];
            left = getLeftChild(arr12, i);
            right = getRightChild(arr12, i);
            if(node < left || node < right){
                maxHeapify(arr12, i);
                break;
            }
        }
        System.out.println(Arrays.toString(arr12));
    }

    public void minHeapify(int[] arr, int i){
        int smallest = i, left = 2*(i+1)-1<arr.length ? arr[2*(i+1)-1] : Integer.MAX_VALUE, right = 2*(i+1)+1-1<arr.length ? arr[2*(i+1)+1-1] : Integer.MAX_VALUE;
        if(left < arr[smallest])    smallest = 2*(i+1)-1;
        if(right < arr[smallest])   smallest = 2*(i+1)+1-1;
        if(smallest!=i){
            swap(arr, i, smallest);
            minHeapify(arr, smallest);
        }
    }

    @Test
    public void test21(){
        int node, left, right;
        //find the node that needs to be min-heapified
        for (int i = 0; i < arr21.length; i++) {
            node = arr21[i];
            left = getLeftChild(arr21, i);
            right = getRightChild(arr21, i);
            if(node > left || node > right){
                minHeapify(arr21, i);
                break;
            }
        }
        System.out.println(Arrays.toString(arr21));
    }
    @Test
    public void test22(){
        int node, left, right;
        //find the node that needs to be min-heapified
        for (int i = 0; i < arr22.length; i++) {
            node = arr22[i];
            left = getLeftChild(arr22, i);
            right = getRightChild(arr22, i);
            if(node > left || node > right){
                minHeapify(arr22, i);
                break;
            }
        }
        System.out.println(Arrays.toString(arr22));
    }

    public void buildMaxHeap(int[] arr){
        int l = arr.length;
        for (int i = l/2-1; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    @Test
    public void testBuildMaxHeap1(){
        int[] arr1 = new int[]{4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        buildMaxHeap(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test
    public void testBuildMaxHeap2(){
        int[] arr2 = new int[]{5, 3, 17, 10, 84, 19, 6, 22, 9};
        buildMaxHeap(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
