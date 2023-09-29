package Lafore.head_8.HuffmanEncoding;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

class EncodingAndDecodingApp
{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Создание объекта для разбора выражения
        System.out.print("Enter postfix equation: ");
        String inputString = scanner.nextLine();

        // Создание дерева Хафмана
        Tree huffmanTree = Tree.makeHuffmanTree(inputString);

        // Создание таблицы Хафмана
        Map<Character, String> dictionaryHuffman = Tree.makeHuffmanTable(huffmanTree);
        System.out.println(dictionaryHuffman);

        // И уже создание кодированного сообщения
        String codeHuffman = Tree.makeHuffmanCode(inputString, dictionaryHuffman);
        System.out.println(codeHuffman);

        //Декодирование сообщения
        String decodingString = Tree.decodingHuffmanCode(codeHuffman, dictionaryHuffman);
        System.out.println(decodingString);
    }
}