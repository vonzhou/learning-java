package thinkinginjava.innerclasses;


// 这个地方用Eclipse找不到main，需要用命令显示指定class
public interface ClassInInterface {
  void howdy();
  
  class Test implements ClassInInterface {
    public void howdy() {
      System.out.println("Howdy!");
    }
    
    public static void main(String[] args) {
      new Test().howdy();
    }
  }
} 
