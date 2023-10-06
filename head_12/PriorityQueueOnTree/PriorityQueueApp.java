package Lafore.head_12.PriorityQueueOnTree;

import java.io.IOException;

public class PriorityQueueApp {

    public static void main(String[] args) throws IOException
    {
        PriorityQueue thePQ = new PriorityQueue();

        thePQ.insert(70);
        thePQ.insert(100);
        thePQ.insert(10);
        thePQ.insert(80);
        thePQ.insert(0);
        thePQ.insert(200);
        thePQ.insert(5);
        thePQ.insert(40);
        System.out.println("Top: " + thePQ.peekMax());

        thePQ.remove();
        thePQ.remove();
        thePQ.remove();

        thePQ.insert(90);
        thePQ.insert(30);
        thePQ.insert(60);
        System.out.println("Top: " + thePQ.peekMax());
        thePQ.remove();
        System.out.println("Top: " + thePQ.peekMax());

        thePQ.insert(50);
        System.out.println("Top: " + thePQ.peekMax());

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }

    }
}
