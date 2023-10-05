package Lafore.head_12.BasicHeap;

class Heap
{
    private Node[] heapArray;
    private int maxSize; // Размер массива
    private int currentSize; // Количество узлов в массиве
    public Heap(int mx) // Конструктор
    {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize]; // Создание массива
    }

    public boolean isEmpty()
    { return currentSize==0; }

    public boolean insert(int key)
    {
        if(currentSize==maxSize)
            return false;
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index)
    {
        int parent = (index-1) / 2;
        Node bottom = heapArray[index];
        while( index > 0 &&
                heapArray[parent].getKey() < bottom.getKey() )
        {
            heapArray[index] = heapArray[parent]; // Узел смещается вниз
            index = parent;
            parent = (parent-1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() // Удаление элемента с наибольшим ключом
    { // (Предполагается, что список не пуст)
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index)
    {
        int largerChild;
        Node top = heapArray[index]; // Сохранение корня
        while(index < currentSize/2) // Пока у узла имеется
        { // хотя бы один потомок
            int leftChild = 2*index+1;
            int rightChild = leftChild+1;
            // Определение большего потомка
            if(rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild; // (Правый потомок существует?)
            else {
                largerChild = leftChild;
            }
            // top >= largerChild?
            if( top.getKey() >= heapArray[largerChild].getKey() )
                break;
            // Потомок сдвигается вверх
            heapArray[index] = heapArray[largerChild];
            index = largerChild; // Переход вниз
        }
        heapArray[index] = top; // index <- корень
    }

    public boolean change(int index, int newValue)
    {
        if(index<0 || index>=currentSize)
            return false;
        int oldValue = heapArray[index].getKey(); // Сохранение старого ключа
        heapArray[index].setKey(newValue); // Присваивание нового ключа
        if(oldValue < newValue) // Если узел повышается,
            trickleUp(index); // выполняется смещение вверх.
        else // Если узел понижается,
            trickleDown(index); // выполняется смещение вниз.
        return true;
    }

    public void displayHeap()
    {
        System.out.print("heapArray: "); // Формат массива
        for(int m=0; m<currentSize; m++)
            if(heapArray[m] != null)
                System.out.print( heapArray[m].getKey() + " ");
            else
                System.out.print( "-- ");
        System.out.println();
        // Формат пирамиды
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0; // Текущий элемент
        String dots = "-------------------------------";
        System.out.println(dots+dots); // Верхний пунктир
        while(currentSize > 0) // Для каждого элемента пирамиды
        {
            if(column == 0) // Первый элемент в строке?
                for(int k=0; k<nBlanks; k++) // Предшествующие пробелы
            System.out.print(' ');
            // Вывод элемента
            System.out.print(heapArray[j].getKey());
            if(++j == currentSize) // Вывод завершен?
                break;
            if(++column==itemsPerRow) // Конец строки?
            {
                nBlanks /= 2; // Половина пробелов
                itemsPerRow *= 2; // Вдвое больше элементов
                column = 0; // Начать заново
                System.out.println(); // Переход на новую строку
            }
            else // Следующий элемент в строке
                for(int k=0; k<nBlanks*2-2; k++)
                    System.out.print(' '); // Внутренние пробелы
        }
        System.out.println("\n"+dots+dots); // Нижний пунктир
    }
}
