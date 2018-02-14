public class myArrayListTests 
{

	public static void main(String[] args) {
		partA();
		partB();
		partC();
		partD();
		partE();
		partF();
		partG();
	}
	
	//part A
	public static void partA()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		startTime = System.currentTimeMillis();
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part A: Add new value to the end.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	//part B
	public static void partB()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		startTime = System.currentTimeMillis();
		for (int i = 2; i<n; i+=2)
		{
			test.add(0,i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part B: Add new value to the beginning.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	//part C
	public static void partC()
	{
		MyArrayList<Integer> test = new MyArrayList<>();
		long startTime, stopTime;
		long n = 100001;
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		startTime = System.currentTimeMillis();
		while(test.isEmpty()==false)
		{
			test.remove(test.size()-1);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part C: Remove value for the end without an iterator.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	public static void partD()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		startTime = System.currentTimeMillis();
		while(test.isEmpty()==false)
		{
			test.remove(0);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part D: Remove each value from the beginning without an iterator.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	public static void partE()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		java.util.Iterator<Integer> itr = test.iterator();
		startTime = System.currentTimeMillis();
		while(itr.hasNext())
		{
			itr.next();
			itr.remove();
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part E: Remove each value from the beginning with an Iterator.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");

	}
	
	public static void partF()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		int sum = 0;
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		startTime = System.currentTimeMillis();
		for(int i = 1; i< n-1; i++)
		{
			sum = sum + test.get(i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part F: Compute the sum.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}

	public static void partG()
	{
		MyArrayList<Integer> test = new MyArrayList<Integer>();
		long startTime, stopTime;
		long n = 100001;
		for (int i = 1; i<n; i++)
		{
			test.add(i);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i<n; i++)
		{
			test.add(0);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part G: Add 0 'N' number of times.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
}
		