import java.util.*;
import javax.swing.*;
//public class matrix
//steve ruan
//this class creates a magic square and checks if it is a magic square
public class matrix
{
//  JFrame steveWorld = new JFrame("Steve's world");
  //create class variables
  static int size;
  static int magicSquare[][];
  static int sums = (2*size)+2;
  static int[] sum = new int[sums];
  Square square = new Square(size);
  //main method
  public static void main(String[] args)
  {
   //creat the gui
   JFrame steveWorld = new JFrame("Steve's world");
   //ask user for the length of the square
   String l = JOptionPane.showInputDialog("length of square?");
   //convert the string into an int
   size = Integer.parseInt(l);
   //create the array
   Square magicSquare = new Square(size);
   //create the number of spaces for the user to input
   double boxes = Math.pow(size, 2.0);
   //ask user to input values
   for(int rowNum = 1; rowNum<size+1; rowNum++)
   {
   //ask user to input values in a specific row
   JOptionPane.showMessageDialog(steveWorld,"Enter numbers in row:" + " " + rowNum);
   //repeat this to fill the row.
   for(int repeat=0; repeat<size; repeat++)
   {
     //the number
     String k = JOptionPane.showInputDialog(steveWorld,"number: ");
     //convert to integer
     int number = Integer.parseInt(k);
     //the column
     String j = JOptionPane.showInputDialog(steveWorld,"At Column: (Type the number thats one less than the desired column."
                                              + "\n" + "For example, if you wish to place a number in the first column, type 0)");
     //convert to integer
     int col = Integer.parseInt(j);
     //add the info to the array
     magicSquare.add(rowNum-1, col, number);
   }
   }
   //check if it is magic
   boolean magic = magicSquare.isMagic();
    if(magic==true)
    {
      //i magic, say it is
      JOptionPane.showMessageDialog(steveWorld, "your matrix is a magic square");
    }
    else
    {
      //else say no.
      JOptionPane.showMessageDialog(steveWorld, "your matrix is not a magic square");
    }
  }
}

    