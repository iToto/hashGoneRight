/*
	Alex D'Agostino - 6316417
	Assignment 3 - Hashing
	This program asks the user which hashing algorith they wish to use.
	it then uses a file of strings to show the speed of each algorithm.
*/
import java.lang.Math;
public class SeperateChain
{

	public Node[] table;
    private int rehashFactor=1;
    public int elementsInTable=0;
    public boolean expandByFactor=true;
    public final int EXPAND_FACTOR_VARIABLE=2;
    public final int EXPAND_BY_NUMBER_VARIABLE=100;
    public double loadFactor=.51;
    public int collisionCounter=0;

	public SeperateChain()
	{
		this.table = new Node[100];
	}



	// initiates seperate chaining algorithm.
	public void seperateChain(String s)
	{
		int key = this.hash(s);
		key = key % this.table.length;
        Node newNode = new Node(s,key);
		put (newNode, key);
	}



	// inserts the string into the appropriate key of the hashtable
	// if collision occurs, we make a linked listat that key and
	// insert into that list.
	private void put(Node value, int key)
    {

        if (elementsInTable+1 > table.length*loadFactor)
        {
            rehash();
        }

     	if (this.table[key] == null)
        {
            this.table[key] = value;
        }
        else
        {
        	++collisionCounter;
            Node currentNode = this.table[key];
            while(currentNode.next != null)
            {
                currentNode = currentNode.next;
            }
            currentNode.next = value;
        }
        ++elementsInTable;
    }



    // makes a new, bigger array and rehashes all elemens into the new array
    private void rehash ()
    {
    	int newSize;
    	if (expandByFactor)
    	{
    	    newSize = this.table.length*EXPAND_FACTOR_VARIABLE;
    	}
    	else
    	{
    	    newSize = this.table.length+EXPAND_BY_NUMBER_VARIABLE;
    	}
    	collisionCounter = 0;
        Node old[] = this.table;
        this.table = new Node[newSize];
        for (int i = 0; i < old.length; ++i)
        {
        	if (old[i] != null)
        	{
        		this.seperateChain(old[i].value);
        	}
        }
        old = null;
    }



    // gives a string a number to be used as a hash key
    private int hash(String str)
    {
        int nHash=7;
        for (int i=0; i < str.length(); i++)
        {
            nHash = Math.abs(nHash*31+str.charAt(i));
        }
        return nHash;
    }


}