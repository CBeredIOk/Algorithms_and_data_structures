package Lafore.head_11.ConvolutionHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        boolean bool = true;

        // Ввод размеров
        System.out.print("Enter size of hash table: ");
        size = HashTable.getPrime(getInt());

        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;

        // Создание таблицы
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++) // Вставка данных
        {
            aKey = (int)(Math.random() * keysPerCell * size);
            aDataItem = new DataItem(aKey);
            theHashTable.insert(aDataItem);
        }

        while(bool) // Взаимодействие с пользователем
        {
            System.out.print("Enter first letter of ");
            System.out.print("test, show, insert, delete, find or exit: ");
            char choice = getChar();
            switch(choice)
            {
                case 't':
                    aDataItem = new DataItem(19);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(38);
                    theHashTable.displayTable();
                    theHashTable.insert(aDataItem);

                    aDataItem = new DataItem(57);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(76);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(95);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(114);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    aDataItem = theHashTable.find(114);
                    System.out.println("\tFound " + aDataItem.getKey());
                    theHashTable.delete(114);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(20);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(39);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();

                    aDataItem = new DataItem(58);
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
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
                case 'e':
                    bool = false;
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
