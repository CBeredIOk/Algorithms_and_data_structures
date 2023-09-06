package Lafore.head_3.insertSort;

import java.util.Random;

public class InsertSortApp {
        public static void main(String[] args)
        {
            int maxSize = 100; // Размер массива
            ArrayIns arr; // Ссылка на массив
            arr = new ArrayIns(maxSize); // Создание массива

            Random random = new Random();
            int randomNum = random.nextInt(20);
            System.out.println("nElems: " + randomNum);

            for(int i = 0; i < randomNum; i++){
                arr.insert(random.nextInt(11));
            }

//            arr.insert(77); // Вставка 10 элементов
//            arr.insert(99);
//            arr.insert(44);
//            arr.insert(55);
//            arr.insert(66);
//            arr.insert(22);
//            arr.insert(99);
//            arr.insert(99);
//            arr.insert(99);
//            arr.insert(11);
//            arr.insert(88);
//            arr.insert(11);
//            arr.insert(0);
//            arr.insert(66);
//            arr.insert(66);
//            arr.insert(0);
//            arr.insert(0);
//            arr.insert(33);

            arr.display(); // Вывод элементов

            arr.insertionSortNoDubs(); // Сортировка методом вставки

            arr.display(); // Повторный вывод

        }
    }

