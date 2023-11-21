package Lafore.head_13;

class Graph
{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // Список вершин
    private int adjMat[][]; // Матрица смежности
    private int nVerts; // Текущее количество вершин
    private Queue theQueue;

    public Graph() // Конструктор
    {
        vertexList = new Vertex[MAX_VERTS];
        // Матрица смежности
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // Матрица смежности
            for(int k=0; k<MAX_VERTS; k++) // заполняется нулями
                adjMat[j][k] = 0;
        theQueue = new Queue();
    }

    public void addVertex(char lab)
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end)
    {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v)
    {
        System.out.print(vertexList[v].label);
    }

    public void bfs() // Обход в ширину
    { // Алгоритм начинает с вершины 0
        vertexList[0].wasVisited = true; // Пометка
        displayVertex(0); // Вывод
        theQueue.insert(0); // Вставка в конец очереди
        int v2;
        while( !theQueue.isEmpty() ) // Пока очередь не опустеет
        {
            int v1 = theQueue.remove(); // Извлечение вершины в начале очереди
            // Пока остаются непосещенные соседи
            while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
            { // Получение вершины
                vertexList[v2].wasVisited = true; // Пометка
                displayVertex(v2); // Вывод
                    theQueue.insert(v2); // Вставка
            }
        }
        // Очередь пуста, обход закончен
        for(int j=0; j<nVerts; j++) // Сброс флагов
            vertexList[j].wasVisited = false;
    }

    // Метод возвращает непосещенную вершину, смежную по отношению к v
    public int getAdjUnvisitedVertex(int v)
    {
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j; // Возвращает первую найденную вершину
        return -1; // Таких вершин нет
    }
}
