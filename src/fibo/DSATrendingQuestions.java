package fibo;

import java.util.*;

public class DSATrendingQuestions {

    // 1. Kadane's Algorithm (Maximum Subarray Sum)
    public static int kadane(int[] arr) {
        int max = arr[0], cur = 0;
        for (int x : arr) {
            cur = Math.max(x, cur + x);
            max = Math.max(max, cur);
        }
        return max;
    }

    // 2. Two Sum Problem
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = target - arr[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // 3. Missing Number
    public static int missingNumber(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        int arrSum = 0;
        for (int x : arr) arrSum += x;
        return sum - arrSum;
    }

    // 4. Find Duplicate Number
    public static int findDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (!set.add(x)) return x;
        }
        return -1;
    }

    // 5. Reverse Words in a String
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--)
            sb.append(words[i]).append(" ");
        return sb.toString().trim();
    }

    // 6. Palindrome Check
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    // 7. Anagram Check
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    // 8. Balanced Parentheses
    public static boolean isBalanced(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c=='(' || c=='{' || c=='[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if ((c==')' && top!='(') ||
                    (c=='}' && top!='{') ||
                    (c==']' && top!='[')) return false;
            }
        }
        return st.isEmpty();
    }

    // 9. Next Greater Element
    public static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    // 10. Majority Element (Boyer-Moore)
    public static int majorityElement(int[] arr) {
        int count = 0, candidate = 0;
        for (int x : arr) {
            if (count == 0) candidate = x;
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // 11. Leader Elements
    public static List<Integer> leaders(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                res.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(res);
        return res;
    }

    // 12. Merge Two Sorted Arrays
    public static int[] mergeSorted(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[a.length + b.length];
        while (i < a.length && j < b.length)
            ans[k++] = a[i] < b[j] ? a[i++] : b[j++];
        while (i < a.length) ans[k++] = a[i++];
        while (j < b.length) ans[k++] = b[j++];
        return ans;
    }

    // 13. Character Frequency
    public static Map<Character, Integer> freq(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        return map;
    }

    // 14. Longest Common Prefix
    public static String longestPrefix(String[] arr) {
        Arrays.sort(arr);
        String a = arr[0], b = arr[arr.length - 1];
        int i = 0;
        while (i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i))
            i++;
        return a.substring(0, i);
    }

    // 15. Longest Palindromic Substring
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        return r - l - 1;
    }

    // 16. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] arr) {
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1])
                arr[j++] = arr[i];
        }
        return j;
    }

    // 17. Rotate Array by K
    public static void rotate(int[] arr, int k) {
        k %= arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }
    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++; r--;
        }
    }

    // 18. Second Largest Number
    public static int secondLargest(int[] arr) {
        int max = Integer.MIN_VALUE, sec = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max) {
                sec = max;
                max = x;
            } else if (x > sec && x != max) {
                sec = x;
            }
        }
        return sec;
    }

    // 19. Peak Element
    public static int peakElement(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return arr[i];
        }
        return Math.max(arr[0], arr[n - 1]);
    }

    // 20. Max Product Pair
    public static int maxProductPair(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int p1 = arr[n - 1] * arr[n - 2];
        int p2 = arr[0] * arr[1];
        return Math.max(p1, p2);
    }

    // MAIN for samples
    public static void main(String[] args) {
        System.out.println("All DSA methods compiled successfully!");
    }
}
