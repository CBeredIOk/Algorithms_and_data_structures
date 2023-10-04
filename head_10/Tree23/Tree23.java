package Lafore.head_10.Tree23;

import java.util.Arrays;

class Tree23
{
    private Node root = new Node(); // Создание корневого узла

    public int find(long key)
    {
        Node curNode = root;
        int childNumber;
        while(true)
        {
            if(( childNumber=curNode.findItem(key) ) != -1)
                return childNumber; // Узел найден
            else if( curNode.isLeaf() )
                return -1; // Узел не найден
            else // Искать глубже
                curNode = getNextChild(curNode, key);
        }
    }

    // Вставка элемента данных
    public void insert(long dValue)
    {
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);
        while(true)
        {
            if( curNode.isLeaf() ) { // Если узел листовой, переход к вставке
                if( curNode.isFull() ){
                    split(curNode, dValue); // Если узел полный, он разбивается
                }
                else {
                    curNode.insertItem(tempItem); // Вставка нового объекта DataItem
                }
                break;
            }
            // Узел не полный и не листовой; спуститься уровнем ниже
            else {
                curNode = getNextChild(curNode, dValue);
            }
        }
    }

    private Node split(Node thisNode, long dValue) // Разбиение узла
    {
        Node newNode = new Node();
        Node newParent;
        Node parent;

        DataItem itemC = new DataItem(dValue);
        DataItem itemB = thisNode.removeItem();
        DataItem itemA = thisNode.removeItem();

        long[] arrayItems = sortItems(itemA, itemB, itemC);

        itemC.dData = arrayItems[2];
        itemB.dData = arrayItems[1];
        itemA.dData = arrayItems[0];

        thisNode.insertItem(itemA);
        newNode.insertItem(itemC);

        if (thisNode == root) {
            root = new Node();
            root.insertItem(itemB);
            root.connectChild(0, thisNode);
            root.connectChild(1, newNode);
            return newNode;
        } else if (thisNode.getParent().isFull()) {
            newParent = split(thisNode.getParent(), itemB.dData);
        }
        else {
            parent = thisNode.getParent();
            parent.insertItem(itemB);
            if (parent.getChild(0) == thisNode){
                Node child1 = parent.getChild(1);
                parent.disconnectChild(1);
                parent.connectChild(1, newNode);
                parent.connectChild(2, child1);
            }
            else if (parent.getChild(1) == thisNode) {
                parent.connectChild(2, newNode);
            }
            return newNode;
        }
        changeConnection(newParent, thisNode, newNode);
        return newNode;
    }

    private void changeConnection(Node newParent, Node thisNode, Node newNode){
        Node parent = thisNode.getParent();
        Node child1 = parent.getChild(1);
        Node child2 = parent.getChild(2);

        if (parent.getChild(0) == thisNode){
            parent.disconnectChild(1);
            parent.disconnectChild(2);
            parent.connectChild(1, newNode);
            newParent.connectChild(0, child1);
            newParent.connectChild(1, child2);
        } else if (parent.getChild(1) == thisNode) {
            parent.disconnectChild(2);
            parent.connectChild(1, newNode);
            newParent.connectChild(0, newNode);
            newParent.connectChild(1, child2);
        } else {
            parent.disconnectChild(2);
            newParent.connectChild(1, newNode);
            newParent.connectChild(0, child2);
        }
    }
    private long[] sortItems(DataItem item1, DataItem item2, DataItem item3){
        long[] arrayItems = new long[3];
        arrayItems[0] = item1.dData;
        arrayItems[1] = item2.dData;
        arrayItems[2] = item3.dData;
        Arrays.sort(arrayItems);
        return arrayItems;
    }

    // Получение соответствующего потомка при поиске значения
    public Node getNextChild(Node theNode, long theValue)
    {
        int j;
        // Предполагается, что узел не пуст, не полон и не является листом
        int numItems = theNode.getNumItems();
        for(j=0; j<numItems; j++) // Для каждого элемента в узле
        { // Наше значение меньше?
            if( theValue < theNode.getItem(j).dData )
                return theNode.getChild(j); // Вернуть левого потомка
        } // Наше значение больше,
        return theNode.getChild(j); // Вернуть правого потомка
    }

    public void displayTree()
    {
        System.out.println("--------------------------------");
        recDisplayTree(root, 0, 0);
        System.out.println("--------------------------------");
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.print("level = " + level + "; child = " + childNumber + "; ");
        thisNode.displayNode(); // Вывод содержимого узла
        // Рекурсивный вызов для каждого потомка текущего узла
        int numItems = thisNode.getNumItems();
        for(int j=0; j<numItems+1; j++)
        {
            Node nextNode = thisNode.getChild(j);
            if(nextNode != null)
                recDisplayTree(nextNode, level+1, j);
            else
                return;
        }
    }
}
