public class Hash{
	
	private int nHash;
	private double table[97];
	private boolean expandByFactor=true;
	private final int EXPAND_FACTOR_VARIABLE=2;
	private final int EXPAND_BY_NUMBER_VARIABLE=100;
	private final int LOAD_FACTOR=1.2;

	private void Hash(){}

	public double hash(String str)
	{
		nHash=7;
		for (int i=0; i < strlen; i++) 
		{
    		this.nHash = this.nHash*31+str.charAt(i);
    	}
    	return this.nHash;
	}


	public void put(String value, double key)
	{
		Main get = new Main();
		Hash currentNode = null;
		//todo1: check state of table for resize
		if (elementsInTable+1 > table.length*loadFactor) 
		{
            if (expandByFactor)
                this.table = resizeArray(this.table, (int)(this.table.length*EXPAND_FACTOR_VARIABLE));
            else
                this.table = resizeArray(this.table, this.table.length+EXPAND_BY_NUMBER_VARIABLE);
        }
        //todo2: insert into table.
        if (key == 0)
        {
            if ( get.collisionHandlingType == 'S' ){
                //insert (s, (s.hash() & 0x7fffffff) % table.length);
                if (this.table[key] == null)
                {
		            this.table[key] = ;
		            // System.out.println( "inserted!!!  " +i);
		        }
		        else 
		        {
		            currentNode = this.table[i];
		            while (currentNode.next != null) 
		            {
		                currentNode = currentNode.next;
		            }
		            currentNode.next = s;
		        }
		        ++elementsInTable;
            }

            else if (get.collisionHandlingType == 'D')
                //System.out.println( "before doubleHash" );
                doubleHash(s);
            else
            {
            	throwException("did not establish a collision algorthm")
            }
        }
        else
            insert (s, (s.hash & 0x7fffffff) % table.length);
        }
	}


	private void setRehashThreshold(int loadFactor)
	{

	}


	private void setRehashFactor(int factorOrNumber)
	{

	}

	private void rehash (int size)
	{
		double temp[] = table;
		table = null;
		System.gc();
        Hash table = new Hash[size];
        for (int i = 0; i < temp.length; ++i) {
            if (table[i] != null)
                put (temp [i]);
        }
        temp = null;
	}


	private double[] resizeArray(Hash[] a, int newSize) {
        Hash[] newArray = new Hash[newSize];
        System.arraycopy(a, 0, newArray, 0, a.length );
        return newArray;
    }

}