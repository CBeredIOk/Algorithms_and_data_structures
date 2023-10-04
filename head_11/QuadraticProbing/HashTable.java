package Lafore.head_11.QuadraticProbing;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;
    private int elementNumber = 0;
    private float MAX_LOAD_FACTOR = 0.5F;
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
        if(getLoadFactor() > MAX_LOAD_FACTOR){
            reHash();
        } else{
            System.out.println("arraySize: " + arraySize);
            System.out.println("hashArray length: " + hashArray.length);
            int key = item.getKey(); // Получение ключа
            int hashVal = hashFunc(key); // Хеширование ключа
            int quadStep = hashVal;
            int step = 0;
            while (hashArray[quadStep] != null && hashArray[quadStep].getKey() != -1) // Пока не найдена пустая ячейка или -1
            {
                quadStep = quadraticProbing(hashVal, ++step); // Переход к следующей ячейке
                quadStep %= arraySize; // При достижении конца таблицы происходит возврат к началу
            }
            hashArray[quadStep] = item; // Вставка элемента
            elementNumber++;
        }
    }
    private float getLoadFactor(){
        System.out.println("LoadFactor: " + (float) elementNumber/arraySize);
        return (float) elementNumber/arraySize;
    }

    public void reHash() {
        arraySize = getPrime(arraySize * 2);
        elementNumber = 0;
        DataItem[] tempArray = hashArray.clone();
        hashArray = new DataItem[arraySize];
        for (DataItem item : tempArray) {
            if (item != null && !item.equals(nonItem)) {
                System.out.println("Insert " + item.getKey());
                insert(item);
            }
        }
    }

    static int getPrime(int min) // Возвращает первое простое число > min
    {
        for(int j = min+1; true; j++) // Для всех j > min
            if( isPrime(j) ) // Число j простое?
                return j; // Да, вернуть его
    }
    static boolean isPrime(int n) // Число n простое?
    {
        for(int j=2; (j*j <= n); j++) // Для всех j
            if( n % j == 0) // Делится на j без остатка?
                return false; // Да, число не простое
        return true; // Нет, число простое
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
                elementNumber--;
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
