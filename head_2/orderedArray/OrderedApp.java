package Lafore.head_2.orderedArray;
import java.util.Random;

class OrderedApp
{
    public static void main(String[] args)
    {
        int maxSize = 100; // Размер массива
        int nElems_1, nElems_2;
        Random random = new Random();

        nElems_1 = random.nextInt(10);
        nElems_2 = random.nextInt(10);

        OrdArray arr; // Ссылка на массив
        arr = new OrdArray(maxSize); // Создание массива
        for (int i=0; i<nElems_1; i++)
            arr.insert(random.nextInt(100));

        arr.display(); // Вывод содержимого

        OrdArray arr_2; // Ссылка на массив
        arr_2 = new OrdArray(maxSize); // Создание массива
        for (int i=0; i<nElems_2; i++)
            arr_2.insert(random.nextInt(100));

        arr_2.display();

        OrdArray arr_merged = new OrdArray(maxSize); // Создание массива

        arr_merged = arr_merged.merge(arr, arr_2);

        arr_merged.noDups(arr_merged);
        arr_merged.display();

    }
}

