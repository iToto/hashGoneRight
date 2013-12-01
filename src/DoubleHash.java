public class DoubleHash{

	public void DoubleHash (){};

	private char emptyMarkerScheme=null;

	public void doubleHash(String s) {
		Hash h = new Hash();
        int key = h.hash(s);
        int hv1 = hv1(key);
        int hv2 = hv2(key);

        if ( h.table[hv1] == null)
        {
            h.put (s, hv1);
        }
        else
        {   
           h.put (s, collision(key, hv2));
        }
    }

    
    private int hv1(int i){
        return i % table.length;
    }

    
    private int hv2(int i){
        DoubleHashPrime prime = new DoubleHashPrime();
        int primeNum1 = prime.findPerfectPrime(table.length);
        int primeNum2 = prime.findPerfectPrime(primeNum1);
        int num = (primeNum2*i)%primeNum1;
        return num;
    }


    private int collision(int hv1, int hv2){
        int i = 0;
        int newIndex = 0;
        Hash h = new Hash();
        do{
            collisionCounter++;
            ++i;
            newIndex = (hv1+(i*hv2)) % h.table.length;
        }while(h.table[newIndex] != null && i < h.table.length);
        return newIndex;
    }

    private String setEmptyMarkerScheme(String type)
    {
    	this.emptyMarkerScheme = type;
    }




}