package Lafore.head_4.SuperMarket;

public class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    //--------------------------------------------------------------
    public Queue(int s) // Конструктор
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //--------------------------------------------------------------
    public void insert(long j) // Вставка элемента в конец очереди
    {
        if(isFull())
        {
            System.out.println("ERROR. The Queue is Full");
        }
        else
        {
            if (rear == maxSize - 1) // Циклический перенос
                rear = -1;
            queArray[++rear] = j; // Увеличение rear и вставка
            nItems++; // Увеличение количества элементов
        }
    }

    //--------------------------------------------------------------
    public void remove() // Извлечение элемента в начале очереди
    {
        if(isEmpty())
        {
            System.out.println("ERROR. The Queue is empty");
        }
        else
        {
            long temp = queArray[front]; // Выборка и увеличение front
            System.out.println("Removed: " + temp + " (" + front + ")");

            front++;
            if (front == maxSize) // Циклический перенос
                front = 0;
            nItems--; // Уменьшение количества элементов
        }
    }

    //--------------------------------------------------------------
    public long peekFront() // Чтение элемента в начале очереди
    {
        return queArray[front];
    }

    //--------------------------------------------------------------
    public int peekIndexFront() // Чтение элемента в начале очереди
    {
        return front;
    }

    //--------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems == 0);
    }

    //--------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    {
        return (nItems == maxSize);
    }

    //--------------------------------------------------------------
    public int size() // Количество элементов в очереди
    {
        return nItems;
    }

    //--------------------------------------------------------------

    public void output()
    {
        int nItemsTemp = nItems;
        int frontTemp = front;

        while( !isEmpty() ) // Извлечение и вывод всех элементов
        {
            int i = peekIndexFront();
            long n = peekFront();
            if (front == maxSize-1) // Циклический перенос
                front = 0;
            else front++;

            System.out.print(n + " (" + i + ") ");
            nItems--;

        }
        nItems = nItemsTemp;
        front = frontTemp;

        System.out.println(" ");
    }
}
