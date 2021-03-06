import java.util.Scanner;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>>
{
    /**
     * Construct the binary heap.
     */
    public BinaryHeap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap( int capacity )
    {
        currentSize = 0;
        array = (AnyType[]) new Comparable[ capacity + 1 ];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap( AnyType [ ] items )
    {
            currentSize = items.length;
            array = (AnyType[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

            int i = 1;
            for( AnyType item : items )
                array[ i++ ] = item;
            buildHeap( );
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

        array[currentSize+1] = x;
        percolateUp(currentSize +1);
        ++currentSize;
    }


    private void enlargeArray( int newSize )
    {
            AnyType [] old = array;
            array = (AnyType []) new Comparable[ newSize ];
            for( int i = 0; i < old.length; i++ )
                array[ i ] = old[ i ];        
    }
    
    public void printHeap() {
    	System.out.print("Array: ");
        for(int i = 1; i < array.length; ++i)
           System.out.print(array[i] + " ");
     }
     
    public void printHeapAsTree() {
        System.out.println();                                      
        int itemsPerRow = 1;
        int column = 0;
        int j = 1; 
        int nBlanks = 32;
        String line = "---------------------------------";
        System.out.println(line+line);      
        while(currentSize > 0)              
           {
           if(column == 0)                  
              for(int k=0; k<nBlanks; k++)
              {
                 System.out.print(' ');
              }
           
           System.out.print(array[j]);

           if(++j == currentSize)           
              break;

           if(++column==itemsPerRow)        
              {
              nBlanks /= 2;                 
              itemsPerRow *= 2;             
              column = 0;                   
              System.out.println();        
              }
           else                            
              for(int k=0; k<nBlanks*2-2; k++)
              {
                 System.out.print(' ');
              }
           }  
        System.out.println("\n"+line+line); 
        }  
    /**
     * Find the smallest item in the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMax( )
    {
//        if( isEmpty( ) )
//            throw new UnderflowException( );
        return array[ 1 ];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMax( )
    {
 //       if( isEmpty( ) )
 //           throw new UnderflowException( );
    	if(currentSize ==0)
    	{
    		throw new IllegalArgumentException("Heap is empty");
    	}
    	else
    	{
    		array[0] = array[currentSize-1];
    		currentSize --;
    		return array[0];
    	}
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateUp( i );
    }

    /**
     * Test if the priority queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty( )
    {
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;      // Number of elements in heap
    private AnyType [ ] array; // The heap array

    /**
     * Internal method to percolate up in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateUp( int hole )
    {
        int child;
        AnyType tmp = array[ hole ];

        for(child = hole; child > 1 && tmp.compareTo(array[child/2]) > 0; child /=2)
        {
        	array[child/2] = array[child];
        }
        array[ hole ] = tmp;
    }
    
    public static void main(String...arg)
    {
    	Scanner sc = new Scanner(System.in);
        System.out.println("How big is your heap?");
        int size = sc.nextInt();
        int input;
        BinaryHeap maxHeap = new BinaryHeap(size);
        for(int i = 0; i<size; i++)
        {
        	System.out.println("Please enter a number that is part of your heap");
        	input = sc.nextInt();
        	maxHeap.insert(input);
        }
        maxHeap.printHeap();
        maxHeap.printHeapAsTree();
        
}
}