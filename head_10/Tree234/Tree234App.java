package Lafore.head_10.Tree234;

import java.io.*;
import java.util.Arrays;

class Tree234App
{
    public static void main(String[] args) throws IOException
    {
        long value;
        Tree234 theTree = new Tree234();

        while(true)
        {
            System.out.print("Enter first letter of ");
            System.out.print("Show, sort, insert, find, minimal, traversal or create: ");
            char choice = getChar();
            switch(choice)
            {
                case 'S':
                    theTree.displayTree();
                    break;
                case 's':
                    System.out.print("Enter length array: ");
                    value = getInt();
                    long[] arrayLong = new long[(int) value];
                    System.out.println("Enter array: ");
                    for (int i = 0; i < value; i++){
                        arrayLong[i] = getInt();
                    }
                    System.out.println(Arrays.toString(arrayLong));
                    System.out.println(Arrays.toString(theTree.sort(arrayLong)));
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if(found != -1)
                        System.out.println("Found "+value);
                    else
                        System.out.println("Could not find "+value);
                    break;
                case 'm':
                    long minElem = theTree.findMinimum();
                    System.out.println("Minimum is " + minElem);
                case 't':
                    theTree.symmetricTraversal();
                case 'c':
                    theTree.insert(50);
                    theTree.insert(40);
                    theTree.insert(60);
                    theTree.insert(30);
                    theTree.insert(70);
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
