package Lafore.head_12.AscendingOrder;

class Node
{
    private int iData; // Данные (ключ)

    public Node(int key) {// Конструктор
        iData = key;
    }

    public int getKey() {
        return iData;
    }

    public void setKey(int id) {
        iData = id;
    }

}
