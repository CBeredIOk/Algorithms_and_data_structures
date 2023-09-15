package Lafore.head_7.IndexFindElement;

class ArrayMedian
{
    private long[] theArray; // Ссылка на массив
    private int nElems; // Количество элементов
    private long pivotLast;
    //--------------------------------------------------------------
    public ArrayMedian(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента

        pivotLast = -1;
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
        for(int j = 0; j < nElems; j++) // Для каждого элемента
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

        if(right - left + 1 <= 3) {
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
            swap(right, leftPtr);
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
    public int findMedian(int left, int right){
        long pivot = theArray[right];
        return recFindMedian(left, right, pivot);
    }

    public int recFindMedian(int left, int right, long pivot){
        pivotLast = pivot;

        int partDex = partitionIt(left, right, pivot);

        if (partDex == nElems/2) {
            return partDex;
        }

        if(partDex < nElems/2){ // Выбираем правую часть
            pivot = theArray[right];

            if(pivot == pivotLast){
                pivot = theArray[right - 1];
            }
            partDex = recFindMedian(partDex + 1, right, pivot);
        } else { // Выбираем левую часть
            pivot = theArray[partDex];

            if(pivot == pivotLast){
                partDex = partDex - 1;
                pivot = theArray[partDex];
            }
            partDex = recFindMedian(left, partDex, pivot);
        }
        return partDex;
    }

    public int findElementIndex(int left, int right, int index){
        long pivot = theArray[right];
        return recFindElement(left, right, pivot, index);
    }

    public int recFindElement(int left, int right, long pivot, int neededIndex){
        pivotLast = pivot;

        int partDex = partitionIt(left, right, pivot);

        if (partDex == neededIndex) {
            return partDex;
        }

        if(partDex < neededIndex){ // Выбираем правую часть
            pivot = theArray[right];

            if(pivot == pivotLast){
                pivot = theArray[right - 1];
            }
            partDex = recFindElement(partDex + 1, right, pivot, neededIndex);
        } else { // Выбираем левую часть
            pivot = theArray[partDex];

            if(pivot == pivotLast){
                partDex = partDex - 1;
                pivot = theArray[partDex];
            }
            partDex = recFindElement(left, partDex, pivot, neededIndex);
        }
        return partDex;
    }
}
