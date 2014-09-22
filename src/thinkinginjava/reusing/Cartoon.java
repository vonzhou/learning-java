package thinkinginjava.reusing;
// Constructor calls during inheritance.
import static thinkinginjava.util.Print.*;

class Art {
  Art() { print("Art constructor"); }
}

class Drawing extends Art {
  Drawing() { print("Drawing constructor"); }
}

public class Cartoon extends Drawing {
  public Cartoon() { print("Cartoon constructor"); }
  public Cartoon(String name) { print("Cartoon constructor " + name); }
  
  public static void main(String[] args) {
    Cartoon x = new Cartoon();
    Cartoon y = new Cartoon("vonzhou");
  }
} 
