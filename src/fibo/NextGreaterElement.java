package fibo;

import java.util.*;

public class NextGreaterElement {

    public static void nextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove elements smaller or equal to current
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack empty, no greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element
            stack.push(arr[i]);
        }

        // Print result
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        nextGreater(arr);
    }
}
