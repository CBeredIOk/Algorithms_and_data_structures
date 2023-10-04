package Lafore.head_11.QuadraticProbing;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;
    public HashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // Ключ удаленного элемента -1
    }
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            if(hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println(" ");
    }

    public int hashFunc(int key)
    {
        return key % arraySize; // Хеш-функция
    }

    public int quadraticProbing(int hashVal, int quadStep)
    {
        return (hashVal + (int) Math.pow(quadStep, 2)); // Хеш-функция
    }

    public void insert(DataItem item) // Вставка элемента данных
    // (Метод предполагает, что таблица не заполнена)
    {
        int key = item.getKey(); // Получение ключа
        System.out.println("\tInserting " + key);
        int hashVal = hashFunc(key); // Хеширование ключа
        int quadStep = hashVal;
        int step = 0;
        System.out.println("hashVal: " + hashVal);
        while(hashArray[quadStep] != null && hashArray[quadStep].getKey() != -1) // Пока не найдена пустая ячейка или -1
        {
            System.out.println("quadStep: " + quadStep);
            System.out.println("step: " + step);
            quadStep = quadraticProbing(hashVal, ++step); // Переход к следующей ячейке
            System.out.println("quadStep: " + quadStep);
            System.out.println("step: " + step);
            quadStep %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        hashArray[quadStep] = item; // Вставка элемента
        System.out.println("insert " + item.getKey() + " in [" + quadStep + "] ");
    }

    public DataItem delete(int key) // Удаление элемента данных
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        int quadStep = hashVal;
        int step = 0;
        while(hashArray[quadStep] != null) // Пока не будет найдена пустая ячейка
        {
            if(hashArray[quadStep].getKey() == key) // Ключ найден?
            {
                DataItem temp = hashArray[quadStep]; // Временное сохранение
                hashArray[quadStep] = nonItem; // Удаление элемента
                return temp; // Метод возвращает элемент
            }
            quadStep = quadraticProbing(hashVal, ++step); // Переход к следующей ячейке
            quadStep %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }

    public DataItem find(int key) // Поиск элемента с заданным ключом
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        int quadStep = hashVal;
        int step = 0;
        while(hashArray[quadStep] != null) // Пока не будет найдена пустая ячейка
        {
            if(hashArray[quadStep].getKey() == key) // Ключ найден?
                return hashArray[quadStep]; // Да, вернуть элемент
            quadStep = quadraticProbing(hashVal, ++step); // Переход к следующей ячейке
            quadStep %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }
}
