/*
	Alex D'Agostino - 6316417
	Assignment 3 - Hashing
	This program asks the user which hashing algorith they wish to use.
	it then uses a file of strings to show the speed of each algorithm.
*/
import java.lang.Math;

public class DoubleHash{

	public int collisionCounter=0;
	public char emptyMarkerScheme;
	public String[] table;
    private int rehashFactor=1;
    public int elementsInTable=0;
    public boolean expandByFactor=true;    
    public final int EXPAND_FACTOR_VARIABLE=2;
    public final int EXPAND_BY_NUMBER_VARIABLE=100;
    public double loadFactor=.51;

	public DoubleHash ()
	{
		this.table = new String[100];
	}



	//initiates the doublehash algorithm. sets up all vriables needed
	public void doubleHash(String s) 
	{
        int key = this.hash(s);
        int hv1 = hv1(key);
        int hv2 = hv2(key);

        if ( this.table[hv1] == null)
        {
            this.put (s, hv1);
        }
        else
        {
           	this.put (s, collision(key, hv2));
        }
    }



    // creates first key for hash table
    private int hv1(int i)
    {
    	return i % this.table.length;
    }



    // hv2 is used if the first key got a collision.
    private int hv2(int i){
        DoubleHashPrime prime = new DoubleHashPrime();
        int primeNum1 = prime.findPerfectPrime(this.table.length);
        int primeNum2 = prime.findPerfectPrime(primeNum1);
        int num = (primeNum2*i)%primeNum1;
        return num;
    }



    // collision achieved, use second key, and then itirate through
    // until an open spot is achieved.
    private int collision(int hv1, int hv2)
    {
        int i = 0;
        int newIndex = 0;
        Hash h = new Hash();
        do{
            collisionCounter++;
            ++i;
            newIndex = (hv1+(i*hv2)) % this.table.length;
        }while(this.table[newIndex] != null && i < this.table.length);
        return newIndex;
    }



    // sets the empty marker scheme.
    public void setEmptyMarkerScheme(char type)
    {
    	this.emptyMarkerScheme = type;
    }



    // puts the string into the appropriate hashtable key location.
    private void put(String value, int key)
    {
    	if (elementsInTable+1 > this.table.length*loadFactor)
        {
            this.rehash();
        }
        this.table[key] = value;
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
        String old[] = this.table;
        this.table = new String[newSize];
        for (int i = 0; i < old.length; ++i)
        {
        	if(old[i] != null)
        	{
        		this.doubleHash(old[i]);
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