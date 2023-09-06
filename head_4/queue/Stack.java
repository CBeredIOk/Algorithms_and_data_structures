package Lafore.head_4.queue;

public class Stack extends Deque{
    public Stack(int s) {
        super(s);
    }

    public void insert(int insert){
        super.insertLeft(insert);
    }

    public void remove(){
        super.removeRight();
    }

    public void peek(){
        long top = Front();
        long bottom = Rear();
        System.out.println("Top: " + top + ", Bottom: " + bottom);
    }
}
