package Lafore.head_6.MakeBranchesApp;

public class Main {
    private static int heightTree;
    private static int lengthTree;
    private static char[][] treeBranch;

    public static void main(String[] args) {
        heightTree = 7; // Высота дерева
        lengthTree = (1 << heightTree) - 1;
        // Сдвиг битов числа 1 на одну позицию влево действительно удваивает это число
        // Исходное число 1 в двоичной системе имеет вид 0001. Если вы выполните сдвиг
        // влево на одну позицию, то получите 0010, что равно 2 в десятичной системе.

        treeBranch = new char[lengthTree][heightTree];

        for (int i = 0; i < lengthTree; i++) {
            for (int j = 0; j < heightTree; j++) {
                treeBranch[i][j] = '-';
            }
        }

        int left = 0;
        int right = lengthTree - 1;

        makeBranches(left, right, 0);

        display(treeBranch);

    }

    public static void makeBranches(int left, int right, int level) {
        if (level == heightTree) {
            return;
        } else {
            int middle = (left + right) / 2;
            treeBranch[middle][level] = 'X';
            level++;
            makeBranches(left, middle - 1, level);
            makeBranches(middle + 1, right, level);
        }

    }

    public static void display(char[][] doubleArray) {
        System.out.println();
        for (int j = 0; j < heightTree; j++) {
            System.out.println();
            for (int i = 0; i < lengthTree; i++) {
                System.out.print(doubleArray[i][j]);
            }
        }
        System.out.println();
    }
}

//    public static void display(char doubleArray[][]){
//        System.out.println();
//        for(char[] row : treeBranch)
//        {
//            System.out.println();
//            for(char c : row){
//                System.out.print(c);
//            }
//        }
//        System.out.println();
//    }
