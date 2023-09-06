package Lafore.head_5.linkList;

class LinkList
{
    private Link first; // Ссылка на первый элемент списка

    public LinkList() // Конструктор
    {
        first = null; // Список пока не содержит элементов
    }

    public boolean isEmpty() // true, если список пуст
    {
        return (first == null);
    }

    public void insertFirst(int id, double dd) // Вставка элемента в начало списка
    {
        Link newLink = new Link(id); // Создание нового элемента
        newLink.next = first; // newLink --> старое значение first
        first = newLink; // first --> newLink
    }

    public Link find(int key) // Поиск элемента с заданным ключом (предполагается, что список не пуст)
    {
        Link current = first; // Начиная с 'first'
        while(current.iData != key) // Пока совпадение не найдено
        {
            if(current.next == null) // Если достигнут конец списка
                return null; // и совпадение не найдено
            else // Если еще остались элементы
                current = current.next; // Перейти к следующему элементу
        }
        return current; // Совпадение обнаружено
    }

    public Link delete(int key) // Удаление элемента с заданным ключом (предполагается, что список не пуст)
    {
        Link current = first; // Поиск элемента
        Link previous = first;
        while(current.iData != key)
        {
            if(current.next == null)
                return null; // Элемент не найден
            else
            {
                previous = current; // Перейти к следующему элементу
                current = current.next;
            }
        }
        // Совпадение найдено
        if(current == first) // Если первый элемент,
            first = first.next; // изменить first
        else // В противном случае
            previous.next = current.next; // обойти его в списке
        return current;
    }

    public Link deleteFirst() // Удаление первого элемента (предполагается, что список не пуст)
    {
        Link temp = first; // Сохранение ссылки
        first = first.next; // Удаление: first --> ссылка на второй элемент
        return temp; // Метод возвращает ссылку на удаленный элемент
    }

    public void displayList()
    {
        System.out.print("List (first --> last): ");
        Link current = first; // От начала списка
        while(current != null) // Перемещение до конца списка
        {
            current.displayLink(); // Вывод данных
            current = current.next; // Переход к следующему элементу
        }
        System.out.println(" ");
    }

    public void sortDisplayList()
    {
        System.out.print("List (min id --> max id): ");
        Link current = first; // От начала списка
        Link false_current = first; // От начала списка
        Link next;
        int minimum_previous = -1;
        int minimum_current;

        while (false_current != null) { // Цикл, что бы отсортировать по всем id

            current = first;
            minimum_current = current.iData;

            while (current.next != null) // Перемещение до конца списка
            {
                next = current.next;
                if (current.iData > next.iData && next.iData > minimum_previous) {
                    minimum_current = next.iData;
                }
                current = current.next; // Переход к следующему элементу
            }
            minimum_previous = minimum_current;
            false_current = false_current.next;

            Link minimumLink = find(minimum_current);
            minimumLink.displayLink();
            System.out.print(" ");
        }
    }
}
