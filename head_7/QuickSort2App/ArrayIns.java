package Lafore.head_7.QuickSort2App;

class ArrayIns
{
    private long[] theArray; // Ссылка на массив
    private int nElems; // Количество элементов

    private int copy;
    private int comparison;

    //--------------------------------------------------------------
    public ArrayIns(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }
    //--------------------------------------------------------------
    public void insert(long value) // Вставка элемента в массив
    {
        theArray[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }
    //--------------------------------------------------------------
    public void display() // Вывод содержимого массива
    {
        System.out.print("A = ");
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println(" ");
    }
    //--------------------------------------------------------------
    public void quickSort()
    {
        recQuickSort(0, nElems-1);
        System.out.println("comparison: " + comparison);
        System.out.println("copy: " + copy);
    }
    //--------------------------------------------------------------
    public void recQuickSort(int left, int right)
    {
        int size = right-left+1;
        if(size <= 3) // Ручная сортировка при малом размере
            manualSort(left, right);
        else // Быстрая сортировка при большом размере
        {
            long median = medianOf3(left, right);
            int partition = partitionIt(left, right, median);
            recQuickSort(left, partition-1);
            recQuickSort(partition+1, right);
        }
    }
    //--------------------------------------------------------------
    public long medianOf3(int left, int right)
    {
        int center = (left+right)/2;
        // Упорядочение left и center
        if( theArray[left] > theArray[center] )
            swap(left, center);
        // Упорядочение left и right
        if( theArray[left] > theArray[right] )
            swap(left, right);
        // Упорядочение center и right
        if( theArray[center] > theArray[right] )
            swap(center, right);

        comparison += 3;

        swap(center, right-1); // Размещение медианы на правом краю
        return theArray[right-1]; // Метод возвращает медиану
    }
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) // Перестановка двух элементов
    {
        long temp = theArray[dex1]; // A копируется в temp
        theArray[dex1] = theArray[dex2]; // B копируется в A
        theArray[dex2] = temp; // temp копируется в B

        copy += 3;
    }
    //--------------------------------------------------------------
    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left; // Справа от первого элемента
        int rightPtr = right - 1; // Слева от опорного элемента
        while(true)
        {
            while( theArray[++leftPtr] < pivot ) { // Поиск большего элемента
                comparison++; // (пустое тело цикла)
            }
            comparison++;

            while( theArray[--rightPtr] > pivot ) { // Поиск меньшего элемента
                comparison++; // (пустое тело цикла)
            }
            comparison++;

            comparison++;
            if(leftPtr >= rightPtr) // Если указатели сошлись,
                break; // разбиение закончено
            else // В противном случае
                swap(leftPtr, rightPtr); // поменять элементы местами

        }
        swap(leftPtr, right-1); // Восстановление опорного элемента
        return leftPtr; // Позиция разбиения
    }
    //--------------------------------------------------------------
    public void manualSort(int left, int right)
    {
        int size = right-left+1;
        if(size <= 1)
            return; // Сортировка не требуется
        if(size == 2)
        { // 2-сортировка left и right
            comparison++;
            if( theArray[left] > theArray[right] ) {
                swap(left, right);
            }
            return;
        }
        else // Размер равен 3
        { // 3-сортировка left, center и right
            comparison += 3;
            if( theArray[left] > theArray[right-1] )
                swap(left, right-1); // left, center
            if( theArray[left] > theArray[right] )
                swap(left, right); // left, right
            if( theArray[right-1] > theArray[right] )
                swap(right-1, right); // center, right
        }
    }
//--------------------------------------------------------------
}
