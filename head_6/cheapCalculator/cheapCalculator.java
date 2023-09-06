package Lafore.head_6.cheapCalculator;

public class cheapCalculator {

    public static int a;
    public static int b;

    public static void main(String[] args){
        a = 25;
        b = 4;

        System.out.println();
        int result_mult = mult(a, b);

        System.out.println();
        int result_power = power(a, b);

        System.out.println("Result a x b = " + result_mult);
        System.out.println("Result a x b = " + result_power);

    }

    public static int mult(int x, int y){
        int temp;
        doTabs(y);
        System.out.println("Enter x mult y: " + x + ", " + y);
        if(y == 1){
            doTabs(y);
            System.out.println("Base case return " + x);
            return x;
        }
        else{
            temp = mult(x, y - 1);
            x = x + temp;
            doTabs(y);
            System.out.println("Return x, y: "  + x + ", " + y);
            return x;
        }
    }

    public static int power(int x, int y){
        int temp;
        doTabs(y);
        System.out.println("Enter x power y: " + x + ", " + y);
        if(y == 1){
            doTabs(y);
            System.out.println("Base case return " + x);
            return x;
        }
        else{
            temp = power(x, y - 1);
            x = x * temp;
            doTabs(y);
            System.out.println("Return x, y: "  + x + ", " + y);
            return x;
        }
    }

    public static void doTabs(int topN){
        for (int i = b; i > topN; i--){
            System.out.print("\t");
        }
    }
}
