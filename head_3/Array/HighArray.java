package Lafore.head_3.Array;
public class HighArray {
// highArray.java
// Класс массива с высокоуровневым интерфейсом
// Запуск программы: C>java HighArrayApp
        private long[] a; // Ссылка на массив a
        private int nElems;
        private long maxElem; // Количество элементов в массиве

        public HighArray(int max) // Конструктор
        {
            a = new long[max]; // Создание массива
            nElems = 0; // Пока нет ни одного элемента
        }
        public boolean find(long searchKey)
        { // Поиск заданного значения
            int j;
            for(j=0; j<nElems; j++) // Для каждого элемента
                if(a[j] == searchKey) // Значение найдено?
                    break; // Да - выход из цикла
            if(j == nElems) // Достигнут последний элемент?
                return false; // Да
            else
                return true; // Нет
        }
        //-----------------------------------------------------------
        public void insert(long value) // Вставка элемента в массив
        {
            a[nElems] = value; // Собственно вставка
            nElems++; // Увеличение размера
        }
        //-----------------------------------------------------------
        public boolean delete(long value)
        {
            int j;
            for(j=0; j<nElems; j++) // Поиск заданного значения
                if( value == a[j] )
                    break;
            if(j==nElems) // Найти не удалось
                return false;
            else // Значение найдено
            {
                for(int k=j; k<nElems; k++) // Сдвиг последующих элементов
                    a[k] = a[k+1];
                nElems--; // Уменьшение размера
                return true;
            }
        }
        public void display() // Вывод содержимого массива
        {
            for(int j=0; j<nElems; j++) // Для каждого элемента
                System.out.print(a[j] + " "); // Вывод
            System.out.println(" ");
        }

        public void getMax() // Вывод содержимого массива
        {
            maxElem = a[0];
            for(int j=1; j<nElems; j++) { // Для каждого элемента
                if (maxElem < a[j])
                    maxElem = a[j];
            }
            System.out.println("Max Element: " + maxElem);
        }

    public long removeMax() // Вывод содержимого массива
    {
        int j;
        int n = 0;
        maxElem = a[0];
        for(j = 1; j < nElems; j++) { // Для каждого элемента
            if (maxElem < a[j]) {
                maxElem = a[j];
                n = j;
            }
        }
        for(int k = n; k < nElems; k++) // Сдвиг последующих элементов
            a[k] = a[k+1];
        nElems--; // Уменьшение размера
        System.out.println("Max Element: " + maxElem);
        return maxElem;
    }

    public long nElemGet(){
        return nElems;
    }

    }