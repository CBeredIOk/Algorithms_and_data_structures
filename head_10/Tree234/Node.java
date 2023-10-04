package Lafore.head_10.Tree234;

class Node
{
    private static final int ORDER = 4;
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[ORDER];
    private DataItem itemArray[] = new DataItem[ORDER-1];

    // Связывание узла с потомком
    public void connectChild(int childNum, Node child)
    {
        childArray[childNum] = child;
        if(child != null)
            child.parent = this;
    }

    // Метод отсоединяет потомка от узла и возвращает его
    public Node disconnectChild(int childNum)
    {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public Node getChild(int childNum)
    { return childArray[childNum]; }

    public Node getParent()
    { return parent; }

    public boolean isLeaf()
    { return (childArray[0]==null) ? true : false; }

    public int getNumItems()
    { return numItems; }

    public DataItem getItem(int index) // Получение объекта DataItem
    { return itemArray[index]; } // с заданным индексом

    public boolean isFull()
    { return (numItems==ORDER-1) ? true : false; }

    public int findItem(long key) // Определение индекса элемента
    { // (в пределах узла)
        for(int j=0; j<ORDER-1; j++) // Если элемент найден
        { // В противном случае
            if(itemArray[j] == null) // Вернуть -1
                break;
            else if(itemArray[j].dData == key)
                return j;
        }
        return -1;
    }

    public int insertItem(DataItem newItem)
    {
        // Предполагается, что узел не пуст
        numItems++; // Добавление нового элемента
        long newKey = newItem.dData; // Ключ нового элемента
        for(int j=ORDER-2; j>=0; j--) // Начиная справа, проверяем элементы
        {
            if(itemArray[j] == null) // Если ячейка пуста, перейти на одну ячейку влево
                continue;
            else // Если нет, получить ее ключ
            {
                long itsKey = itemArray[j].dData;
                if(newKey < itsKey) // Если новый ключ больше
                    itemArray[j+1] = itemArray[j]; // Сдвинуть вправо
                else
                {
                    itemArray[j+1] = newItem; // Вставка нового элемента
                    return j+1; // Метод возвращает индекс нового элемента
                }
            }
        } // Все элементы сдвинуты,
        itemArray[0] = newItem; // вставка нового элемента
        return 0;
    }

    public DataItem removeItem() // Удаление наибольшего элемента
    {
        // Предполагается, что узел не пуст
        DataItem temp = itemArray[numItems-1]; // Сохранение элемента
        itemArray[numItems-1] = null; // Отсоединение
        numItems--; // На один элемент меньше
        return temp; // Метод возвращает удаленный элемент
    }

    public void displayNode() // Формат "/24/56/74/"
    {
        for(int j=0; j<numItems; j++)
            itemArray[j].displayItem(); // "/56"
        System.out.println("/"); // Завершающий символ "/"
    }
}

