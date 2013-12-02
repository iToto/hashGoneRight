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
	};

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
			// System.out.println("Collided");
           	this.put (s, collision(key, hv2));
        }
    }


    private int hv1(int i)
    {
    	// System.out.println("----- i! " + i + " -----");
    	// System.out.println("----- table length ! " + this.table.length + " -----");
    	// System.out.println("----- i mod ! " + i % this.table.length + " -----");
    	return i % this.table.length;
    }


    private int hv2(int i){
        DoubleHashPrime prime = new DoubleHashPrime();
        int primeNum1 = prime.findPerfectPrime(this.table.length);
        int primeNum2 = prime.findPerfectPrime(primeNum1);
        int num = (primeNum2*i)%primeNum1;
        return num;
    }


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

    public void setEmptyMarkerScheme(char type)
    {
    	this.emptyMarkerScheme = type;
    }


    private void put(String value, int key)
    {
    	// System.out.println("----- table * loadfactor ! " + this.table.length*loadFactor + " -----");
    	// System.out.println("----- elements in table  ! " + elementsInTable + " -----");


        if (elementsInTable+1 > this.table.length*loadFactor)
        {
            this.rehash();
        }
     //    System.out.println("----- I'm inserting here: "+key+" -----");
    	// System.out.println("----- table lenth ! " + this.table.length + " -----");
        this.table[key] = value;
        // System.out.println("----- Array index Post Insert ! " + this.table[key] + " -----");
        ++elementsInTable;
    }


    private void rehash ()
    {
    	int newSize;
    	if (expandByFactor)
    	{
    	// System.out.println("----- table lenth ! " + this.table.length + " -----");

    	    newSize = this.table.length*EXPAND_FACTOR_VARIABLE;

    	// System.out.println("----- NEW table lenth ! " + newSize + " -----");

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
            // TODO Call double hash insrt with old[i] into table[]
        }
        old = null;
    }


    private void setRehashFactor(int factorOrNumber)
    {
        rehashFactor = factorOrNumber;
    }

    private int hash(String str)
    {
        int nHash=7;
        // System.out.println("----- Hashing string ! " + str + " -----");
        // System.out.println("----- with length: " + str.length() + " -----");
        
        for (int i=0; i < str.length(); i++)
        {
            nHash = Math.abs(nHash*31+str.charAt(i));
        }
        // System.out.println("----- Converted to: " + nHash + " -----");
        
        return nHash;
    }



}