package Lafore.head_7.PartitionApp;

class ArrayPar
{
    private long[] theArray; // Ссылка на массив
    private int nElems; // Количество элементов
    //--------------------------------------------------------------
    public ArrayPar(int max) // Конструктор
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
    public int size(){ // Получение количества элементов
        return nElems;
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
    public long pivotIs(int right){
        return theArray[right];
    }

    public int manualSort(int left, int right)
    {
        int rightPtr = right;

        int size = right-left+1;
        if(size <= 1)
            return rightPtr; // Сортировка не требуется
        if(size == 2)
        { // 2-сортировка left и right
            if( theArray[left] > theArray[right] ) {
                swap(left, right);
                rightPtr--;
            }
            return rightPtr;
        }
        else // Размер равен 3
        { // 3-сортировка left, center и right
            if( theArray[left] > theArray[right-1] ) {
                swap(left, right - 1); // left, center
            }
            if( theArray[left] > theArray[right] ) {
                swap(left, right); // left, right
                rightPtr -= 2;
            }
            if( theArray[right-1] > theArray[right] ) {
                swap(right - 1, right); // center, right
                rightPtr -= 1;
            }
            return rightPtr;
        }
    }
    public int partitionIt(int left, int right, long pivot)
    {
        int leftPtr = left - 1; // Справа от первого элемента
        int rightPtr = right; // Слева от опорного элемента
        if(theArray.length <= 3) {
            leftPtr = manualSort(left, right);
            return leftPtr;
        }
        else {
            while (true) {
                while (leftPtr < right && theArray[++leftPtr] < pivot)// Поиск большего элемента
                    ; // (пустое тело цикла)

                while (rightPtr > left && theArray[--rightPtr] > pivot)// Поиск меньшего элемента
                    ; // (пустое тело цикла)
                if (leftPtr >= rightPtr) // Если указатели сошлись,
                    break; // разбиение закончено
                else // В противном случае
                    swap(leftPtr, rightPtr); // поменять элементы местами
            }
            swap(theArray.length - 1, rightPtr + 1);
            return leftPtr; // Позиция разбиения
        }
    }
    //--------------------------------------------------------------
    public void swap(int dex1, int dex2) // Перестановка двух элементов
    {
        long temp;
        temp = theArray[dex1]; // A копируется в temp
        theArray[dex1] = theArray[dex2]; // B копируется в A
        theArray[dex2] = temp; // temp копируется в B
    }
//--------------------------------------------------------------
}
