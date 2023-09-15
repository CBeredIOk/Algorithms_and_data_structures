package Lafore.head_7.RadixSort;
import java.util.Arrays;

public class ArrayRadix {
    private int nElems;
    private long[] theArray;
    public ArrayRadix(int size){
        theArray = new long[size];
        nElems = 0;
    }

    public void insert(long value){
        theArray[nElems] = value;
        nElems++;
    }

    public int size(){
        return nElems;
    }

    public void display(long[] anArray, int size){
        System.out.print("S = ");
        for ( int i = 0; i < size; i++){
            System.out.print(anArray[i] + " ");
        }
        System.out.println(" ");
    }

    public void display(int[] anArray, int size){
        System.out.print("S = ");
        for ( int i = 0; i < size; i++){
            System.out.print(anArray[i] + " ");
        }
        System.out.println(" ");
    }

    public void display(){
        System.out.print("A = ");
        for ( int i = 0; i < nElems; i++){
            System.out.print(theArray[i] + " ");
        }
        System.out.println(" ");
    }

    public int FindMaxOrder(){
        // Find max element
        long maxElem = -1;
        for (int i = 0; i < nElems; i++){
            if (theArray[i] > maxElem) {
                maxElem = theArray[i];
            }
        }

        // Recognize the digit capacity of a max element
        int maxOrder = 0;
        while (maxElem != 0){
            maxElem = maxElem / 10;
            maxOrder++;
        }

        return maxOrder;
    }

    public void RadixSort(){

        // Initialize arrays
        long[] supportArray = new long[nElems];
        int[] countDigit = new int[10];

        int maxOrder = FindMaxOrder();
        int order = 0;

        while (order++ < maxOrder) {

            int powTen = (int) Math.pow(10, order);
            Arrays.fill(countDigit, 0);

            for (int i = 0; i < nElems; i++) {
                countDigit[(int) (theArray[i] / powTen) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                countDigit[i] += countDigit[i - 1];
            }

            for ( int i = nElems - 1; i >= 0; i--){
                supportArray[countDigit[(int) ((theArray[i] / powTen) % 10)] - 1] = theArray[i];
                countDigit[(int) (theArray[i] / powTen) % 10]--;
            }

            for ( int i = 0; i < nElems; i++){
                theArray[i] = supportArray[i];
            }

        }

    }

}
