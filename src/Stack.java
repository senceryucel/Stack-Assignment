// Author : Sencer Yücel
// Section : 2
// Assignment : 1
// This class is Linked list implementation of Stacks.

public class Stack<Item> {

    private Node first = null;

    //Inner class to use stack's properties.
    private class Node{
        Item item;
        Node next;
    }

    //Method to control the stack whether it's empty or not.
    public boolean isEmpty(){
        return first == null;
    }

    //Method to push values inside stack
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }
    //Method to pop the value at the top from the stack
    public Item pop(){
        Item item = first.item;
        first = first.next;
        return item;
    }

}
