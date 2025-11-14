package fibo;

public class practice 
{
	public static void main(String[] args) 
	{
		int nTerm=10 , firstTerm = 0, secondTerm= 1;
		
		for(int i=0; i<=nTerm; i++)
		{
			
			System.out.println(firstTerm + " ");
			
			int nextTerm = firstTerm + secondTerm;
			firstTerm =secondTerm;
			secondTerm = nextTerm;
						
		}
		
	}

}
