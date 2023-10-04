package Lafore.head_10.Tree234;

import java.util.LinkedList;
import java.util.Queue;

class Tree234
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
            if( curNode.isFull() ) // Если узел полон,
            {
                split(curNode); // он разбивается.
                curNode = curNode.getParent(); // Возврат уровнем выше
                // Поиск
                curNode = getNextChild(curNode, dValue);
            }
            else if( curNode.isLeaf() ) // Если узел листовой,
                break; // переход к вставке
                // Узел не полный и не листовой; спуститься уровнем ниже
            else
                curNode = getNextChild(curNode, dValue);
        }
            curNode.insertItem(tempItem); // Вставка нового объекта DataItem
    }

    public void split(Node thisNode) // Разбиение узла
    {
        // Предполагается, что узел полон
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;
        itemC = thisNode.removeItem(); // Удаление элементов из
        itemB = thisNode.removeItem(); // текущего узла
        child2 = thisNode.disconnectChild(2); // Отсоединение потомков
        child3 = thisNode.disconnectChild(3); // от текущего узла
        Node newRight = new Node(); // Создание нового узла
        if(thisNode==root) // Если узел является корнем,
        {
            root = new Node(); // Создание нового корня
            parent = root; // Корень становится родителем
            root.connectChild(0, thisNode); // Связывание с родителем
        }
        else // Текущий узел не является корнем
            parent = thisNode.getParent(); // Получение родителя
        // Разбираемся с родителем
        itemIndex = parent.insertItem(itemB); // B вставляется в родителя
        int n = parent.getNumItems(); // Всего элементов?
        for(int j=n-1; j>itemIndex; j--) // Перемещение связей
        { // родителя
            Node temp = parent.disconnectChild(j); // На одного потомка
            parent.connectChild(j+1, temp); // вправо
        }
        // Связывание newRight с родителем
        parent.connectChild(itemIndex+1, newRight);
        // Разбираемся с узлом newRight
        newRight.insertItem(itemC); // Элемент C в newRight
        newRight.connectChild(0, child2); // Связывание 0 и 1
        newRight.connectChild(1, child3); // с newRight
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
        recDisplayTree(root, 0, 0);
    }

    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.print("level="+level+" child="+childNumber+" ");
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

    public long findMinimum(){
        Node curNode = root;
        while(!curNode.isLeaf())
        {
            curNode = curNode.getChild(0);
        }
        return curNode.getItem(0).dData;
    }

    public void symmetricTraversal(){
        Node curNode = root;
        recSymmetricTraversal(curNode);
        System.out.println(" ");
    }

    private void recSymmetricTraversal(Node curNode){
        int numItems = curNode.getNumItems();
        if (curNode.isLeaf()) {
            for (int j = 0; j < numItems; j++) {
                System.out.print(curNode.getItem(j).dData + " ");
            }
        }
        else{
            for(int j=0; j < numItems+1; j++)
            {
                Node nextNode = curNode.getChild(j);
                if(nextNode != null) {
                    recSymmetricTraversal(nextNode);
                }
                if(j == numItems){
                    return;
                }
                else{
                    System.out.print(curNode.getItem(j).dData + " ");
                }
            }
        }
    }
    public long[] sort(long[] arrayLong){
        Queue<Long> queue = new LinkedList<>();
        insertArrayInTree(arrayLong);
        Queue<Long> sortedArrayInQueue = recSortArray(root, queue);
        return queueInArray(sortedArrayInQueue);
    }

    private void insertArrayInTree(long[] arrayLong){
        for (long element : arrayLong) {
            insert(element);
        }
    }

    private Queue<Long> recSortArray(Node curNode, Queue<Long> sortedArrayInQueue){
        int numItems = curNode.getNumItems();
        if (curNode.isLeaf()) {
            for (int j = 0; j < numItems; j++) {
                sortedArrayInQueue.offer(curNode.getItem(j).dData);
            }
            return sortedArrayInQueue;
        }
        else{
            for(int j=0; j < numItems+1; j++)
            {
                Node nextNode = curNode.getChild(j);
                if(nextNode != null) {
                    sortedArrayInQueue = new LinkedList<>(recSortArray(nextNode, sortedArrayInQueue));
                }
                if(j == numItems){
                    return sortedArrayInQueue;
                }
                else{
                    sortedArrayInQueue.offer(curNode.getItem(j).dData);
                }
            }
        }
        return sortedArrayInQueue;
    }

    private long[] queueInArray(Queue<Long> queue){
        long[] array = new long[queue.size()];
        int i = 0;
        while(!queue.isEmpty()){
            array[i++] = queue.poll();
        }
        return array;
    }
}
