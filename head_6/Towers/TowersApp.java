package Lafore.head_6.Towers;

class TowersApp {
    static int nDisks = 5;

    public static void main(String[] args) {
        doTowers(nDisks, 'A', 'B', 'C');
    }

    public static void doTabs(int topN){
        for (int i = nDisks; i > topN; i--){
            System.out.print("\t");
        }
    }

    public static void doTowers(int topN,
                                char from, char inter, char to)
    {
        doTabs(topN);
        System.out.println("Enter (" + topN + " disk): s=" + from +
                ", i=" + inter + ", d=" + to);
        if(topN==1) {
            doTabs(topN);
            System.out.println("\tBase case: move disk 1 from " + from + " to " + to);
        }
        else
        {
            doTowers(topN-1, from, to, inter); // from-->inter
            doTabs(topN);
            System.out.println("\tMove bottom disk " + topN +
                    " from " + from + " to "+ to);
            doTowers(topN-1, inter, from, to); // inter-->to
        }
        doTabs(topN);
        System.out.println("Return (" + topN + " disk)");
    }
}
