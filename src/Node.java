/*
	Alex D'Agostino - 6316417
	Assignment 3 - Hashing
	This program asks the user which hashing algorith they wish to use.
	it then uses a file of strings to show the speed of each algorithm.
*/


// class needed for linked list.
public class Node{

    public String value;
    public int key;
    public Node next;

    public Node(String value, int key)
    {
        this.value = value;
        this.key   = key;
        this.next  = null;
    }
}