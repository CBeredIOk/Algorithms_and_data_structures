package Lafore.head_12.PyramidalTree;

import java.io.IOException;

public class PriorityQueueApp {

    public static void main(String[] args) throws IOException
    {
        Tree theTree = new Tree();

        theTree.insert(70);
        theTree.insert(100);
        theTree.insert(10);
        theTree.insert(80);
        theTree.insert(0);
        theTree.insert(200);
        theTree.insert(5);
        theTree.insert(40);
        System.out.println("Top: " + theTree.peekTop());

        theTree.remove();
        theTree.remove();
        theTree.remove();

        theTree.insert(90);
        theTree.insert(30);
        theTree.insert(60);
        System.out.println("Top: " + theTree.peekTop());
        theTree.remove();
        System.out.println("Top: " + theTree.peekTop());

        theTree.insert(50);
        System.out.println("Top: " + theTree.peekTop());
        theTree.displayTree();
        theTree.change(60, 200);
        theTree.change(100, 5);
        theTree.displayTree();

        theTree.change(70, 15);
        theTree.displayTree();

        theTree.change(40, 20);
        theTree.displayTree();

        theTree.insert(150);
        theTree.insert(70);
        theTree.insert(90);
        theTree.displayTree();
    }
}
