package Lafore.head_11.StringHashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HashTableApp
{
    public static void main(String[] args) throws IOException
    {
        DataItem aDataItem;
        String aWord;
        int size;
        // Ввод размеров
        System.out.print("Enter size of hash table: ");
        size = getInt();
        // Создание таблицы
        HashTable theHashTable = new HashTable(size);

        while(true) // Взаимодействие с пользователем
        {
            System.out.print("Enter first letter of ");
            System.out.print("test, show, insert, delete, or find: ");
            char choice = getChar();
            switch(choice)
            {
                case 't':
                    aDataItem = new DataItem("cats");
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    aDataItem = new DataItem("dogs");
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    aDataItem = new DataItem("cat");
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    aDataItem = new DataItem("dog");
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    aDataItem = new DataItem("tree");
                    theHashTable.insert(aDataItem);
                    theHashTable.displayTable();
                    break;
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aWord = getString();
                    aDataItem = new DataItem(aWord);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aWord = getString();
                    theHashTable.delete(aWord);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aWord = getString();
                    aDataItem = theHashTable.find(aWord);
                    if(aDataItem != null)
                    {
                        System.out.println("Found " + aWord);
                    }
                    else
                        System.out.println("Could not find " + aWord);
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
