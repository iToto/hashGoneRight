public class Hash{
	
	private void Hash(){}

	public double hash(String str)
	{
		// this is where we hash the string.
		// return the key.
	}


	public void put(double key)
	{
		//todo1: check state of table for resize
		//todo2: 
	}


	private void setRehashThreshold(int loadFactor)
	{

	}


	private void setRehashFactor(int factorOrNumber)
	{

	}

	private void rehash (int size)
	{
		InString[] temp = table;
        table = new InString[newSize];
        for (int i = 0; i < temp.length; ++i) {
            if (table[i] != null)
                put (temp [i]);
        }
        //delete temp;
	}

}