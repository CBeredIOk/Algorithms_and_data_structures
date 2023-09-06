package Lafore.head_5.doublyLinked;

public class DequeOnDoubly {

    private DoublyLinkedList theDequeLink;
    public DequeOnDoubly(){
        theDequeLink = new DoublyLinkedList();
    }

    public boolean isEmpty(){
        return theDequeLink.isEmpty();
    }

    public void insertLeft(int value){
        theDequeLink.insertFirst(value);
    }

    public void insertRight(int value){
        theDequeLink.insertLast(value);
    }

    public long removeLeft(){
        return theDequeLink.deleteFirst().dData;
    }

    public long removeRight(){
        return theDequeLink.deleteLast().dData;
    }

    public long peekLeft(){
        if (!isEmpty())
            System.out.println("First: " + theDequeLink.getFirst().dData);
        else System.out.println("Deque is empty");
        return theDequeLink.isEmpty() ? -1 : theDequeLink.getFirst().dData;
    }

    public long peekRight(){
        if (!isEmpty())
            System.out.println("Last: " + theDequeLink.getLast().dData);
        else System.out.println("Deque is empty");
        return theDequeLink.isEmpty() ? -1 : theDequeLink.getLast().dData;
    }

    public long findDeque(long key){
        Link element = theDequeLink.find(key);
        if (element == null)
            return -1;
        return element.dData;
    }

    public void display(){
        theDequeLink.displayForward();
    }

}
