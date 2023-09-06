package Lafore.head_3.bubbleSort;

// bubbleSort.java
// Пузырьковая сортировка
// Запуск программы: C>java BubbleSortApp
class ArrayBub {
    private long[] a; // Ссылка на массив a
    private int nElems; // Количество элементов данных

    public ArrayBub(int max) // Конструктор
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
        for (int j = 0; j < nElems; j++) // Для каждого элемента
            System.out.print(a[j] + " "); // Вывод
        System.out.println(" ");
    }

    public void bubbleSort() {
        int out_right, in, out_left = 1;
        for (out_right = nElems - 1; out_right > out_left; out_right--) { // Внешний цикл (обратный)
            for (in = out_left - 1; in < out_right; in++) { // Внутренний цикл (прямой)
                if (a[in] > a[in + 1]) // Порядок нарушен?
                    swap(in, in + 1); // Поменять местами
            }

            for (in = out_right - 1; in > out_left - 1; in--) { // Внутренний цикл (прямой)
                if (a[in] < a[in - 1]) // Порядок нарушен?
                    swap(in, in - 1); // Поменять местами
            }
            out_left++;
        }
    }

    public void oddEvenSort(){
        int count = 0;
        while(count < nElems - 1) {
            count = 0;
            for (int i = 0; i < nElems - 1; i = i + 2) { // odd
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                }
                else{
                    count++;
                }
            }
            for (int i = 1; i < nElems - 1; i = i + 2) { // even
                if (a[i] > a[i + 1]) {
                    swap(i, i + 1);
                }
                else {
                    count++;
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void median(){
        float median;
        if(nElems % 2 == 0) {
            median = (float) (a[(nElems / 2 - 1)] + a[nElems / 2]) /2;
        }
        else median = a[nElems/2];
        System.out.println("median is: " + median);
    }

    public void noDubs(){
        int j = 0;
        for (int i = nElems; i >= 2; i--){
            if (a[i] == a[i-1]){
                j++;
                if (a[i-1] != a[i-2]){
                    for (int k = i; k < nElems - j; k++){
                        a[k] = a[k + j];
                    }
                    nElems = nElems - j;
                    j = 0;
                }
            }

            if (i==2 && a[i-1] == a[i-2]){
                j++;
                for (int k = 1; k < nElems - j; k++){
                    a[k] = a[k + j];
                }
                nElems = nElems - j;
                j = 0;
            }
        }
    }
}
