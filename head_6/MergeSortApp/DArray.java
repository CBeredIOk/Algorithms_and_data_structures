package Lafore.head_6.MergeSortApp;

class DArray
{
    private long[] theArray; // Ссылка на массив theArray
    private int nElems; // Количество элементов данных

    public DArray(int max) // Конструктор
    {
        theArray = new long[max]; // Создание массива
        nElems = 0;
    }

    public void insert(long value) // Занесение элемента в массив
    {
        theArray[nElems] = value; // Вставка элемента
        nElems++; // Увеличение размера
    }

    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(theArray[j] + " "); // Вывод
        System.out.println(" ");
    }

    public void mergeSort() // Вызывается из main()
    { // Рабочая область
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems-1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound,
                              int upperBound)
    {
        if(lowerBound == upperBound) // Если только один элемент,
            return; // сортировка не требуется.
        else
        { // Поиск середины
            int mid = (lowerBound+upperBound) / 2;
            // Сортировка нижней половины
            recMergeSort(workSpace, lowerBound, mid);
            // Сортировка верхней половины
            recMergeSort(workSpace, mid+1, upperBound);
            // Слияние
            merge(workSpace, lowerBound, mid+1, upperBound);
        }
    }

    private void merge(long[] workSpace, int lowPtr,
                       int highPtr, int upperBound)
    {
        int j = 0; // Индекс в рабочей области
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1; // Количество элементов
        while(lowPtr <= mid && highPtr <= upperBound)
            if( theArray[lowPtr] < theArray[highPtr] )
                workSpace[j++] = theArray[lowPtr++];
            else
        workSpace[j++] = theArray[highPtr++];
        while(lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while(highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for(j=0; j<n; j++)
            theArray[lowerBound+j] = workSpace[j];
    }
}