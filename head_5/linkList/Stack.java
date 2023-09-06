package Lafore.head_5.linkList;

public class Stack {
    CycleLink aStack = new CycleLink();
    public void Stack(){
//        aStack = new CycleLink();
    }

    public void insert(int id){
        aStack.insertAfter(id);
    }

    public void delete(){
        aStack.deleteStack();
    }

    public void displayStack(){
        aStack.displayStack();
    }
}
