package Lafore.head_12.PriorityQueueOnTree;

class PriorityQueue
{
    private Tree theTree;

    public PriorityQueue() // Конструктор
    {
        theTree = new Tree();
    }

    public void display() // Вставка элемента
    {
        theTree.displayTree();
    }

    public void insert(int item) // Вставка элемента
    {
        theTree.insert(item);
    }

    public int remove(){ // Извлечение минимального элемента
        return theTree.remove();
    }

    public int peekMax(){ // Чтение минимального элемента
        return theTree.peekTop();
    }

    public boolean isEmpty() // true, если очередь пуста
    { return theTree.isEmpty(); }
}
