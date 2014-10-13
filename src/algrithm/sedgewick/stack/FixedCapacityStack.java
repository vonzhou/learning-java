package algrithm.sedgewick.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class FixedCapacityStack<T> implements Iterable<T> {
    private T[] a;    // holds the items
    private int N;       // number of items in stack

    // create an empty stack with given capacity
    public FixedCapacityStack(int capacity) {
        a = (T[]) new Object[capacity];   // 数组创建不支持泛型，所以用强制类型转换
    }

    public boolean isEmpty()          {  return (N == 0);                  }
    public void push(T item)       {  a[N++] = item;                    }
    public T pop()                 {  return a[--N];                    }
    public Iterator<T> iterator()  { return new ReverseArrayIterator(); }


    public class ReverseArrayIterator implements Iterator<T> {
        private int i = N-1;

        public boolean hasNext() { return i >= 0; }
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }
        public void remove()     { throw new UnsupportedOperationException(); }
    }


    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        FixedCapacityStack<String> stack = new FixedCapacityStack<String>(max);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            
            if (!item.equals("-")) 
            	stack.push(item); 
            else if (stack.isEmpty())  
            	StdOut.println("BAD INPUT"); 
            else                       
            	StdOut.print(stack.pop() + " ");
        }
        StdOut.println();

        // print what's left on the stack
        StdOut.print("Left on stack: ");
        for (String s : stack) {
            StdOut.print(s + " ");
        }
        StdOut.println();
    } 
} 
