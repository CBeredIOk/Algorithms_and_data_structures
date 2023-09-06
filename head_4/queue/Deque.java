package Lafore.head_4.queue;

public class Deque {

    private int maxSize;
    private long[] theDeque;
    private int front;
    private int rear;
    private int nItems;

    public Deque(int s){
        maxSize = s;
        theDeque = new long[maxSize];
        front = 0;
        rear = 0;
        nItems = 0;
    }
    public void insertLeft(int insert){
        if(isFull()) {
            System.out.println("ERROR/ Deque is full/");
        }
        else{
            theDeque[rear] = insert;
            rear++;
            if (rear == maxSize) {
                rear = 0;
            }
            nItems++;
        }
//        System.out.println("Front is: " + front + " Rear is: " + rear);
    }

    public void insertRight(int insert){
        if(isFull()) {
            System.out.println("ERROR/ Deque is full/");
        }
        else {
            front--;
            if (front == -1){
                front = maxSize - 1;
            }
            theDeque[front] = insert;
            nItems++;
        }
//        System.out.println("Front is: " + front + " Rear is: " + rear);
    }

    public void removeLeft(){
        if(isEmpty()) {
            System.out.println("ERROR/ Deque is empty/");
        }
        else {
            front++;
            if (front == maxSize){
                front = 0;
            }
            nItems--;
        }
    }

    public void removeRight(){
        if(isEmpty()) {
            System.out.println("ERROR/ Deque is empty/");
        }
        else{
            rear--;
            if (rear == -1) {
                rear = maxSize - 1;
            }
            nItems--;
        }
    }

    public boolean isFull(){
        return nItems == maxSize;
    }

    public boolean isEmpty(){
        return nItems == 0;
    }

    public long Front(){
        long top = theDeque[front];
        return top;
    }

    public long Rear(){
        long bottom = theDeque[(rear-1)];
        return bottom;
    }

    public void output()
    {
        int nItemsTemp = nItems;
        int frontTemp = front;

        while( !isEmpty() ) // Извлечение и вывод всех элементов
        {
//            System.out.println("Front start: " + front);
            long theDequeTemp = theDeque[front];
            int frontPrint = front;

            if (front == maxSize-1) // Циклический перенос
                front = 0;
            else front++;

            System.out.print(theDequeTemp + " (" + frontPrint + ") ");

            nItems--;
//            System.out.println("Front end: " + front);
        }
        System.out.println(" ");

        nItems = nItemsTemp;
        front = frontTemp;
    }
}

