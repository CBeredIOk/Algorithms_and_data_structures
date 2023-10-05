package Lafore.head_11.HashChain;

class HashTable
{
    private Tree[] hashArray; // Массив деревьев
    private int arraySize;

    public HashTable(int size) // Конструктор
    {
        arraySize = size;
        hashArray = new Tree[arraySize]; // Создание массива
        for(int j=0; j<arraySize; j++) // Заполнение массива
            hashArray[j] = new Tree(); // деревьями
    }

    public void displayTable()
    {
        for(int j = 0; j < arraySize; j++) // Для каждой ячейки
        {
            System.out.print(j + ". "); // Вывод номера ячейки
            hashArray[j].traverse(2); // Вывод дерева
        }
    }

    public int hashFunc(int key) // Хеш-функция
    {
        return key % arraySize;
    }

    public void insert(int key) // Вставка элемента
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        hashArray[hashVal].insert(key); // Вставка в позиции hashVal
    }

    public Node find(int key) // Поиск элемента
    {
        int hashVal = hashFunc(key); // Хеширование ключа
        Tree theTree = hashArray[hashVal]; // Поиск
        if (theTree != null) {
            theTree.displayTree();
            return theTree.find(key); // Метод возвращает найденный элемент
        }
        else
            return null;
    }
}
