//Steve Ruan
//EECS 233 HW_8
public class HashTable {
	//declare the two arrays (could be of any size)
	static Integer[] ID = new Integer[20];
	static String[] names = new String[20];
	
	//Quadratic probing
	public static void quadInsert(Integer key, String name)
	{
		//the index at which the key value should be stored
		int index = key%20;
		//if the array at index is empty, fill it
		if(ID[index] == null)
		{
			ID[index]= key;
			names[index] = name;
		}
		//otherwise, quad prob
		else
		{
			int i = 1;
			int temp = index;
			//finding the next open spot
			while(ID[index]!=null)
			{
				index = temp;
				index += (i*i);
				//wrap around
				if(index>19)
				{
					index%=20;
				}	
				i++;
			}
			ID[index] = key;
			names[index] = name;
		}
	}
	
	//Double Hashing
	public static void doubleInsert(Integer key, String name)
	{
		int index = key%20;
		//the formula for how to find the next open slot
		int stepDistance = (7 - (key%7));
		int i =1;
		//while there is not an empty slot in the array
		while(ID[index] != null)
		{
			index += stepDistance;
			index %= 20;
			//wrap around
			while(index>=20)
			{
				index -= 20;
				i++;
			}
		}
		ID[index] = key;
		names[index] = name;
	}
	
	//print method, prints the contents of the array
	public static void print()
	{
		for(int i =0; i<20;i++)
		{
			System.out.println(i + ":" + " " + ID[i] + ", " + names[i]);
		}
	}
		
	
	public static void main(String[] args)
	{
		System.out.println("Quad Probing Insertion");
		quadInsert(0,"Amy");
		quadInsert(1, "Bob");
		quadInsert(19, "Julia");
		quadInsert(200, "Steve");
		quadInsert(201, "Andrew");
		quadInsert(219, "Helen");
		quadInsert(220, "Derrick");
		quadInsert(820, "David");
		quadInsert(821, "Timmy");
		quadInsert(839, "Pablo");
		print();
		System.out.println("\n");
		System.out.println("Double Hashing");
		ID = new Integer[20];
		names = new String[20];
		doubleInsert(0,"Amy");
		doubleInsert(1, "Bob");
		doubleInsert(19, "Julia");
		doubleInsert(200, "Steve");
		doubleInsert(201, "Andrew");
		doubleInsert(219, "Helen");
		doubleInsert(220, "Derrick");
		doubleInsert(820, "David");
		doubleInsert(821, "Timmy");
		doubleInsert(839, "Pablo");
		print();
		
		
		
		
	}

}
