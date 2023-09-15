package Lafore.head_7.IndexFindElement;

class FindElementApp {
    public static void main(String[] args) {
        int maxSize = 9; // Размер массива

        ArrayMedian arr; // Ссылка на массив
        arr = new ArrayMedian(maxSize); // Создание массива

        for (int j = 0; j < maxSize; j++) // Заполнение массива случайными числами
        {
            long n = (int) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display(); // Вывод массива до разбиения

        int elementIndex = 2; // Индекс нужного элемента

        int partDex = arr.findElementIndex(0, maxSize - 1, elementIndex); // Нахождение элемента
        System.out.print("Element at index " + partDex);
        System.out.println(" is " + arr.pivotIs(partDex));

        arr.display(); // Вывод массива после разбиения
    }
}
