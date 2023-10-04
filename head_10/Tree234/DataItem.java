package Lafore.head_10.Tree234;

class DataItem
{
    public long dData; // Один объект данных

    public DataItem(long dd) // Конструктор
    { dData = dd; }

    public void displayItem() // Вывод элемента в формате "/27"
    { System.out.print("/"+dData); }
}

