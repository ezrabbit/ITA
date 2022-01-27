import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void bucketSort(double[] arr){
        List<Double>[] buckets = new LinkedList[arr.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (int i = 0; i < arr.length; i++) {
            insert(buckets[(int)(arr[i] * arr.length)], arr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < buckets.length; i++) {
            while(buckets[i].size()!=0){
                arr[cnt++] = buckets[i].remove(0);
            }
        }
    }

    private static void insert(List<Double> bucket, double value) {
        int preSize = bucket.size();
        for(int i = bucket.size()-1; i >= 0; i--){
            if(value>=bucket.get(i))    bucket.add(i+1, value);
        }
        if(bucket.size() == preSize)    bucket.add(0, value);
    }

    public static void main(String[] args) {
        double[] arr = new double[]{0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
