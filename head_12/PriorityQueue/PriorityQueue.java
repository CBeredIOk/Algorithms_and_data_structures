package Lafore.head_12.PriorityQueue;

class PriorityQueue
{
    // Элементы массива сортируются по значению ключа, от максимума (0) до минимума (maxSize-1)
    private int maxSize;
    private Heap heapArray;
    private int nItems;

    public PriorityQueue(int inputSize) // Конструктор
    {
        maxSize = inputSize;
        heapArray = new Heap(maxSize);
        nItems = 0;
    }

    public void insert(int item) // Вставка элемента
    {
        heapArray.insert(item);
    }

    public int remove() // Извлечение минимального элемента
    { return heapArray.remove().getKey(); }

    public int peekMin() // Чтение минимального элемента
    { return heapArray.peekMin(); }

    public boolean isEmpty() // true, если очередь пуста
    { return heapArray.isEmpty(); }

    public boolean isFull() // true, если очередь заполнена
    { return heapArray.isFull(); }
}
