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


	public void seperateChain(String s)
	{
		int key = this.hash(s);
		//System.out.println("Got " + key + " from hash.");
		// System.out.println("Got " + table.length + " as a table length.");
		key = key % this.table.length;
		//System.out.println("Got " + key + " from modding.");
        Node newNode = new Node(s,key);
		put (newNode, key);
	}

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
            // TODO Call double hash insrt with old[i] into table[]
        }
        old = null;
    }


    private int hash(String str)
    {
        int nHash=7;
        //System.out.println("----- Hashing string ! " + str + " -----");
        //System.out.println("----- with length: " + str.length() + " -----");
        
        for (int i=0; i < str.length(); i++)
        {
            nHash = Math.abs(nHash*31+str.charAt(i));
        }
        //System.out.println("----- Converted to: " + nHash + " -----");
        
        return nHash;
    }


}