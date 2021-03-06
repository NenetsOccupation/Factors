package factors;

public class Sort {
    
    public static void mergeSort(Number.number[] a) {
        Number.number[] tmpArray = new Number.number[a.length];
        mergeSort( a, tmpArray, 0, a.length - 1 );
        System.out.println("Array was sorted");
    }
    
    private static void mergeSort(Number.number[] a, Number.number[] tmpArray, int left, int right ) {
        if( left < right ) {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right );
        }
    }
    
    private static void merge(Number.number[] a, Number.number[] tmpArray,
        int leftPos, int rightPos, int rightEnd ) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while( leftPos <= leftEnd && rightPos <= rightEnd ){
            if( a[ leftPos ].numberOfFactors <= ( a[ rightPos ] ).numberOfFactors)
                tmpArray[ tmpPos++ ] = a[ leftPos++ ];
            else
                tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        }
        while( leftPos <= leftEnd )     tmpArray[ tmpPos++ ] = a[ leftPos++ ];
        while( rightPos <= rightEnd )   tmpArray[ tmpPos++ ] = a[ rightPos++ ];
        for( int i = 0; i < numElements; i++, rightEnd-- ){
            a[ rightEnd ] = tmpArray[ rightEnd ];
        }
    }
}
