//public class square
//steve ruan
//this class creates the methods for the matrix class. 
public class Square
{
  //create the size
  public static int size;
  //create the sums and initialize them to zero
  public static int mainSum = 0;
  public static int rowSum = 0;
  public static int colSum = 0;
  public static int mainDiagonal = 0;
  public static int secondDiagonal = 0;
  public static int[][] magicSquare = new int[size][size];
  //creates the array.
  public Square(int dimension)
  {
    magicSquare = new int[dimension][dimension];
  }
  //public static void add
//adds the values at a specific location into the array
public static void add(int row, int col, int number)
{
  //add a value to a specific location
  magicSquare[row][col]=number;
}
//public static boolean isMagic
//check if sums are equal
public static boolean isMagic()
  {
  //add the numbers in each array using for each loops
    int x = 0;
    for(int[] row : magicSquare)//for each row in magic square
    {
      for(int thing: row)//for each index in row
        {
        x = x+1;//add items 
      }
    }
    for(int[] col : magicSquare)//for each column in magic square
      {
      for (int thingy : col)//for each index in column
          {
            {
              x= x+1;//add items together
            }
          }
        }
    //compute the magic sum
    for (int index = 0; index<magicSquare.length; index++)
    {
      mainSum+=magicSquare[0][index];
    }
    //compute all the other sums
    for (int index = 0; index<magicSquare.length; index++)
    {
      //compute the two diagonal sums
      mainDiagonal+=magicSquare[index][magicSquare.length-index-1];
      secondDiagonal+=magicSquare[magicSquare.length-index-1][index];
      for (int i = 0; i<magicSquare[index].length; i++)
      {
        //computing the sums or the rows and columns
        rowSum+=magicSquare[i][index];
        colSum+=magicSquare[index][i];
      }
      //Check if it is magic and reset the sums to 0 so when checking the diagonals it does
      //not intefere.
      if ((rowSum!=mainSum)||(colSum!=mainSum))
      {
        return false;
      }
      //reset
      rowSum = 0;
      colSum = 0;
    }
    //Check diagonal sums
    if ((mainDiagonal!=mainSum)||(secondDiagonal!=mainSum))
    {
      return false;
    }
    return true;
  }
}
