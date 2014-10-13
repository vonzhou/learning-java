package algrithm.sedgewick.stack;

/**
 * 用单链表实现的泛型栈
 * 利用的是静态内部嵌套类作为链表节点
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;


public class Stack<T> implements Iterable<T> {
    private int N;                // size of the stack
    private Node<T> first;     // top of stack

    // helper linked list class
    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Stack() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void push(T item) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public T pop() {
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        T item = first.item;        // save item to return
        first = first.next;            // delete first node
        N--;
        return item;                   // return the saved item
    }


    /**
     * Returns (but does not remove) the item most recently added to this stack.
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public T peek() {
        if (isEmpty()) 
        	throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     * @return the sequence of items in the stack in LIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");
        return s.toString();
    }
       

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }
        public boolean hasNext()  { 
        	return current != null;                
        }
        public void remove()      { 
        	throw new UnsupportedOperationException();  
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next; 
            return item;
        }
    }


    /**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            
            if (!item.equals("-")) 
            	s.push(item);
            else if (!s.isEmpty())
            	StdOut.print(s.pop() + " ");
        }
        
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
