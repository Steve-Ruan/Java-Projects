import java.util.*;
import java.util.Random;

public class HashTable {
	
	public static int hash(int key, int hkey)
	{
		int hash = key%hkey;
		return hash;
	}
	
	public static void problem3(int size)
	{
		int[] hashTable = new int[size];
		int totCol = 0;
		int maxCol = 0;
		int key;
		
		for(int i =0; i<10001; i++)
		{
			key = hash(i, size);
			hashTable[key]++;
		}
		
		for(int j =0;j<size;j++)
		{
			totCol = totCol + hashTable[j]-1;
			if(maxCol < hashTable[j])
			{
				maxCol = hashTable[j];
			}
			
			
		}
		System.out.print("Maximum Collision: " + maxCol + ", " + "Total Collisions: " + totCol);

		
	}
	public static void problem4(int size, int key, int max)
	{
		Random r = new Random();
		for(int x =0; x<3;x++)
		{
		int[] hashTable = new int[size];
		int totCol = 0;
		int maxCol = 0;
		int hash;
		for(int i = 0; i < key; i++)
		{
			int randomKey = r.nextInt(max)+1;
			hash = hash(randomKey,size);
			hashTable[hash]++;
			
		}
		for(int j=0;j<size;j++)
		{
			if(hashTable[j] == 0)
				totCol = totCol + hashTable[j];
			else
				totCol = totCol + hashTable[j]-1;
			
			if(maxCol < hashTable[j])
				maxCol = hashTable[j];
			
		}
		
		System.out.print("Maximum Collision: " + maxCol + ", " + "Total Collisions: " + totCol + "\n");
	}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to run problem 3 or problem 4, enter a number (3 or 4)");
		int problem = sc.nextInt();
		switch (problem)
		{
		case 3:
			System.out.println("Please enter the size of your array");
			int size = sc.nextInt();
			problem3(size);
			break;
			
		case 4:
			System.out.println("Please enter the size of your array");
			int arraySize = sc.nextInt();
			System.out.println("Please enter the number of key values");
			int keys = sc.nextInt();
			System.out.println("Please enter the maximum for key values");
			int max = sc.nextInt();
			problem4(arraySize, keys, max);
			break;
		}
		
		
	
		
		
	}
}
