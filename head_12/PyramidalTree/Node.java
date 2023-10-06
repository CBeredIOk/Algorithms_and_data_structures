package Lafore.head_12.PyramidalTree;
class Node
{
    public int iData; // Данные, используемые в качестве ключа

    public Node parent; // Родитель узла

    public Node leftChild; // Левый потомок узла

    public Node rightChild; // Правый потомок узла

    public void displayNode() // Вывод узла
    {
        System.out.print("[");
        System.out.print(iData);
        System.out.print("] ");
    }
}
