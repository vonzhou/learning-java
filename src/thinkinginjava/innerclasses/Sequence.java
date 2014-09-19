package thinkinginjava.innerclasses;
//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector {
  boolean end();
  Object current();
  void next();
}	

public class Sequence {
  private Object[] items;
  private int next = 0;
  public Sequence(int size) { items = new Object[size]; }
  public void add(Object x) {
    if(next < items.length)
      items[next++] = x;
  }
  
  private class SequenceSelector implements Selector {
    private int i = 0;
    public boolean end() { return i == items.length; }
    public Object current() { return items[i]; }
    public void next() { if(i < items.length) i++; }
  }
  //内部类的灵活性
  private class SequenceReverseSelector implements Selector {
	    private int i = items.length - 1;
	    public boolean end() { return i == 0; }
	    public Object current() { return items[i]; }
	    public void next() { if(i >= 0) i--; }
	  }
  
  //
  public Selector selector() {
    return new SequenceSelector();
  }	
  
  public Selector reverseSelector() {
	    return new SequenceReverseSelector();
  }	
  
  public static void main(String[] args) {
    Sequence sequence = new Sequence(10);
    for(int i = 0; i < 10; i++)
      sequence.add(Integer.toString(i));
    Selector selector = sequence.selector();
    while(!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
    System.out.println();
    
    Selector selector2 = sequence.reverseSelector();
    while(!selector2.end()) {
      System.out.print(selector2.current() + " ");
      selector2.next();
    }
  }
}





