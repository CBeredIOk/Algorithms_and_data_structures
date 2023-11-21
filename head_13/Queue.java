package Lafore.head_13;

class Queue
{
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public Queue() // Конструктор
    {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) // Вставка элемента в конец очереди
    {
        if(rear == SIZE-1)
            rear = -1;
        queArray[++rear] = j;
    }

    public int remove() // Извлечение элемента в начале очереди
    {
        int temp = queArray[front++];
        if(front == SIZE)
            front = 0;
        return temp;
    }

    public boolean isEmpty() // true, если очередь пуста
    {
        return ( rear+1==front || (front+SIZE-1==rear) );
    }
}
