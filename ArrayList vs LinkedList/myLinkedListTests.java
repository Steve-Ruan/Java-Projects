public class myLinkedListTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		partA();
		partB();
		partC();
		partD();
		partE();
		partF();
		partG();
		
	}
	
	//add to beginning
	public static void partA()
	{
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for(int i = 1; i < n; i++)
		{
			test.add(i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part A: Add new value to the end.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	//add to end
	public static void partB()
	{
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		startTime = System.currentTimeMillis();
		for(int i = 1; i < n; i++)
		{
			test.add(0,i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part B: Add new value to the beginning.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
		
	}

	//add to the end, and remove all values
	public static void partC()
	{
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 1; i < n; i++)
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
	
	//add to the beginning and remove all values
	public static void partD()
	{
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 1; i < n; i++)
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
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 1; i < n; i++)
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
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		int sum = 0;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 1; i < n; i++)
		{
			test.add(i);
		}
		startTime = System.currentTimeMillis();
		for(int i = 0; i< n-1; i++)
		{
			sum += test.get(i);
		}
		stopTime = System.currentTimeMillis();
		System.out.println("Part F: Compute the sum.");
		System.out.println("The N value used is " + n);
		System.out.println("The run time is "+ ((stopTime - startTime)/1000.0) + " seconds");
	}
	
	public static void partG()
	{
		long startTime, stopTime; //for recording start and stop time
		long n = 100001;
		MyLinkedList<Integer> test = new MyLinkedList<Integer>();
		for(int i = 1; i < n; i++)
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
