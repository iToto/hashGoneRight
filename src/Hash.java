public class Hash{
	
	private int nHash;
	private int rehashFactor=1;
	private int elementsInTable=97;
	private double table[elementsInTable];
	private boolean expandByFactor=true;
	public final int EXPAND_FACTOR_VARIABLE=2;
	public final int EXPAND_BY_NUMBER_VARIABLE=100;
	public final int LOAD_FACTOR=.8;

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
		if (elementsInTable+1 > table.length*loadFactor) 
		{
            if (expandByFactor)
                this.table = resizeArray(this.table, (int)(this.table.length*EXPAND_FACTOR_VARIABLE));
            else
                this.table = resizeArray(this.table, this.table.length+EXPAND_BY_NUMBER_VARIABLE);
        }
        if (key == 0)
        {
            if ( get.collisionHandlingType == 'S' )
            {
                if (this.table[key] == null)
                {
		            this.table[key] = ;
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
        }
        else
            put (value, (h.hash % table.length);
        }
	}


	private void setRehashThreshold(int loadFactor)
	{

	}


	private void setRehashFactor(int factorOrNumber)
	{
		rehashFactor = factorOrNumber;
	}

	private void rehash (int size)
	{
		double temp[] = table;
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