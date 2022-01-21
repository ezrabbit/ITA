import org.junit.Test;

import java.util.Arrays;

public class Heapify {
    private int[] arr11 = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
    private int[] arr12 = new int[]{27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
    private int[] arr22 = new int[]{3, 1, 2};
    private int[] arr21 = new int[]{1, 6, 10, 2, 3, 12, 13, 4, 5};

    public void maxHeapify(int[] arr, int i){
        int largest = i, left = 2*(i+1)-1<arr.length ? arr[2*(i+1)-1] : Integer.MIN_VALUE, right = 2*(i+1)+1-1<arr.length ? arr[2*(i+1)+1-1] : Integer.MIN_VALUE;
        if(left > arr[largest])  largest = 2*(i+1)-1;
        if(right > arr[largest]) largest = 2*(i+1)+1-1;
        if(largest!=i){
            swap(arr, i, largest);
            maxHeapify(arr, largest);
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
            if((i+1)*2-1<arr11.length)
                left = arr11[(i+1)*2-1];
            else
                left = Integer.MIN_VALUE;
            if((i+1)*2+1-1<arr11.length)
                right = arr11[(i+1)*2+1-1];
            else
                right = Integer.MIN_VALUE;
            if(node < left || node < right){
                maxHeapify(arr11, i);
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
            if((i+1)*2-1<arr12.length)
                left = arr12[(i+1)*2-1];
            else
                left = Integer.MIN_VALUE;
            if((i+1)*2+1-1<arr12.length)
                right = arr12[(i+1)*2+1-1];
            else
                right = Integer.MIN_VALUE;
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
            if((i+1)*2-1<arr21.length)
                left = arr21[(i+1)*2-1];
            else
                left = Integer.MIN_VALUE;
            if((i+1)*2+1-1<arr21.length)
                right = arr21[(i+1)*2+1-1];
            else
                right = Integer.MIN_VALUE;
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
            if((i+1)*2-1<arr22.length)
                left = arr22[(i+1)*2-1];
            else
                left = Integer.MIN_VALUE;
            if((i+1)*2+1-1<arr22.length)
                right = arr22[(i+1)*2+1-1];
            else
                right = Integer.MIN_VALUE;
            if(node > left || node > right){
                minHeapify(arr22, i);
                break;
            }
        }
        System.out.println(Arrays.toString(arr22));
    }



}
