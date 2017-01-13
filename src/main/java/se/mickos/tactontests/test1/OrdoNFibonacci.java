package se.mickos.tactontests.test1;

/**
 * Created by Lars-Erik on 2017-01-04.
 */
public class OrdoNFibonacci {
    /**
     * This is a loop based implementation supporting positive and negative values of n
     * @param n The sequence number. Only supported for positive numbers
     * @return The calculated number
     * @throws IllegalArgumentException for n values above 92 and below
     */
    static public long fibonacciOrdoN(long n) {
        if (n>92) throw new IllegalArgumentException("Values of n above 92 is not supported due to overflow in the long result value. n="+n);
        if (n<-92) throw new IllegalArgumentException("Values of n below -92 is not supported due to lack of math precision. n="+n);
        if (n<0) return ((-n)%2==1?1:-1)*fibonacciOrdoNInternal(-n);
        else return fibonacciOrdoNInternal(n);
    }

    /**
     * This is the internal (friendly to enable unit tests) loop based implementation supporting only positive values of n
     * @param n The sequence number. Only supported for positive numbers
     * @return The calculated number
     */
    static long fibonacciOrdoNInternal(long n){
        long last = 0,beforeLast=1, result=0;
        for(int i=0;i<n;i++){
            result=last+beforeLast;
            beforeLast=last;
            last=result;
        }
        return result;
    }
}
