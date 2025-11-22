package fibo;

import java.util.Arrays;

public class bubbleSort 
{
	public static void main(String[] args)
	{
		  
		        int[] a = {5, 1, 4, 2};
		        for (int i = 0; i < a.length; i++)
		            for (int j = 0; j < a.length - i - 1; j++)
		                if (a[j] > a[j + 1]) {
		                    int t = a[j];
		                    a[j] = a[j + 1];
		                    a[j + 1] = t;
		                }
		        System.out.println("Bubble Sort: " + Arrays.toString(a));
		    
	}

}
