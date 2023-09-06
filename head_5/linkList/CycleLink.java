package Lafore.head_5.linkList;

public class CycleLink {

    private Link first; // Ссылка на первый элемент списка
    private Link last; // Ссылка на последний элемент списка
    private Link current;

    public CycleLink() // Конструктор
    {
        first = null; // Список пока не содержит элементов
    }

    public boolean isEmpty () // true, если список пуст
    {
        return (first == null);
    }
    public void step(){
        current = current.next;
    }
    public void lastIs(){
        if (isEmpty())
            System.out.println("List is empty");
        else {
            System.out.println(last.iData + " is last");
            System.out.println(last.next.iData + " is last.next");
        }
    }
    public void firstIs(){
        if (isEmpty())
            System.out.println("List is empty");
        else {
            System.out.println(first.iData + " is first");
            System.out.println(first.next.iData + " is first.next");
        }
    }
    public void currentIs(){
        if (isEmpty())
            System.out.println("List is empty");
        else {
            System.out.println(current.iData + " is current");
            System.out.println(current.next.iData + " is current.next");
        }
    }
    public void insertAfter(int id) // Вставка элемента в начало списка
    {
        Link newLink = new Link(id); // Создание нового элемента
        if (isEmpty()){
            first = newLink; // first -- newLink
            last = first; // last -- first
            current = first; // last -- current
            first.next = last; // firs --> last
            System.out.println("Inserted first: " + newLink.iData);
        }
        else if(current == last){
            newLink.next = first;
            first = newLink;
            System.out.println("Inserted after last: " + newLink.iData);
        }
        else if(current == first){
            newLink.next = first.next;
            first.next = newLink;
            System.out.println("Inserted after first: " + newLink.iData);
        }
        else{
            newLink.next = current.next; // newLink --> следующее current
            current.next = newLink; // current --> newLink
            System.out.println("Inserted: " + newLink.iData);
        }
        last.next = first; // last --> first
        displayStack();
    }

        public Link find (int key) // Поиск элемента с заданным ключом (предполагается, что список не пуст)
        {
            Link temporary = current;
            while (current.next.iData != key) // Пока совпадение не найдено
            {
                if (current.next == temporary) { // Если достигнут конец списка
                    System.out.println(key + " isn't find");
                    return null; // и совпадение не найдено
                }
                else { // Если еще остались элементы
                    step(); // Перейти к следующему элементу
                }
            }
            System.out.println(current.next.iData + " is find");
            return current.next; // Совпадение обнаружено
        }

        public Link delete (int key) // Удаление элемента с заданным ключом (предполагается, что список не пуст)
        {
            Link temporary = current;
            while (current.next.iData != key) // Пока совпадение не найдено
            {
                if (current.next == temporary) { // Если достигнут конец списка
                    System.out.println(key + " isn't find");
                    return null; // и совпадение не найдено
                }
                else { // Если еще остались элементы
                    step(); // Перейти к следующему элементу
                }
            }
            // Совпадение найдено
            Link deleted = current.next;
            if (first == last) {
                first = null;
                current = null;
                last = null;
                System.out.println("List is empty");
                return null;
            }
            else if (current.next == last) {
                last = current;
                last.next = first;
            }
            else if (current.next == first) { // Если первый элемент,
                first = first.next; // изменить first
                last.next = first;
            }
            else { // В противном случае
                temporary = current.next;
                current.next = temporary.next;
            }
            System.out.println(deleted.iData + " is deleted");
//            displayList();
            displayStack();
            return deleted;
        }

    public Link deleteStack () // Удаление элемента с заданным ключом (предполагается, что список не пуст)
    {
        Link temporary = current;
        // Совпадение найдено
        Link deleted = current.next;
        if (first == last) {
            first = null;
            current = null;
            last = null;
            System.out.println(deleted.iData + " is deleted");
            System.out.println("List is empty");
            return null;
        }
        else if (current.next == last) {
            last = current;
            last.next = first;
        }
        else if (current.next == first) { // Если первый элемент,
            first = first.next; // изменить first
            last.next = first;
        }
        else { // В противном случае
            temporary = current.next;
            current.next = temporary.next;
        }
        System.out.println(deleted.iData + " is deleted");
//        displayList();
        displayStack();
        return deleted;
    }

    public void displayList ()
    {
        System.out.print("List from current: ");
        Link temporary = current;
        do
        {
            current.displayLink(); // Вывод данных
            step(); // Переход к следующему элементу
        } while (current != temporary); // Перемещение до конца списка

        System.out.println(" ");
    }

    public void displayStack ()
    {
        System.out.print("List from current: ");
        Link temporary = current.next;
        do
        {
            current.next.displayLink(); // Вывод данных
            step(); // Переход к следующему элементу
        } while (current.next != temporary); // Перемещение до конца списка

        System.out.println(" ");
    }
    }
