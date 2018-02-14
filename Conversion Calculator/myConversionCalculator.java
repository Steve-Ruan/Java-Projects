package myConversionCalculator;

import java.util.*;
public class myConversionCalculator
{
  //main method
  public static void main(String [] args)
  {
    //declare and instantiate the scanner
    Scanner sc = new Scanner(System.in);
    //loop two times
    for(int counter=0;counter<2;counter++)
    {
//asking the user for a number type
    System.out.print("What type of number do you wish to be converted? (Decimal, Binary or Hex");
    //allowing the user to input either decimal, binary or hex
    String input = sc.nextLine();
    //if the user inputs binary
    if(input.equals("Binary"))
         {
      //ask the user what type of number they wish to convert it into
      System.out.println("What type of number do you wish for it to be converted to?(Decimal or Hex)");
      //allows the user to input either decimal or hex
      String input2 = sc.nextLine();
      //if the user inputs decimal
      if(input2.equals("Decimal"))
           {
        //ask the user for the binary number
        System.out.println("Please enter the binary number");
        //allow the user to input the number and store it as a string
        String str = sc.nextLine();
        //convert it to a decimal and store that in an integer variable
        int i= Integer.parseInt(str,2);
        //output the result
        System.out.println(i);
      }
    //if the user wants the binary to be converted to a hexadecimal
      else if(input2.equals("Hex"))
    {
      //Ask the user to input the binary  number
        System.out.println("Please enter the binary number");
      //allow the user to input the binary number and store it as a string
        String str = sc.nextLine();
      //convert it to a hexadecimal and store it in an integer variable
        int i =Integer.parseInt(str,2);
        String bob = Integer.toHexString(i);
      //output the result
        System.out.println(bob);
    }
    }
    //if the user wants to a convert a decimal
    else if(input.equals("Decimal"))
         {
      //ask what type of number does he want it to convert into, a binary or hex
      System.out.println("What type of number do you wish to be converted to?(Binary or Hex)");
      //take the user input and store it in a string variable
      String input3 = sc.nextLine();
      //if the input 
      if(input3.equals("Binary"))
           {
        //asking the user for the decimal
        System.out.println("Please enter the Decimal number");
        //Allowing user input and storing it as a string variable
        String str = sc.nextLine();
        //converting the string to an integer
        int i = Integer.parseInt(str);
        //converting the integer to a binary 
        String bob = Integer.toBinaryString(i);
        //output the binary
        System.out.println(bob);
      }
      //if the input is hexadecimal
      else if(input3.equals("Hex"))
      {
        //ask the user for the decimal
        System.out.println("Please enter the Decimal number");
        //allow user input and store it as a string variable
        String str = sc.nextLine();
        //converting it as an integer
        int i = Integer.parseInt(str);
        //convert it to a hexadecimal 
        String bob = Integer.toHexString(i);
        //output the result
        System.out.println(bob);
         }
    }
    //if the user wants a hexadecimal to be converted
    else if(input.equals("Hex"))
    {
      //ask what type of number do you wish the hex to be converted into
      System.out.println("What type of number do you wish this to be converted to?(Binary or Decimal)");
      //allow user input and store it in a variable
      String input4 = sc.nextLine();
      //if user inputs decimal
      if(input4.equals("Decimal"))
      {
       //ask for the hex input
        System.out.println("Please Enter the Hexadecimal number"); 
       //allow for user input and store it in a variable
        String str = sc.nextLine();
       //convert it to integer
        int i = Integer.parseInt(str,16);
       //convert it to base 10
        String bob = Integer.toString(i,10);
       //output the result
        System.out.println(bob);
      }
      //if user wants hex to be converted to a binary
      else if(input4.equals("Binary"))
      {
        //ask for the hex number
        System.out.println("Please enter the Hexadecimal number");
        //allow user input and store it in a string
        String str = sc.nextLine();
        //convert to integer
        int i = Integer.parseInt(str,16);
        //convert to binary
        String bob = Integer.toBinaryString(i);
        //output result
        System.out.println(bob);
      }
    }
    }
 
 
  }
}