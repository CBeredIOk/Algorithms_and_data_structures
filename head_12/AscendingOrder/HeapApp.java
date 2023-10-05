package Lafore.head_12.AscendingOrder;

import java.io.*;

class HeapApp
{
    public static void main(String[] args) throws IOException
    {
        int value, value2;
        Heap theHeap = new Heap(31); // Создание пирамиды с максимальным размером 31
        boolean success;
        theHeap.toss(70);
        theHeap.toss(40);
        theHeap.toss(50);
        theHeap.toss(20);
        theHeap.restoreHeap();

        theHeap.toss(60);
        theHeap.toss(100);
        theHeap.toss(80);
        theHeap.toss(30);
        theHeap.toss(10);
        theHeap.toss(90);
        theHeap.restoreHeap();

        theHeap.toss(5);
        theHeap.toss(45);
        theHeap.toss(15);
        theHeap.restoreHeap();

        while(true) // Пока пользователь не нажмет Ctrl+C
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove, change: ");
            int choice = getChar();
            switch(choice)
            {
                case 's': // Вывод
                        theHeap.displayHeap();
                    break;
                case 'i': // Вставка
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    success = theHeap.insert(value);
                    if( !success )
                        System.out.println("Can’t insert; heap full");
                    break;
                case 'r': // Удаление
                    if( !theHeap.isEmpty() )
                        theHeap.remove();
                    else
                        System.out.println("Can’t remove; heap empty");
                    break;
                case 'c': // Изменение приоритета
                    System.out.print("Enter current index of item: ");
                    value = getInt();
                    System.out.print("Enter new key: ");
                    value2 = getInt();
                    success = theHeap.change(value, value2);
                    if( !success )
                        System.out.println("Invalid index");
                    break;
                default:
                    System.out.println("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}
