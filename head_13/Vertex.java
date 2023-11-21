package Lafore.head_13;

class Vertex
{
    public char label; // Метка (например, 'A')
    public boolean wasVisited;

    public Vertex(char lab) // Конструктор
    {
        label = lab;
        wasVisited = false;
    }
}
