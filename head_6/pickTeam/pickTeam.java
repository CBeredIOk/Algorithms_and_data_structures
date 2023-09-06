package Lafore.head_6.pickTeam;

public class pickTeam {
    private static int count = 0;

    public static void main(String[] args){
        int group = 100;
        int membersCount = 3;
        showTeam(group, membersCount);
        System.out.println(count);

    }

    public static void showTeam(int group, int membersCount){
        if(group < membersCount || membersCount <= 0){
            return;
        }
        if(membersCount == 1){
            count++;
        }

        showTeam(group-1, membersCount);
        showTeam(group-1, membersCount-1);
    }
}
