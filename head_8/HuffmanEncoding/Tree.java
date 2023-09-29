package Lafore.head_8.HuffmanEncoding;

import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Tree {
    private Node root; // Первый узел дерева

    public Tree() // Конструктор
    {
        root = null; // Пока нет ни одного узла
    }

    public void displayTree()
        {
            Stack globalStack = new Stack();
            globalStack.push(root);
            int nBlanks = 32;
            boolean isRowEmpty = false;
            System.out.println(
                    "....................................................................");
            while (isRowEmpty == false) {
                Stack localStack = new Stack();
                isRowEmpty = true;
                for (int j = 0; j < nBlanks; j++)
                    System.out.print(' ');
                while (globalStack.isEmpty() == false) {
                    Node temp = (Node) globalStack.pop();
                    if (temp != null) {
                        if (temp.leftChild == null &&
                            temp.rightChild == null)
                        {
                            System.out.print(temp.chData + ":");
                            System.out.print(temp.iData);
                        }
                        else{
                            System.out.print(temp.iData);
                        }
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
            System.out.println(
                    "....................................................................");
        }

    static String decodingHuffmanCode(String inputString, Map<Character, String> dictionary){
        String key = "";
        StringBuilder output = new StringBuilder();
        char[] charArray = inputString.toCharArray();
        Map<String, Character> reversedDictionary = changeKeyAndValue(dictionary);
        for (char charElement : charArray){
            key += charElement;
            char value;
            if (reversedDictionary.get(key) != null){
                value = reversedDictionary.get(key);
                key = "";
                output.append(value);
            }
        }
        return output.toString();
    }

    static Map<String, Character> changeKeyAndValue(Map<Character, String> dictionary){
        Map<String, Character> reversedDictionary = new HashMap<>();
        for (Map.Entry<Character, String> entry : dictionary.entrySet()) {
            reversedDictionary.put(entry.getValue(), entry.getKey());
        }
        return reversedDictionary;
    }

    static String makeHuffmanCode(String input, Map<Character, String> dictionary){
        StringBuilder codeHuffman = new StringBuilder();
        char[] charArray = input.toCharArray();
        for (char key : charArray) {
            String value = dictionary.get(key);
            codeHuffman.append(value);
        }
        return codeHuffman.toString();
    }

    static Map<Character, String> makeHuffmanTable(Tree huffmanTree){
        Node newNode = huffmanTree.root;
        Map<Character, String> dictionary = recMakeHuffmanTable(newNode.leftChild, "", "0");
        dictionary.putAll(recMakeHuffmanTable(newNode.rightChild, "", "1"));
        return dictionary;
    }

    static Map<Character, String> recMakeHuffmanTable(Node newNode, String huffmanCode, String side){
        Map<Character, String> dictionary = new HashMap<>();
        huffmanCode += side;
        if (newNode.leftChild == null && newNode.rightChild == null){
            dictionary.put(newNode.chData, huffmanCode);
            return dictionary;
        }
        dictionary = recMakeHuffmanTable(newNode.leftChild, huffmanCode, "0");
        dictionary.putAll(recMakeHuffmanTable(newNode.rightChild, huffmanCode, "1"));
        return dictionary;
    }

    static Tree makeHuffmanTree(String inputString){
        PriorityQueue<Node> priorityQueue = makePriorityQueue(inputString);

        // Пока не останется последний узел, который является корнем дерева
        while (priorityQueue.size() != 1){
            Node newNode = new Node();
            newNode.leftChild = priorityQueue.poll();
            if (priorityQueue.isEmpty()) break;
            else newNode.rightChild = priorityQueue.poll();
            newNode.iData = newNode.leftChild.iData + newNode.rightChild.iData;
            priorityQueue.offer(newNode);
        }
        Tree huffmanTree = new Tree();
        huffmanTree.root = priorityQueue.poll();
        return huffmanTree;
    }
    static PriorityQueue<Node> makePriorityQueue(String inputString){
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new NodeComparator());

        char[] charArray = inputString.toCharArray();
        Node[] arrayNode = makeArrayNodes(charArray);

        // Добавляем элементы в приоритетную очередь
        for (Node value : arrayNode) {
            priorityQueue.offer(value);
        }
        return priorityQueue;
    }

    static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node node1, Node node2) {
            return Integer.compare(node1.iData, node2.iData); // Сравниваем по полю iData
        }
    }

    static Node[] makeArrayNodes(char[] charArray){
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Проходим по массиву символов и обновляем карту
        for (char c : charArray) {
            // Используем метод getOrDefault для увеличения счетчика символа
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        Node[] arrayNode = new Node[charCountMap.size()];

        // Вносим необходимые значения в узлы
        int i = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            Node newNode = new Node();
            newNode.chData = entry.getKey();
            newNode.iData = entry.getValue();
            arrayNode[i++] = newNode;
        }
        return arrayNode;
    }
}