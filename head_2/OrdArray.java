package Lafore.head_2;

// orderedArray.java
// Работа с классом упорядоченного массива
// Запуск программы: C>java OrderedApp

class OrdArray
{
    private int[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public OrdArray(int max) // Конструктор
    {
        a = new int[max]; // Создание массива
        nElems = 0;
    }
    public int size() {
        return nElems;
    }
    public int find(int searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems-1;

        int middle;
        while(true)
        {
            middle = (lowerBound + upperBound ) / 2;
            if(a[middle]==searchKey) {
                return middle; // Элемент найден
            }
            else if(lowerBound > upperBound) {
                return nElems; // Элемент не найден
            }
            else // Деление диапазона
            {
                if(a[middle] < searchKey)
                    lowerBound = middle + 1; // В верхней половине
                else
                    upperBound = middle - 1; // В нижней половине
            }
        }
    }
    public void insert(int value) // Вставка элемента в массив
    {
        int lowerBound = 0;
        int upperBound = nElems-1;

        int middle;

        while(true)
        {
            middle = (lowerBound + upperBound ) / 2;
            if(lowerBound > upperBound) {
                break;
            }
            else // Деление диапазона
            {
                if(a[middle] < value)
                    lowerBound = middle + 1; // В верхней половине
                else
                    upperBound = middle - 1; // В нижней половине
            }
        }
        for(int k = nElems; k > lowerBound; k--) // Перемещение последующих элементов
            a[k] = a[k-1];
        a[lowerBound] = value; // Вставка
        nElems++;
    }

    public boolean delete(int value)
    {
        int j = find(value);
        if(j==nElems) // Найти не удалось
            return false;
        else // Элемент найден
        {
            for(int k=j; k<nElems; k++) // Перемещение последующих элементов
                a[k] = a[k+1];
            nElems--; // Уменьшение размера
            return true;
        }
    }
    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) { // Перебор всех элементов
            System.out.print(a[j] + " "); // Вывод текущего элемента
        }
        System.out.println(" ");
    }

    public OrdArray merge(OrdArray arr_1, OrdArray arr_2 ){
        OrdArray arr_merged = new OrdArray(100);
        int nElems_1 = arr_1.size();
        int nElems_2 = arr_2.size();
        if(nElems_1 >= nElems_2) {
            for (int i = 0; i < nElems_2; i++) {
                arr_merged.insert(arr_2.a[i]);
            }
            for (int i = 0; i < nElems_1; i++) {
                arr_merged.insert(arr_1.a[i]);
            }
        }
        else{
            for(int i=0; i<nElems_1; i++){
                arr_merged.insert(arr_1.a[i]);
            }
            for(int i=0; i<nElems_2; i++){
                arr_merged.insert(arr_2.a[i]);
            }
        }
        arr_merged.display();
        return arr_merged;
    }

    public void noDups(OrdArray arr_merged){
        for(int i = 0; i<nElems-1; i++)
            if(a[i] == a[i+1]){
                arr_merged.delete(a[i+1]);
            }
    }
}

