import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


public class Main 
{

	private Scanner kb = new Scanner(System.in);
	private String algo="";
	private String file = "../hash_test_file1.txt";
	public String collisionHandlingType="";
	private boolean loop=false;

	public void main (String[] args) 
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
							   "For Double-Hashing type '1', \n" +
							   " for Seperate-Chaining type '2'. \n" +
							   "Algorithm Slection: ");
			}
			
			algo = kb.nextLine();
		}while(algo!="D" || algo!="S");

		loadFile(file);

		if (algo == "D")
		{
			setCollisionHandlingType(algo);
			doDoubleHashing();
		}
		else if( algo == "S")
		{
			setCollisionHandlingType(algo);
			doSeperateChain();
		}		
		
	}

	private void setCollisionHandlingType(String k)
	{
		collisionHandlingType = k;
	}

	private void loadFile (String file)
	{
		// here is where you take the file and put it into memory, or a giant table/array
		// maybe not.... wil it be betteR? is it worth the extra work?
	}

	private void doDoubleHashing ()
	{
		DoubleHash dh = new DoubleHash();
		System.out.println("What kind of empty marker scheme would you like to use: \n" +
	                       "Available = 'A', \n" +
	                       "Negative = 'N', \n" +
	                       "Replace = 'R'. \n" +
	                       "Selection: ");
        dh.setEmptyMarkerScheme(kb.nextLine());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line=null;

        while( (line=br.readLine()) != null) 
        {
        	dh.doubleHash(line);
        }
	}

	private void doSeperateChain ()
	{
		SeperateChain sc = new SeperateChain();
		BufferedReader br = new BufferedReader(new FileReader(file));
        String line=null;

        while( (line=br.readLine()) != null) 
        {
        	sc.seperateChain(line);
        }
		// do whats necesary for Seperate Chaining
		//at some point you're going to call hash() in here or do it in the class?
	}

	private void printHashtableStatistics()
	{
		Hash h = new Hash();
		DoubleHash dh = new DoubleHash();


		//just output all the statistics.
		System.out.print("The hash table uses ");
        if (algo == "S")
            System.out.print("separate chaining.");
        else
            System.out.print("double hashing open addressing scheme.\n");

        System.out.println ("\nThe empty marker scheme is ");

        if (dh.emptyMarkerScheme == "R")
            System.out.print ("removing the duplicate index");
        else if (dh.emptyMarkerScheme == "N")
            System.out.print ("using negative value of removed key as empty marker.");
        else if (dh.emptyMarkerScheme =="A")
            System.out.print ("using AVAILABLE as empty marker.\n");

        System.out.print("\nThe hash table is expanding by ");

        if (h.expandByFactor)
            System.out.print("a factor of " + h.EXPAND_FACTOR_VARIABLE);
        else
            System.out.print("a constant number of " + h.EXPAND_BY_NUMBER_VARIABLE + " elements");
        
        System.out.print(" when a load factor of " + h.LOAD_FACTOR + " is reached." );
	}

}