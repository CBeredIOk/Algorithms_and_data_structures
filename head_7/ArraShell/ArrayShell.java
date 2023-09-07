package Lafore.head_7.ArraShell;

public class ArrayShell{
        private long[] theArray; // Ссылка на массив
        private int nElems; // Количество элементов
        //--------------------------------------------------------------
        public ArrayShell(int max) // Конструктор
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
            System.out.println("");
        }
        //--------------------------------------------------------------
        public void shellSort()
        {
            int inner, outer;
            long temp;
            int h = 1; // Вычисление исходного значения h
            while(h <= nElems/3)
                h = h*3 + 1; // (1, 4, 13, 40, 121, ...)
            while(h>0) // Последовательное уменьшение h до 1
            {
                // h-сортировка файла
                for(outer=h; outer<nElems; outer++)
                {
                    temp = theArray[outer];
                    inner = outer;
                    // Первый подмассив (0, 4, 8)
                    while(inner > h-1 && theArray[inner-h] >= temp)
                    {
                        theArray[inner] = theArray[inner-h];
                        inner -= h;
                    }
                    theArray[inner] = temp;
                }
                h = (h-1) / 3; // Уменьшение h
            }
        }
    }