package Lafore.head_8.Postfix;

class Node
{
    public char iData;
    public Node leftChild; // Левый потомок узла
    public Node rightChild; // Правый потомок узла
    Node(char input){

    }
    Node(){

    }

    public void displayNode() // Вывод узла
    {
        System.out.print(iData);
    }
} // Конец класса Node
