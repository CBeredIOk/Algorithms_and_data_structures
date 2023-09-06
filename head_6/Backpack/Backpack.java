package Lafore.head_6.Backpack;

public class Backpack {
    private static int[] items;
    private static int neededWeight;
    private static int k = 2;
    public static void main(String[] args){
        neededWeight = 20;
        items = new int[]{3, 4, 6, 10, 5, 7, 2, 1};
        int i = 7;
        Search(i, neededWeight);
    }

    public static void Search(int i, int remainingWeight){
        System.out.println("i now: " + i);
        System.out.println("\tIn function");
        System.out.println("remainingWeight now: " + remainingWeight);
        if (remainingWeight == 0){
            System.out.println("\tBackpack is full");
            i++;
            k--;
            System.out.print("Item: ");
            for(int j = i; j <= items.length - k; j++){
                System.out.print(items[j] + " (" + j + ") ");
            }
            return;
        }
        else{
            remainingWeight = remainingWeight - items[i--];
            System.out.println("\tremainingWeight after: " + remainingWeight);
            if (i == -1 || remainingWeight < 0){
                i = items.length - k;
                System.out.println("i after: " + i);
                remainingWeight = neededWeight;
                k++;
                if(k > items.length){
                    System.out.println("\tBackpack can't be full");
                    return;
                }
            }
            Search(i,remainingWeight);
        }
    }
}
