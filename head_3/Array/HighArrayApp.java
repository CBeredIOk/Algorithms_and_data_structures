package Lafore.head_3.Array;

public class HighArrayApp {

        public static void main(String[] args)
        {
            int maxSize = 100; // Размер массива

            HighArray arr; // Ссылка на массив
            arr = new HighArray(maxSize); // Создание массива

            HighArray arr_sequential; // Ссылка на массив
            arr_sequential = new HighArray(maxSize); // Создание массива

            arr.insert(77); // Вставка 10 элементов
            arr.insert(99);
            arr.insert(44);
            arr.insert(55);
            arr.insert(22);
            arr.insert(88);
            arr.insert(11);
            arr.insert(00);
            arr.insert(66);
            arr.insert(33);
            arr.display(); // Вывод элементов
            int searchKey = 35; // Поиск элемента
            if( arr.find(searchKey) )
                System.out.println("Found " + searchKey);
            else
                System.out.println("Can't find " + searchKey);

            arr.getMax();

            arr.delete(00); // Удаление трех элементов
            arr.delete(55);
            arr.delete(99);
            
            arr.display(); // Повторный вывод

            long nElems = arr.nElemGet();
            System.out.println("nElems " + nElems);

            for(int j = 0; j < nElems; j++) { // Для каждого элемента
                long maxElem = arr.removeMax();
                arr_sequential.insert(maxElem);
            }

            arr_sequential.display();
        }
    }

