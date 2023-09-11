package Lafore.head_7.FindMedianApp;

class MedianFindApp {
    public static void main(String[] args) {
        int maxSize = 9; // Размер массива

        ArrayMedian arr; // Ссылка на массив
        arr = new ArrayMedian(maxSize); // Создание массива

        for (int j = 0; j < maxSize; j++) // Заполнение массива случайными числами
        {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display(); // Вывод несортированного массива

        int partDex = arr.findMedian(0, maxSize - 1); // Нахождение медианы
        System.out.print("Partition is at index " + partDex);
        System.out.println(", it's " + arr.pivotIs(partDex));

        arr.display(); // Вывод массива после разбиения
    }
}
