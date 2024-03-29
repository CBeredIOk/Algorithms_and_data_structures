package Lafore.head_11.QuadraticProbing;

import java.io.*;

class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        // Ввод размеров
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        // Создание таблицы
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++) // Вставка данных
        {
            aKey = (int)(java.lang.Math.random() *
                    keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }
        while(true) // Взаимодействие с пользователем
        {
            System.out.print("Enter first letter of ");
            System.out.print("test, show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 't':
                    aDataItem = new DataItem(19);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(38);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(57);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(76);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(95);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(114);
                    theHashTable.insert(aDataItem);
                    aDataItem = theHashTable.find(114);
                    System.out.println("\tFound " + aDataItem.getKey());
                    theHashTable.delete(114);
                    aDataItem = new DataItem(20);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(39);
                    theHashTable.insert(aDataItem);
                    aDataItem = new DataItem(58);
                    theHashTable.insert(aDataItem);
                    break;
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                    {
                        System.out.println("Found " + aKey);
                    }
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
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
