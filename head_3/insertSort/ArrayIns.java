package Lafore.head_3.insertSort;

// insertSort.java
// Сортировка методом вставки
// Запуск программы: C>java InsertSortApp
class ArrayIns
{
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArrayIns(int max) // Конструктор
    {
        a = new long[max]; // Создание массива
        nElems = 0; // Пока нет ни одного элемента
    }

    public void insert(long value) // Вставка элемента в массив
    {
        a[nElems] = value; // Собственно вставка
        nElems++; // Увеличение размера
    }

    public void display() // Вывод содержимого массива
    {
        for(int j=0; j<nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println(" ");
    }

    public void insertionSort()
    {
        int in, in_two, out;
        int copy = 0, comparison = 0;
        for(out=1; out<nElems; out++) // out - разделительный маркер
        {
            long temp = a[out]; // Скопировать помеченный элемент
            copy++;
            in = out; // Начать перемещения с out
            in_two = out;

            while(in_two>0) // Пока не найден меньший элемент
            {
                comparison++;
                while(in > 0 && a[in-1] >= temp) // Пока не найден меньший элемент
                {
                    a[in] = a[in-1]; // Сдвинуть элемент вправо
                    --in; // Перейти на одну позицию влево
                }
                in_two--;
            }

            a[in] = temp; // Вставить помеченный элемент
        }
        System.out.println("Copy: " + copy);
        System.out.println("Comparison: " + comparison);
    }

    public void insertionSortNoDubs()
    {
        int in, out, dubs = 0;
        for(out=1; out<nElems; out++) // out - разделительный маркер
        {
            long temp = a[out]; // Скопировать помеченный элемент
            System.out.println("Marker: " + temp);
            in = out; // Начать перемещения с out
            while(in>dubs && a[in-1] >= temp) // Пока не найден меньший элемент
            {
                // Перейти на одну позицию влево
                if(a[in-1] == temp){ // Если найден дубликат
                    System.out.println("a[" + (in-1) + "]=" + a[in-1] + " = " + "a[" + (out) + "]=" + temp);
                    a[in] = a[in-1]; // Сдвинуть элемент вправо
                    temp = -1; // Пометить дубликат
                }
                else{
                    System.out.println("a[" + (in-1) + "]=" + a[in-1] + " > " + "a[" + (out) + "]=" + temp);
                    a[in] = a[in-1]; // Сдвинуть элемент вправо
                }
                --in; // Перейти на одну позицию влево
            }
            if(temp == -1){
                dubs++;
                System.out.println("Duds: " + dubs);
            }
            a[in] = temp; // Вставить помеченный элемент

            for(int j=0; j<nElems; j++) // Для каждого элемента
                System.out.print(a[j] + " "); // Вывод
            System.out.println(" ");
        }
        System.out.println("Dubs: " + dubs);
        for(int i=dubs; i<nElems;i++){
            a[i-dubs]=a[i];
        }
        nElems = nElems - dubs;
    }
}
