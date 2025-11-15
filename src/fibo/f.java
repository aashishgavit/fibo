package fibo;

public class f
{
	static int a = 0, b = 1;
	
	static void printf(int n)
	{
		if(n==0) return;
		System.out.println(a + " ");
		
		int c = a + b;
			a = b;
			b = c;
		printf(n-1);
	}
	
	public static void main(String[] args)
	{
		printf(10);
	}
	

}
