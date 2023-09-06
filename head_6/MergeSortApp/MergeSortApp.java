package Lafore.head_6.MergeSortApp;

class MergeSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 100; // Размер массива
        DArray arr; // Ссылка на массив
        arr = new DArray(maxSize); // Создание массива
        arr.insert(64); // Вставка элементов
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);
        arr.display(); // Вывод содержимого массива
        arr.mergeSort(); // Сортировка слиянием
        arr.display(); // Повторный вывод
    }
}
