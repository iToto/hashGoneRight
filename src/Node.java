public class Node{

    public String value;
    public int key;
    public Node next;
    //public int length;

    public Node(String value, int key)
    {
        this.value = value;
        this.key   = key;
        this.next  = null;
        //this.length = value.length;
    }
}