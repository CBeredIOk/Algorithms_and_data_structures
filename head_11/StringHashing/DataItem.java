package Lafore.head_11.StringHashing;

class DataItem
{ // (Данных может быть и больше)
    private String iData; // Данные (ключ)

    public DataItem(String ii) // Конструктор
    { iData = ii; }

    public String getKey()
    { return iData; }
}
