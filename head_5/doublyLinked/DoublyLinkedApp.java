package Lafore.head_5.doublyLinked;

class DoublyLinkedApp
{
    public static void main(String[] args)
    { // Создание нового списка

        DequeOnDoubly theDeque = new DequeOnDoubly();
        theDeque.insertLeft(10);
        theDeque.insertLeft(20);
        theDeque.insertLeft(30);
        theDeque.insertLeft(40);
        theDeque.display();

        theDeque.insertRight(50);
        theDeque.insertRight(60);
        theDeque.insertRight(70);
        theDeque.insertRight(80);
        theDeque.display();

        theDeque.removeLeft();
        theDeque.removeLeft();
        theDeque.display();

        theDeque.removeRight();
        theDeque.removeRight();
        theDeque.display();

        theDeque.peekLeft();
        theDeque.peekRight();

        theDeque.findDeque(50);

//        DoublyLinkedList theList = new DoublyLinkedList();
//        theList.insertFirst(22); // Вставка в начале
//        theList.insertFirst(44);
//        theList.insertFirst(66);
//        theList.insertLast(11); // Вставка в конце
//        theList.insertLast(33);
//        theList.insertLast(55);
//        theList.displayForward(); // Вывод в прямом направлении
//        theList.displayBackward(); // Вывод в обратном направлении
//        theList.deleteFirst(); // Удаление первого элемента
//        theList.deleteLast(); // Удаление последнего элемента
//        theList.deleteKey(11); // Удаление элемента с ключом 11
//        theList.displayForward(); // Вывод в прямом направлении
//        theList.insertAfter(22, 77); // Вставка 77 после 22
//        theList.insertAfter(33, 88); // Вставка 88 после 33
//        theList.displayForward(); // Вывод в прямом направлении

    }
}
