package Lafore.head_7.ShellSortApp;

class ShellSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10; // Размер массива

        ArraySh arr;
        arr = new ArraySh(maxSize); // Создание массива

        for(int j = 0; j < maxSize; j++) // Заполнение массива
        { // случайными числами
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }

        arr.display();
        arr.shellSort(); // Сортировка массива по алгоритму Шелла
        arr.display(); // Вывод отсортированного массива
    }
}
