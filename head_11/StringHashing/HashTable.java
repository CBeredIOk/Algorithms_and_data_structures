package Lafore.head_11.StringHashing;

import java.util.Objects;

class HashTable
{
    private DataItem[] hashArray; // Массив ячеек хеш-таблицы
    private int arraySize;
    private DataItem nonItem;
    public HashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("<...>"); // Ключ удаленного элемента <...>
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

    public int hashFunc(String key)
    {
        int hashVal = 0;
        for(int j=0; j<key.length(); j++) // Слева направо
        {
            int letter = key.charAt(j) - 96; // Получение кода символа
            hashVal = (hashVal * 27 + letter) % arraySize; // Оператор %
        }
        return hashVal; // Без оператора %
    }

    public void insert(DataItem item) // Вставка элемента данных
    // (Метод предполагает, что таблица не заполнена)
    {
        String key = item.getKey(); // Получение ключа
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null && !Objects.equals(hashArray[hashVal].getKey(), nonItem.getKey())) // Пока не найдена пустая ячейка или -1
        {
            ++hashVal;
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        hashArray[hashVal] = item; // Вставка элемента
    }

    public DataItem delete(String key) // Удаление элемента данных
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null) // Пока не будет найдена пустая ячейка
        {
            if(Objects.equals(hashArray[hashVal].getKey(), key)) // Ключ найден?
            {
                DataItem temp = hashArray[hashVal]; // Временное сохранение
                hashArray[hashVal] = nonItem; // Удаление элемента
                return temp; // Метод возвращает элемент
            }
            ++hashVal;
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }

    public DataItem find(String key) // Поиск элемента с заданным ключом
    // (Метод предполагает, что таблица не заполнена)
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        while(hashArray[hashVal] != null) // Пока не будет найдена пустая ячейка
        {
            if(Objects.equals(hashArray[hashVal].getKey(), key)) // Ключ найден?
                return hashArray[hashVal]; // Да, вернуть элемент
            ++hashVal;
            hashVal %= arraySize; // При достижении конца таблицы происходит возврат к началу
        }
        return null; // Элемент не найден
    }
}
