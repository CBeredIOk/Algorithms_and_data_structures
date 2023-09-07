package Lafore.head_7.PartitionApp;

class PartitionApp {
    public static void main(String[] args) {
        int maxSize = 16; // Размер массива

        ArrayPar arr; // Ссылка на массив
        arr = new ArrayPar(maxSize); // Создание массива

        for (int j = 0; j < maxSize; j++) // Заполнение массива
        { // случайными числами
            long n = (int) (java.lang.Math.random() * 199);
            arr.insert(n);
        }

        arr.display(); // Вывод несортированного массива

        long pivot = arr.pivotIs(arr.size() - 1); // Опорное значение
        System.out.print("Pivot is " + pivot);

        int size = arr.size();
        // Разбиение массива
        int partDex = arr.partitionIt(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        arr.display(); // Вывод массива после разбиения
    }
}
