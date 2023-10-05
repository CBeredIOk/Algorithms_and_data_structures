package Lafore.head_12.PriorityQueue;

import java.io.*;

public class PriorityQueueApp {

    public static void main(String[] args) throws IOException
    {
        PriorityQueue thePQ = new PriorityQueue(31);

        thePQ.insert(70);
        thePQ.insert(40);
        thePQ.insert(50);
        thePQ.insert(20);
        thePQ.insert(60);
        thePQ.insert(100);
        thePQ.insert(80);
        thePQ.insert(30);
        thePQ.insert(10);
        thePQ.insert(90);
        thePQ.insert(5);
        thePQ.insert(45);
        thePQ.insert(15);

        while( !thePQ.isEmpty() )
        {
            long item = thePQ.remove();
            System.out.print(item + " ");
        }
        System.out.println(" ");
    }
}
