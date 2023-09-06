package Lafore.head_4.queue;

class PriorityQ {

    // Элементы массива сортируются по значению ключа,
    // от максимумa (0) до минимума (maxSize-1)

    private int maxSize;
    private long[] queArray;
    private int nItems;

    //-------------------------------------------------------------
    public PriorityQ(int s) // Конструктор
    {
        maxSize = s;
        queArray = new long[maxSize];
        nItems = 0;
    }

    //-------------------------------------------------------------

    public void insert(long item) // Вставка элемента
    {
        if(isFull()) {
            System.out.println("ERROR/ queArray is full/");
        }
        else {
            queArray[nItems++] = item;
            System.out.println("nItems: " + nItems);
        }
    }

    //-------------------------------------------------------------
    public long remove() // Извлечение минимального элемента
    {
        if(isEmpty()) {
            System.out.println("ERROR/ Deque is empty/");
            return 0;
        }
        else  { // Если очередь содержит элементы
            int j;
            long min = queArray[nItems-1];
            long temp;

            for (j = nItems - 1; j >= 0; j--) // Перебор в обратном направлении
            {
                if(queArray[j] < min){
                    temp = min;
                    min = queArray[j];
                    queArray[j] = temp;
                }
            }

            nItems--;
            System.out.println("nItems: " + nItems);
            return min;
        }
    }

    //-------------------------------------------------------------
    public long peekMin() // Чтение минимального элемента
    {
        return queArray[nItems - 1];
    }

    //-------------------------------------------------------------
    public boolean isEmpty() // true, если очередь пуста
    {
        return (nItems == 0);
    }

    //-------------------------------------------------------------
    public boolean isFull() // true, если очередь заполнена
    {
        return (nItems == maxSize);
    }

    public void output()
    {
        int nItemsTemp = nItems;
        int i = 0;

        while( !isEmpty() ) // Извлечение и вывод всех элементов
        {
            System.out.print(queArray[i] + " (" + i + ") ");
            nItems--;
            i++;
        }
        System.out.println(" ");

        nItems = nItemsTemp;
    }
}
