
public class Sort {
	// Print array contents
    public static <AnyType extends Comparable<? super AnyType>> 
	void printArray(AnyType[] a, int start, int stop) {
		if (0 <= start && start < a.length && 0 <= stop && stop < a.length) {
			for(int i = start; i <= stop; i++)
				System.out.print(a[i] + " ");
			System.out.println();
		}
	}

    /**
     * Simple insertion sort.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void insertionSort( AnyType [ ] a )
    {
        int j;

        for( int p = 1; p < a.length; p++ )
        {
            AnyType tmp = a[ p ];
            for( j = p; j > 0 && tmp.compareTo( a[ j - 1 ] ) < 0; j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }

    /**
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }
    
    /**
     * Internal method for heapsort that is used in deleteMax and buildHeap.
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void percDown( AnyType [ ] a, int i, int n )
    {
        int child;
        AnyType tmp;

        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0 )
                child++;
            if( tmp.compareTo( a[ child ] ) < 0 )
                a[ i ] = a[ child ];
            else
                break;
        }
        a[ i ] = tmp;
    }
    
    /**
     * Standard heapsort.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void heapsort( AnyType [ ] a )
    {
        for( int i = a.length / 2 - 1; i >= 0; i-- )  /* buildHeap */
            percDown( a, i, a.length );
        for( int i = a.length - 1; i > 0; i-- )
        {
            swapReferences( a, 0, i );                /* deleteMax */
            percDown( a, 0, i );
            Sort.printArray(a, 0, a.length - 1);
        }
    }

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static <AnyType> void swapReferences( AnyType [ ] a, int index1, int index2 )
    {
        AnyType tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Mergesort algorithm.
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a )
    {
        AnyType [ ] tmpArray = (AnyType[]) new Comparable[ a.length ];

        mergeSort( a, tmpArray, 0, a.length - 1 );
    }

    /**
     * Internal method that makes recursive calls.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void mergeSort( AnyType [ ] a, AnyType [ ] tmpArray,
               int left, int right )
    {
        if( left < right )
        {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            Sort.printArray(a, left, center);
            mergeSort( a, tmpArray, center + 1, right );
            Sort.printArray(a, center+1, right);
            merge( a, tmpArray, left, center + 1, right );
            
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     * @param a an array of Comparable items.
     * @param tmpArray an array to place the merged result.
     * @param leftPos the left-most index of the subarray.
     * @param rightPos the index of the start of the second half.
     * @param rightEnd the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>>
    void merge( AnyType [ ] a, AnyType [ ] tmpArray, int leftPos, int rightPos, int rightEnd )
    {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        // Main loop
        while( leftPos <= leftEnd && rightPos <= rightEnd )
            if( a[ leftPos ].compareTo( a[ rightPos ] ) <= 0 )
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        while( leftPos <= leftEnd )    // Copy rest of first half
            tmpArray[ tmpPos++ ] = a[ leftPos++ ];

        while( rightPos <= rightEnd )  // Copy rest of right half
            tmpArray[ tmpPos++ ] = a[ rightPos++ ];

        // Copy tmpArray back
        for( int i = 0; i < numElements; i++, rightEnd-- )
            a[ rightEnd ] = tmpArray[ rightEnd ];
    }

	// ********************************************
	// Custom quicksort (different from textbook)
	// ********************************************
	static void quicksort(Integer[] a) {
		quicksort(a, 0, a.length - 1);
	}

	static void quicksort(Integer[] a, int left, int right) {
		if (left < right) {
			int pivotIndex = partition(a, left, right);
			printArray(a, left, pivotIndex);
			printArray(a, pivotIndex+1, right);
			quicksort(a, left, pivotIndex);
			quicksort(a, pivotIndex + 1, right);
		}
	}

    static void swap(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

	static int partition(Integer[] a, int left, int right) {
		Integer pivotValue = a[left];
		int i = left; // index going from left to right
		int j = right; // index going from right to left
		while (i < j) {
			/**
			* In each iteration, we will identify a number from left side which
			* is greater then the pivot value, and also we will identify a number
			* from right side which is less then the pivot value. Once the search
			* is done, then we exchange both numbers.
			*/
			while (i < a.length && a[i] >= pivotValue)
				i++;
			while (a[j] < pivotValue)
				j--;
			if (i < j)
				swap(a, i, j);
		}
		swap(a, left, j);
		return j; // a[j] = end of left array
	}

    public static void main( String [ ] args )
    {
		Integer[] a = {4, 2, 9, 3, 1, 5, 8, 7, 6, 0};
		System.out.print("After buildHeap: ");
		Sort.printArray(a, 0, a.length - 1);
		Sort.heapsort(a);
		//System.out.print("After heapsort: ");
		//Sort.printArray(a, 0, a.length - 1);

		Integer[] b = {1,2,3,4,5,6,7,8,9};
		System.out.println("MergeSort");
		System.out.print("Before Merge Sort: ");
		Sort.printArray(b, 0, b.length - 1);
		//Sort.printArray(b, 0, b.length - 1);
		//System.out.print("After mergesort: ");
		Sort.mergeSort(b);
		//Sort.printArray(b, 0, b.length - 1);

		Integer[] c = {2,3,5,1,6};
		System.out.println("Quick Sort");
		System.out.println("Before Quick Sort: ");
		Sort.printArray(c, 0, c.length - 1);
		Sort.quicksort(c);
		System.out.print("After quicksort: ");
		Sort.printArray(c, 0, c.length - 1);
    }
}

