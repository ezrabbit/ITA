import org.junit.Test;

public class MaxSubarray {
    public int findMaxSubarray(int[] arr){
        long start = System.currentTimeMillis();
//        int max = helper(arr, 0, arr.length-1);     //4
//        int max = bruteForce(arr);                     //20
        int max = iteration(arr);                       //0
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return max;
    }

    //Divide-and-Conquer
    private int helper(int[] arr, int low, int high) {
        if(low == high) return arr[low];
        int mid = (low + high) / 2;
        int leftMax = helper(arr, low, mid);
        int rightMax = helper(arr, mid+1, high);
        int crossMax = helper2(arr, low, mid, high);
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int helper2(int[] arr, int low, int mid, int high) {
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE, sum = 0;
        for(int i = mid; i >= low; i--){
            sum += arr[i];
            leftMax = Math.max(sum, leftMax);
        }
        sum = 0;
        for(int i = mid+1; i <= high; i++) {
            sum += arr[i];
            rightMax = Math.max(sum, rightMax);
        }
        return leftMax+rightMax;
    }

    //Brute Force Solution
    public int bruteForce(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum+=arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }

    //Linear time solution based on observation
    public int iteration(int[] arr){
        int maxSub = arr[0], maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = maxSum<0 ? arr[i] : maxSum+arr[i];
            maxSub = Math.max(maxSub, maxSum);
        }
        return maxSub;
    }

    @Test
    public void test(){
        int[] arr = new int[]{-1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, 5, -19, 6, 20, -10, -1, 2, -32, 124, 43, -123, 43, 23, 235, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 43, 1, -4, 32, 12, 543, 15, 66, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 665,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 66, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19, 6, 20, -10, -1, 2, 3, -10, 5, -19,
                92, -32, -12, 12, 45, 56, -32, 124, 43, -123, 43, 23, 235, 43, 1, -4, 32, 12, 543, 15, 65};
        System.out.println(findMaxSubarray(arr));
    }
}
