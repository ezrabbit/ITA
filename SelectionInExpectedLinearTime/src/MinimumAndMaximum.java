import java.util.ArrayList;
import java.util.List;

public class MinimumAndMaximum {

    public static List<Integer> findMinimumAndMaximum(int[] arr){
        if(arr == null || arr.length == 0) return null;
        int l = arr.length, max, min;
        List<Integer> list = new ArrayList<>();
        if(l%2 == 0){
            if(arr[0] > arr[1]){
                max = arr[0];
                min = arr[1];
            }else{
                max = arr[1];
                min = arr[0];
            }
            for (int i = 2; i < arr.length ; i+=2) {
                if(arr[i+1] > arr[i]){
                    if(arr[i+1] > max)  max = arr[i+1];
                    if(arr[i] < min)    min = arr[i];
                }else{
                    if(arr[i] > max)    max = arr[i];
                    if(arr[i+1] < min)  min = arr[i+1];
                }
            }
        }else{
            max = arr[0];
            min = arr[0];
            for(int i = 1; i < arr.length; i+=2){
                if(arr[i+1] > arr[i]){
                    if(arr[i+1] > max)  max = arr[i+1];
                    if(arr[i] < min)    min = arr[i];
                }else{
                    if(arr[i] > max)    max = arr[i];
                    if(arr[i+1] < min)  min = arr[i+1];
                }
            }
        }
        list.add(min);
        list.add(max);
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3, 1, 7, 8, 0, -1, 20};
        List<Integer> minimumAndMaximum = findMinimumAndMaximum(arr);
        System.out.println(minimumAndMaximum.get(0));
        System.out.println(minimumAndMaximum.get(1));
    }

}
