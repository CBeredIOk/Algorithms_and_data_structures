package Lafore.head_8.Postfix;


import java.util.Scanner;
import java.io.IOException;

class PostfixTreeApp
{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Создание объекта для разбора выражения
        System.out.print("Enter postfix equation: ");
        String input = scanner.nextLine();

        Tree postfixTree = Tree.doPostfixTree(input);
        postfixTree.displayTree();

        // Выбор обхода дерева
        System.out.print("Choose traverse (1 - Preorder, 2 - Inorder, 3 - Postorder): ");
        int value = scanner.nextInt();
        postfixTree.traverse(value);

    }
}