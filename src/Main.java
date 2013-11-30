import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Main 
{

	private Scanner kb = new Scanner(System.in);
	private String algo="";
	private boolean loop=false;
	private String file = "../hash_test_file1.txt"
	private Table 

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
		}while(algo!='D' || algo!='S');

		loadFile(file);

		if (algo == 'D')
		{
			doDoubleHash();
		}
		else
		{
			doSeperateChain();
		}

		
		
	}

	private void loadFile (String file)
	{
		// here is where you take the file and put it into memory, or a giant table/array
		// maybe not.... wil it be betteR? is it worth the extra work?
	}

	private void doDoubleHashing ()
	{
		// do whats necesary for doublehashing
		//at some point you're going to call hash() in here or do it in the class?
	}

	private doSeperateChain ()
	{
		// do whats necesary for doublehashing
		//at some point you're going to call hash() in here or do it in the class?
	}

	private printHashtableStatistics()
	{
		//just output all the statistics.
		System.out.print("The hash table uses ");
        if (algo == 1)
            System.out.print(" separate chaining.");
        else
            System.out.print(" double hashing open addressing scheme.");
        System.out.println (" The empty marker scheme is ");
        if (markerScheme == 'R')
            System.out.print ("removing the duplicate index");
        else if (markerScheme == 'N')
            System.out.print ("using negative value of removed key as empty marker.");
        else if (markerScheme =='A')
            System.out.print ("using A as empty marker.");
        System.out.print(" The hash table is expanding by ");
        if (expandByFactor == true)
            System.out.print("a factor of " + expansionCoefficient);
        else
            System.out.print("a constant number of " + expansionLength + " elements");
        System.out.print(" when a load factor of " + loadFactor + " is reached." );
	}

}