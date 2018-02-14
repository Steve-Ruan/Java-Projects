/*//Steve Ruan
 * We built a HuffmanCoder that compresses a String
 * This is very different from our beta
 * Initially we were going to follow a set of guidelines, but we realized it was inefficient and confusing
 * The way we initialized it is much easier to run in a much more efficient coding practice.
 * We went from 5 classes to 2.
 * We kept huffmanNode, huffmanList and huffmanTree are algorithms in the main method
 * We lost byteWriter and byteCounter.
 *
 *
*///will be using the Arraylist class provided by java
import java.util.ArrayList;
import java.util.Scanner;
public class Huffman {

	//Creating static class variables that will be used later on
	//Class HuffmanNode can be found on the bottom
	static HuffmanNode theNode;
	static HuffmanNode newRoot;
	static String coded = "";

	//Main Method
	public static void main(String[] args) {

		//asking for user input
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a string that you would like to compress");
		String name = sc.nextLine();
		//We used first used the phrase Mississippi River for testing purposes
		//String name = "Mississippi river";
		//To create a cleaner output
		System.out.println();
		// Convert the string to char array
		char[] nameChar = name.toCharArray();
		//explain how the string would be stored without compression
		System.out.println("The number of letters in your phrase is: " + nameChar.length);
		System.out.println("The number of bits to represent your phrase is: " + nameChar.length*8);
		System.out.println();

		//Create an arrayList of the unique letters in the phrase *no repeats*
		ArrayList<Character> letters = new ArrayList<Character>();

		//filling the arraylist - if the letter at a certain index is not in arraylist, add it to the arraylist
		for (int i = 0; i < nameChar.length; i++) {
			if (!(letters.contains(nameChar[i]))) {
				letters.add(nameChar[i]);
			}
		}
		//print out the arraylist
		System.out.println(letters);

		//creating an integer array to tally up the frequencies of each character in the phrase
		int[] frequencies = new int[letters.size()];

		///set each index to 0 to intialize the counts
		for (int x = 0; x < frequencies.length; x++) {
			frequencies[x] = 0;
		}

		//using a nested for loop, go through the character array and determine the number of frequencies each letter has
		//outer for loop - use the arraylist
		for (int i = 0; i < letters.size(); i++) {
			char tally = letters.get(i);
			//go through the character array and if there is a match, add to tally
			for (int x = 0; x < nameChar.length; x++) {
				if (tally == nameChar[x]) {
					frequencies[i]++;
				}
			}
		}

		//Bubble sort algorithm to sort the arrays in descending order.
		for (int i = 0; i < frequencies.length - 1; i++) {
			for (int j = 0; j < frequencies.length - 1; j++) {
				//compares if the next element in the frequencies array is greater than the current
				if (frequencies[j] < frequencies[j + 1]) {
					//if the condition passes, swap the greater one to be the current one, this way the greater frequences
					//come out to be beginning of the array
					int temp = frequencies[j];
					frequencies[j] = frequencies[j + 1];
					frequencies[j + 1] = (char) temp;
					//swap the corresponding letter of frequency,
					char tempChar = letters.get(j);
					letters.set(j, letters.get(j + 1));
					letters.set(j + 1, tempChar);
				}
			}
		}

		//print out the letter and its count
		for (int x = 0; x < frequencies.length; x++) {
			System.out.println(letters.get(x) + " - " + frequencies[x]);
		}
		//Cleaner output
		System.out.println();

		//Forming the Huffman Tree that will binary code each letter.
		//set the root node, end node and current node to be nulle because we do not have a tree yet
		//HuffmanNode class is at the bottom of this class
		HuffmanNode root = null;
		HuffmanNode current = null;
		HuffmanNode end = null;

		//creating a node for each frequency
		for (int i = 0; i < frequencies.length; i++)
		{
			//creating the node, getting the character and its corresponding count.
			//Since the arraylist and frequency array are in the same order
			HuffmanNode node = new HuffmanNode(letters.get(i).toString(), frequencies[i]);
			//for the first node
			//set the root to be the node that was just created
			if(root==null)
			{
			root = node;
			//set the end to be the node that was just created
			end = node;
			}
			//for all other nodes - here we are constructing the linked list of HuffmanNodes to build the Huffman tree
			else
			{
				//set the current node to be the root
				current = root;
				//while current node's right side linked list pointer points to nothing
				while (current.linkRightPointer != null)
				{
					//set current to be the right side linkedlist pointer
					current = current.linkRightPointer;
				}
				//set the right side pointer to be the node that was created
				current.linkRightPointer = node;
				//set the right side's left side pointer to be the current node
				current.linkRightPointer.linkLeftPointer = current;
				//set the end node to be the node that was just created
				end = node;
			}
		}

		// Recursively build the tree
		HuffmanTree(root, end);

		//Doing the Binary encoding
		char[] charArray = name.toCharArray();
		char checker;
		System.out.println("Binary Encoding");
		//for every character in the phrase
		for (int i = 0; i < charArray.length; i++)
		{
			//set the current to the class variable "theNode"
			current = theNode;
			//set the character to be the checker to see if it matches with nodes' bit value
			checker = charArray[i];
			//initialize an empty string for the binary code for each letter
			String binaryCode = "";
			//binary encoding algorithm
			while (true)
			{
				//Left branch, encode a 0
				if (current.left.bit.toCharArray()[0] == checker)
				{
					binaryCode += "0";
					System.out.println("The letter: " + charArray[i] + " maps to: " + binaryCode);
					break;
				}
				//Right branch, encode a 1
				else
				{
					binaryCode += "1";
					if (current.right != null)
					{
						if (current.right.bit.toCharArray()[0] == letters.get(frequencies.length - 1))
						{
							System.out.println("The letter: " + charArray[i] + " maps to: " + binaryCode);
							break;
						}
						current = current.right;
					}
					else
					{
						System.out.println("The letter: " + charArray[i] + " maps to: " + binaryCode);
						break;
					}
				}
			}
			coded += binaryCode;
		}
		//prints out result
		System.out.println();
		System.out.println("The coded string is " + coded);
		System.out.println("The coded string contains " + coded.length() + " bits, which has " + ((name.length()*8) - coded.length()) + " less bits");
	}

	//HuffmanTree
	//takes huffman node root and end as parameter
	//Using the HuffmanList that was just created, we build up the tree.
	public static void HuffmanTree(HuffmanNode root, HuffmanNode end)
	{
		//class variable "theNode" is set to be a new huffmanNode
		//parameters takes the end's left linkedlist pointer's bit value along with the end's bit value
		//takes the count of the linkedlist left pointer's bit count added with the end'd bit count
		theNode = new HuffmanNode(end.linkLeftPointer.bit + end.bit, end.linkLeftPointer.count
				+ end.count);
		theNode.left = end.linkLeftPointer;
		theNode.right = end;
		end.linkLeftPointer.linkLeftPointer.linkRightPointer = theNode;
		theNode.linkLeftPointer = end.linkLeftPointer.linkLeftPointer;
		end = theNode;
		end.linkRightPointer = null;
		HuffmanNode current = root;

		//while the current's linkedlist right pointer is empty
		while (current.linkRightPointer != null)
		{
			//set it to be the new right pointer
			current = current.linkRightPointer;
		}

		//if the root's linkedlist right pointer points to the end node
		if (root.linkRightPointer == end)
		{
			//create a new HuffmanNode
			theNode = new HuffmanNode(root.bit + end.bit, root.count + end.count);
			theNode.left = root;
			theNode.right = end;
			theNode.linkRightPointer = null;
			theNode.linkLeftPointer = null;
			newRoot = theNode;
		}
		//recursively build the tree
		else
		{
			HuffmanTree(root, end);
		}
	}

}

//Class HuffmanNode
//These nodes will be help build the tree
class HuffmanNode {

	//bit is the letter
	String bit;
	//count is the frequency of the letter
	int count;
	//pointer to left
	HuffmanNode left;
	//pointer to right
	HuffmanNode right;
	//linkedlist Right pointer
	HuffmanNode linkRightPointer;
	//linkedlist Left pointer
	HuffmanNode linkLeftPointer;

	//Constructor taking two parameters, the character in the form of a string and the count of that character
	HuffmanNode(String value, int count) {

		this.bit = value;
		this.count = count;
		this.left = null;
		this.right = null;
		this.linkRightPointer = null;
		this.linkLeftPointer = null;

	}
}
