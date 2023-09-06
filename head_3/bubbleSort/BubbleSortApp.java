package Lafore.head_3.bubbleSort;
import java.util.Random;

class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        ArrayBub arr; // Ссылка на массив
        arr = new ArrayBub(maxSize); // Создание массива

        Random random = new Random();
        int randomNum = random.nextInt(15);
        System.out.println("nElems: " + randomNum);

        for(int i = 0; i < randomNum; i++){
            arr.insert(random.nextInt(11));
        }

//        arr.insert(77); // Вставка 10 элементов
//        arr.insert(99);
////        arr.insert(66);
//        arr.insert(44);
//        arr.insert(55);
//        arr.insert(11);
////        arr.insert(66);
//        arr.insert(22);
//        arr.insert(88);
////        arr.insert(11);
////        arr.insert(11);
////        arr.insert(0);
////        arr.insert(0);
////        arr.insert(0);
//        arr.insert(0);
////        arr.insert(66);
////        arr.insert(66);
////        arr.insert(0);
////        arr.insert(69);
////        arr.insert(96);
//        arr.insert(66);
//        arr.insert(33);
////        arr.insert(99);
////        arr.insert(99);
////        arr.insert(99);

        arr.display(); // Вывод элементов

//        arr.bubbleSort(); // Пузырьковая сортировка элементов

        arr.oddEvenSort(); // четно-нечётная сортировка элементов

        arr.display(); // Повторный вывод

//        arr.median(); // Нахождение медианы
//
//        arr.noDubs(); // Удаление дубликатов
//
//        arr.display(); // Повторный вывод
    }
}
