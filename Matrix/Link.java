package Lafore.Matrix;

class Link
{
    public int iData; // Данные (ключ)
//    public Link nextRight; // Следующий элемент в списке
    public Link next;
    public Link(int id) // Конструктор
    {
        iData = id; // Инициализация данных
    }

    public void displayLink() // Вывод содержимого элемента
    {
        System.out.print("(" + iData + ") ");
    }
}