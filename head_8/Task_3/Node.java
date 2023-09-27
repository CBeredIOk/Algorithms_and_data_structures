package Lafore.head_8.Task_3;

class Node
{
    public char iData;
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла
    public void displayNode(){
        System.out.print("(" + iData + ") ");
    }
}
