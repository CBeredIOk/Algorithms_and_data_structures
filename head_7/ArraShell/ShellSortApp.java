package Lafore.head_7.ArraShell;

class ShellSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10; // Размер массива
        ArrayShell arr;
        arr = new ArrayShell(maxSize); // Создание массива
        for(int j=0; j<maxSize; j++) // Заполнение массива
        {                            // случайными числами
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display(); // Вывод несортированного массива
        arr.shellSort(); // Сортировка массива по алгоритму Шелла
        arr.display(); // Вывод отсортированного массива
    }
}
