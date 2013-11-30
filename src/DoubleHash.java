public class DoubleHash{

	private void DoubleHash (){}


	public void doubleHash(InString s) {
        int key = s.hash() & 0x7fffffff;
        int hv1 = hv1(key);
        int hv2 = hv2(key);

        if ( table[hv1] == null)
        {
            insert (s, hv1);
        }
        else
        {   
            insert (s, collision(key, hv2));
        }
    }

    
    private  int hv1(int i){
        return i % table.length;
    }

    
    private  int hv2(int i){
        DoubleHashPrime prime = new DoubleHashPrime();
        int primeNum1 = prime.findPerfectPrime(table.length);
        int primeNum2 = prime.findPerfectPrime(primeNum1);
        int num = (primeNum2*i)%primeNum1;
        return num;
    }


    private int collision(int hv1, int hv2){
        int i = 0;
        int newIndex = 0;
        do{
            // System.out.println( i);
            collisionCounter++;
            ++i;
            newIndex = (hv1+(i*hv2)) % table.length;
        }while(table[newIndex] != null && i < table.length);
        return newIndex;
    }




}