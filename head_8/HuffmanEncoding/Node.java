package Lafore.head_8.HuffmanEncoding;

class Node
{
    public char chData;
    public int iData;
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла
    public void displayNode(){
        System.out.print("(" + chData + ")" + "[" + iData + "] ");
    }
}
