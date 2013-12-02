import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


public class DoProgram
{

    private Scanner kb;
    private char algo;
    private String file;
    public char collisionHandlingType;
    private boolean loop;
    Hash h = new Hash();


    public DoProgram()
    {
        kb = new Scanner(System.in);
        file = "../hash_test_file1.txt";
        loop=true;
    }


    public void doProgram()
    {
        do
        {
            if (loop)
            {
                System.out.println("Welcome to my Hashing program. " +
                               "\n For Double-Hashing type 'D'," +
                               " for Seperate-Chaining type 'S'. ");
                loop = !loop;
            }
            else
            {
                System.out.println("You've input something that is not either 'D' or 'S'. \n" +
                               "For Double-Hashing type 'D', \n" +
                               " for Seperate-Chaining type 'S'. \n" +
                               "Algorithm Slection: ");
            }

            algo = kb.next().charAt(0);

            System.out.println("you input: " + algo);

        }while(algo != 'D' && algo != 'S');

        //loadFile(file);

        if (algo == 'D')
        {
            setCollisionHandlingType(algo);
            doDoubleHashing();
        }
        else if( algo == 'S')
        {
            setCollisionHandlingType(algo);
            doSeperateChain();
        }

    }

    private void setCollisionHandlingType(char k)
    {
        collisionHandlingType = k;
    }

    private void doDoubleHashing ()
    {
        double start= 0;
        double end= 0;
        double time= 0;
        DoubleHash dh = new DoubleHash();
        System.out.println("What kind of empty marker scheme would you like to use: \n" +
                           "Available = 'A', \n" +
                           "Negative = 'N', \n" +
                           "Replace = 'R'. \n" +
                           "Selection: ");
        char set;
        set = kb.next().charAt(0);
        dh.setEmptyMarkerScheme(set);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
        }catch(FileNotFoundException e){
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
            return;
            //System.exit;
        }
        String line=null;

        try{
            float lines=0;
            line=br.readLine();
            start = System.nanoTime();
            while( line != null)
            {
                ++lines;
                //System.out.println("\n\n\n----- inserting THIS::: ! " + line + " -----");
                dh.doubleHash(line);
                //System.out.println("----- Insert Done for ::: ! " + line + " -----");
                line=br.readLine();
                System.out.println("%" + (lines/235886)*100 + " complete!");
                //System.out.println("----- Next line will be ::: ! " + line + " -----");
            }
            end = System.nanoTime();
        }catch(IOException e)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        time = (end - start)/1000000000;

        System.out.println("Got " + dh.collisionCounter + " collisions using Double Hashing." +
                            "Amount of time needed for Seperate-Chaining was: " + time + " seconds!");
        printHashtableStatisticsDH(dh);
    }



    private void doSeperateChain ()
    {
        double start = 0;
        double end = 0;
        double time = 0;
        SeperateChain sc = new SeperateChain();
        BufferedReader br = null;   
        try{
            br = new BufferedReader(new FileReader(file));
        }catch(FileNotFoundException e){
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
            return;
        }
        
        String line=null;

        try{
            line=br.readLine();
            start = System.nanoTime();
            while( line != null)
            {
                //System.out.println("\n\n\n----- inserting THIS::: ! " + line + " -----");
                sc.seperateChain(line);
                line=br.readLine();
            }
            end = System.nanoTime();
        }catch(IOException e)
        {
            System.err.println("Caught IOException: " + e.getMessage());
        }
        time = ( end - start ) / 1000000000;
        System.out.println("Got " + sc.collisionCounter + " collisions using Seperate-Chaining.\n" +
                            "Amount of time needed for Seperate-Chaining was: " + time + " seconds!");
        printHashtableStatisticsSC(sc);
    }



    public void printHashtableStatisticsDH(DoubleHash dh)
    {
        System.out.print("The hash table uses ");
        if (algo == 'S')
        {
            System.out.print("separate chaining.");
        }
        else
        {
            System.out.print("double hashing open addressing scheme.\n");
        }
        
        System.out.print("\nThe hash table is expanding by ");
        
        if (dh.expandByFactor)
        {
            System.out.print("a factor of " + dh.EXPAND_FACTOR_VARIABLE);
        }
        else
        {
            System.out.print("a constant number of " + dh.EXPAND_BY_NUMBER_VARIABLE + " elements");
        }

        System.out.print(" when a load factor of " + dh.loadFactor + " is reached." );
    }



    public void printHashtableStatisticsSC(SeperateChain sc)
    {
        System.out.print("The hash table uses ");
        if (algo == 'S')
        {
            System.out.print("separate chaining.");
        }
        else
        {
            System.out.print("double hashing open addressing scheme.\n");
        }
        
        System.out.print("\nThe hash table is expanding by ");
        
        if (sc.expandByFactor)
        {
            System.out.print("a factor of " + sc.EXPAND_FACTOR_VARIABLE);
        }
        else
        {
            System.out.print("a constant number of " + sc.EXPAND_BY_NUMBER_VARIABLE + " elements");
        }

        System.out.print(" when a load factor of " + sc.loadFactor + " is reached." );
    }






}