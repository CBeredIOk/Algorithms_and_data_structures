package Lafore.head_8.Task_3;


import java.io.IOException;
import java.util.Scanner;

class TreeApp
{
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Создание объекта для разбора выражения
        System.out.print("Enter postfix equation: ");
        String input = scanner.nextLine();

        Tree fullTree = Tree.doFullTree(input);
        fullTree.displayTree();

        // Выбор обхода дерева
        System.out.print("Choose traverse (1 - Preorder, 2 - Inorder, 3 - Postorder): ");
        int value = scanner.nextInt();
        fullTree.traverse(value);

    }
}