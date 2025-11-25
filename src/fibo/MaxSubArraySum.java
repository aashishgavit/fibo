package fibo;

public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = arr[0];
        int cur = 0;

        for (int x : arr) {
            cur = Math.max(x, cur + x);  // Update current sum
            max = Math.max(max, cur);    // Update max sum
        }

        System.out.println("Maximum Subarray Sum = " + max);
    }
}
