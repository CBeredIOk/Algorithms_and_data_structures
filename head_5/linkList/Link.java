package Lafore.head_5.linkList;

// Работа со связанным списком
// Запуск программы: C>java LinkListApp

class Link
{
    public int iData; // Данные (ключ)
    public double dData; // Данные
    public Link next; // Следующий элемент в списке

    public Link(int id) // Конструктор
    {
        iData = id; // Инициализация данных
//        dData = dd; // ('next' автоматически присваивается null)
    }

    public void displayLink() // Вывод содержимого элемента
    {
//        System.out.print("{" + iData + ", " + dData + "} ");
        System.out.print("(" + iData + ") ");
    }
}
