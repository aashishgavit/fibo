package fibo;

public class BinarySearch {
    public static int search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16};
        System.out.println(search(arr, 12));
    }
}
