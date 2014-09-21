package readingbook.apressjavacollections.chapter3;

import java.util.Stack;
public class StackExample {
  public static void main (String args[]) {
	  
    Stack s = new Stack();
    s.push("Autumnal Tints");
    s.push("A Week on the Concord and Merrimack Rivers");
    s.push("The Maine Woods");
    // Check out what's next to read
    System.out.println("Next: " + s.peek()); 
    s.push("Civil Disobedience, Solitude and Life Without Principle");
    // Read a book
    System.out.println(s.pop());
    s.push("Walden");
    s.push("The Natural Man");
    // Find that other book
    int count = s.search("The Maine Woods");
    while (count != -1 && count > 1) {
      s.pop();
      count--;
    }
    // Read a book
    System.out.println(s.pop());
    // Anything left?
    System.out.println(s.empty());
  }
}