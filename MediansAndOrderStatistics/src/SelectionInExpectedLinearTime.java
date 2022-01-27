import java.util.Random;

public class SelectionInExpectedLinearTime {
    public static int randomizedSelected(int[] arr, int p, int r, int i){
        if(p == r)  return arr[p];
        int q = randomizedPartition(arr, p, r);
        int k = q - p + 1;
        if(k == i)  return arr[q];
        if(k > i)
            return randomizedSelected(arr, p, q-1, i);
        else
            return randomizedSelected(arr, q+1, r, i-k);
    }

    private static int randomizedPartition(int[] arr, int p, int r) {
        Random rand = new Random();
        int pivot = p + rand.nextInt(r-p+1);
        swap(arr, pivot, r);
        return partition(arr, p, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int i = p-1, pivot = arr[r];
        for (int j = p; j < r; j++) {
            if(arr[j] < pivot){
                swap(arr, j, ++i);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }

    private static void swap(int[] arr, int pivot, int r) {
        int tmp = arr[pivot];
        arr[pivot] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{50, 3, 1, 7, 9, 10};
        System.out.println(randomizedSelected1(arr, 0, arr.length - 1, 3));
    }

    //iteration
    public static int randomizedSelected1(int[] arr, int p, int r, int i){
        if(p == r)  return arr[p];
        int q, k;
        while(p<r){
            q = randomizedPartition(arr, p, r);
            k = q - p + 1;
            if(k == i)  return arr[q];
            if(k > i){
                r = q - 1;
            }else{
                p = q + 1;
                i = i - k;
            }
        }
        return arr[p];
    }
}
