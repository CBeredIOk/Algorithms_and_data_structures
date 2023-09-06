package Lafore.head_5.linkList;
import  java.util.Scanner;

class LinkListApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of people: ");
        int people = scanner.nextInt();
        System.out.println("Enter number of count: ");
        int count = scanner.nextInt();
        System.out.println("Enter number of fromWho: ");
        int fromWho = scanner.nextInt();

        CycleLink theList = new CycleLink(); // Создание нового списка
        CycleLink retired = new CycleLink();
        Link temp;

        for (int i = people; i > 0; i--){
            theList.insertAfter(i);
        }

        theList.currentIs();

        for (int k = 2; k <= fromWho; k++){
            System.out.println("Start from: " + fromWho);
            theList.step();
            theList.currentIs();
        }

        int n = 0;

        System.out.println("Start game");
        while (n < people-1) {
            theList.currentIs();
            for (int j = 0; j < count; j++) {
                theList.step();
                theList.currentIs();
            }
            temp = theList.deleteStack();
            retired.insertAfter(temp.iData);
            n++;
        }
    }
}
