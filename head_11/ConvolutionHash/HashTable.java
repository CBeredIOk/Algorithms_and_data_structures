package Lafore.head_11.ConvolutionHash;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;
    private int TEN = 10;
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
        int hashVal;
        int groupHash = 0;
        int group = numberOfGroup();
        int divider = (int)(Math.pow(TEN, group));
        while (key > 0){
            groupHash += key % divider;
            key /= divider;
        }
        hashVal = groupHash % arraySize; // Хеш-функция
        return hashVal;
    }

    public int numberOfGroup()
    {
        int tempValue = arraySize;
        for (int i = 1; true; i++){
            tempValue /= TEN;
            if (tempValue < TEN){
                return i;
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

    public void insert(DataItem item) // Вставка элемента данных
    // (Метод предполагает, что таблица не заполнена)
    {
        int key = item.getKey(); // Получение ключа
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) // Пока не найдена пустая ячейка или -1
        {
            ++hashVal; // Переход к следующей ячейке
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        hashArray[hashVal] = item; // Вставка элемента
    }

    public DataItem delete(int key) // Удаление элемента данных
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null) // Пока не будет найдена пустая ячейка
        {
            if(hashArray[hashVal].getKey() == key) // Ключ найден?
            {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem; // Удаление элемента
                return temp; // Метод возвращает элемент
            }
            ++hashVal; // Переход к следующей ячейке
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }

    public DataItem find(int key) // Поиск элемента с заданным ключом
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null) // Пока не будет найдена пустая ячейка
        {
            if(hashArray[hashVal].getKey() == key) // Ключ найден?
                return hashArray[hashVal]; // Да, вернуть элемент
            ++hashVal; // Переход к следующей ячейке
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }
}
