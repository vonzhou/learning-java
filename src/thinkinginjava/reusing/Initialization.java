package thinkinginjava.reusing;


public class Initialization {
    public static void main(String[] args) {
           new B();
          new A.C();
   }
}

class A {
    private P p1 = new P("A--p1");
    static P p3 = new P("A--p3");

    public A() {
          System. out.println("A()" );
   }

    private P p2 = new P("A--p2");
    static {
           new P("A--static" );
   }
   {
           new P("A{...}" );
   }

    public static class C {
           private P p1 = new P("C--p1");
           static P p3 = new P("C--p3");

           public C() {
                 System. out.println("C()" );
          }

           private P p2 = new P("C--p2");
           static {
                  new P("C--static" );
          }
          {
                  new P("C{...}" );
          }
   }
}

class B extends A {
    private P p1 = new P("B --p1");
    static P p3 = new P("B -- p3");

    public B() {
          System. out.println("B()" );
   }

    public P p2 = new P("B -- p2");
    static {
           new P("B -- static" );
   }

   {
           new P("B{...}" );
   }
}

class P {
    public P(String s) {
          System. out.println(s);
   }
}
/*
* 输出结果
A--p3     //子类包括父类所有的静态、非静态变量
A--static
B -- p3
B -- static
A--p1
A--p2
A{...}
A()
B --p1
B -- p2
B{...}
B()
C--p3
C--static
C--p1
C--p2
C{...}
C()

有父类的情况
1. 加载父类
1.1 为静态属性分配存储空间并赋初始值
1.2 执行静态初始化块和静态初始化语句（从上至下）
2. 加载子类
2.1 为静态属性分配存储空间
2.2 执行静态初始化块和静态初始化语句（从上至下）
3. 加载父类构造器
3.1 为实例属性分配存数空间并赋初始值
3.2 执行实例初始化块和实例初始化语句
3.3 执行构造器内容
4. 加载子类构造器
4.1 为实例属性分配存数空间并赋初始值
4.2 执行实例初始化块和实例初始化语句
4.3 执行构造器内容
5  回到main()
内部类的加载过程也一样


static变量（包括静态块，按定义的先后顺序，只执行一次，只有第一个对象被创建的时候或者第一次访问静态数据的时候才会被初始化，初始化所有静态变量）
普通变量（按定义的先后顺序，属于对象，所以必须加载构造函数时才会加载初始化这部分，否则不初始化）
构造方法（实际上是静态方法）
类级内部类（静态内部类）只有在第一次使用的时候才会加载。
*/