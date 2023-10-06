package Lafore.head_12.PyramidalTree;

import java.util.Stack;

class Tree {
    private Node root; // first node of tree
    private int numberOfNode;

    public Tree() // Конструктор
    {
        root = null; // Пока нет ни одного узла
        numberOfNode = 0;
    }

    public boolean isEmpty(){
        return (root == null);
    }

    public int peekTop(){
        return root.iData;
    }

    public void insert(int id) {
        numberOfNode++;
        Node newNode = new Node(); // Создание нового узла
        newNode.iData = id; // Вставка данных
        if (root == null) { // Корневой узел не существует
            root = newNode;
        }
        else // Корневой узел занят
        {
            newNode = createLastPosition(id);
            findCorrectPosition(newNode);
        }
    }

    private void findCorrectPosition(Node newNode){
        Node current = newNode;
        int temp = newNode.iData;
        while (current.parent != null){
            if (temp > current.parent.iData) {
                current.iData = current.parent.iData;
            } else {
                break;
            }
            current = current.parent;
        }
        current.iData = temp;
    }

    private Node createLastPosition(int id){
        Node lastNode = new Node(); // Создание нового узла
        Node current = root; // Начать с корневого узла
        int[] path = findPath(numberOfNode); // Определяем путь для вставки
        for (int i = path.length - 1; i > 0; i--){
            if (path[i] == 1){
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        if (path[0] == 1){
            current.rightChild = lastNode;
        } else {
            current.leftChild = lastNode;
        }
        lastNode.parent = current;
        lastNode.iData = id;
        return lastNode;
    }
    private int[] findPath(int number){
        int arraySize = (int) ( Math.log(number) / Math.log(2));
        int[] path = new int[arraySize];
        int j = 0;
        while(number > 1)
        {
            path[j++] = number % 2;
            number = number / 2;
        }
        return path;
    }

    public int remove() // Удаление узла с заданным ключом
    {
        int top = root.iData;
        if (numberOfNode == 1){
            root = null;
        } else if (numberOfNode == 2){
            root.iData = root.leftChild.iData;
            root.leftChild = null;
        } else {
            root.iData = removeLastPosition();
            nodeInCorrectPosition(root);
        }
        numberOfNode--;
        return top;
    }

    private int removeLastPosition(){
        Node current = root; // Начать с корневого узла
        int[] path = findPath(numberOfNode);
        for (int i = path.length - 1; i > 0; i--){
            if (path[i] == 1){
                current = current.rightChild;
            } else {
                current = current.leftChild;
            }
        }
        int lastIData;
        if (path[0] == 1){
            lastIData = current.rightChild.iData;
            current.rightChild = null;
        } else {
            lastIData = current.leftChild.iData;
            current.leftChild = null;
        }
        return lastIData;
    }

    private void nodeInCorrectPosition(Node theNode){
        int temp = theNode.iData;
        Node current = theNode;
        Node lastCurrent;
        while(true){
            lastCurrent = current;
            current = largeChild(current);
            if (temp < current.iData){
                current.parent.iData = current.iData;
            }
            else {
                current.parent.iData = temp;
                break;
            }

            if (current.leftChild == null && current.rightChild == null){
                if (lastCurrent.rightChild == current){
                    lastCurrent.rightChild.iData = temp;
                } else if (lastCurrent.leftChild == current){
                    lastCurrent.leftChild.iData = temp;
                }
                break;
            }
        }
    }

    private Node largeChild(Node current){
        if (current.leftChild == null){
            return current.rightChild;

        } else if (current.rightChild == null) {
            return current.leftChild;

        } else {
            if (current.leftChild.iData > current.rightChild.iData) {
                return current.leftChild;
            } else {
                return current.rightChild;
            }
        }
    }

    public void change(int key, int newKey){
        Node theNode = new Node();
        theNode.iData = key;
        theNode = traverse(theNode);
        if (theNode.iData == -1){
            System.out.println("No such element in data");
            return;
        }
        theNode.iData = newKey;
        findCorrectPosition(theNode);
        nodeInCorrectPosition(theNode);
    }

    private Node traverse (Node nodeToFind)
    {
        return inOrder(root, nodeToFind.iData);
    }

    private Node inOrder (Node localRoot, int key)
    {
        Node zero = new Node();
        zero.iData = -1;
        Node node1;
        Node node2;
        if (localRoot != null) {
            if (localRoot.iData == key){
                return localRoot;
            }
            node1 = inOrder(localRoot.leftChild, key);
            node2 = inOrder(localRoot.rightChild, key);
        }
        else {
            return zero;
        }
        if (node1.iData != zero.iData){
            return node1;
        } else if (node2.iData != zero.iData){
            return node2;
        } else {
            return zero;
        }
    }

    public void displayTree ()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);
        String divider = "-----------------------------------------------------------------";
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(divider);
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(divider);
    }
}
