package Lafore.head_7.RadixSort;

public class RadixSortApp {
    public static void main(String[] args){

        int size = 20;
        ArrayRadix array = new ArrayRadix(size);

        for (int i = 0; i < size; i++){
            long random_number = (int) (Math.random() * 999);
            array.insert(random_number);
        }

        array.display();
        array.RadixSort();
        array.display();
    }
}
