[主页](http://vonzhou.com)  | [读书](https://github.com/vonzhou/readings)  | [知乎](https://www.zhihu.com/people/vonzhou) | [GitHub](https://github.com/vonzhou)
---
# Java字节码工具AsmTools介绍
---


AsmTools是一款字节码生成工具。 包括的组件：

* jasm：由JASM格式得到class文件
* jdis：把class文件转为JASM格式
* jcoder：由JCOD格式得到class文件
* jdec：把class文件转为JCOD格式


两种汇编器/反汇编器（assembler/disassemblers）对应的格式有啥区别？


> JASM specifically focuses on representing byte-code instructions in the VM format (while providing minimal description of the structure of  the rest of the class file).  Generally, JASM is more convenient for semantic changes, like change to instruction flow.

> JCOD provides good support for describing the structure of a class file (as well as writing incorrect bytes outside of this structure), and provides no support for specifying byte-code instructions (simply raw bytes for instructions).   JCOD is typically used for VMs to test Well-formedness of class files (eg extra or missing bytes), boundary issues, constant-pool coherence, constant-pool index coherence, attribute well-formedness, etc..

`

JASM比较贴近原始的字节码，和通过javap生成的字节码差不多，修改指令的语义也比较容易。
JCOD更好的描述了class文件的结构信息。

接下来通过一个简单类直观感受下。

## 使用asmtools汇编/反汇编

class文件转为JASM格式：

```java
D:\dev\asmtools-7.0-build>javac Hello.java

D:\dev\asmtools-7.0-build>java -jar asmtools.jar jdis Hello.class

super public class Hello
        version 52:0
{


public Method "<init>":"()V"
        stack 1 locals 1
{
                aload_0;
                invokespecial   Method java/lang/Object."<init>":"()V";
                return;
}

public static Method main:"([Ljava/lang/String;)V"
        stack 2 locals 1
{
                getstatic       Field java/lang/System.out:"Ljava/io/PrintStream;";
                ldc     String "Hello";
                invokevirtual   Method java/io/PrintStream.println:"(Ljava/lang/String;)V";
                return;
}

} // end Class Hello

```

使用javap得到的反汇编结果：


```java
D:\dev\asmtools-7.0-build>javap -c Hello.class
Compiled from "Hello.java"
public class Hello {
  public Hello();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #3                  // String Hello
       5: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: return
}
```

class文件转为JCOD格式：

```java
D:\dev\asmtools-7.0-build>java -jar asmtools.jar jdec Hello.class
class Hello {
  0xCAFEBABE;
  0; // minor version
  52; // version
  [] { // Constant Pool
    ; // first element is empty
    Method #6 #15; // #1
    Field #16 #17; // #2
    String #18; // #3
    Method #19 #20; // #4
    class #18; // #5
    class #21; // #6
    Utf8 "<init>"; // #7
    Utf8 "()V"; // #8
    Utf8 "Code"; // #9
    Utf8 "LineNumberTable"; // #10
    Utf8 "main"; // #11
    Utf8 "([Ljava/lang/String;)V"; // #12
    Utf8 "SourceFile"; // #13
    Utf8 "Hello.java"; // #14
    NameAndType #7 #8; // #15
    class #22; // #16
    NameAndType #23 #24; // #17
    Utf8 "Hello"; // #18
    class #25; // #19
    NameAndType #26 #27; // #20
    Utf8 "java/lang/Object"; // #21
    Utf8 "java/lang/System"; // #22
    Utf8 "out"; // #23
    Utf8 "Ljava/io/PrintStream;"; // #24
    Utf8 "java/io/PrintStream"; // #25
    Utf8 "println"; // #26
    Utf8 "(Ljava/lang/String;)V"; // #27
  } // Constant Pool

  0x0021; // access
  #5;// this_cpx
  #6;// super_cpx

  [] { // Interfaces
  } // Interfaces

  [] { // fields
  } // fields

  [] { // methods
    { // Member
      0x0001; // access
      #7; // name_cpx
      #8; // sig_cpx
      [] { // Attributes
        Attr(#9) { // Code
          1; // max_stack
          1; // max_locals
          Bytes[]{
            0x2AB70001B1;
          }
          [] { // Traps
          } // end Traps
          [] { // Attributes
            Attr(#10) { // LineNumberTable
              [] { // LineNumberTable
                0  1;
              }
            } // end LineNumberTable
          } // Attributes
        } // end Code
      } // Attributes
    } // Member
    ;
    { // Member
      0x0009; // access
      #11; // name_cpx
      #12; // sig_cpx
      [] { // Attributes
        Attr(#9) { // Code
          2; // max_stack
          1; // max_locals
          Bytes[]{
            0xB200021203B60004;
            0xB1;
          }
          [] { // Traps
          } // end Traps
          [] { // Attributes
            Attr(#10) { // LineNumberTable
              [] { // LineNumberTable
                0  3;
                8  4;
              }
            } // end LineNumberTable
          } // Attributes
        } // end Code
      } // Attributes
    } // Member
  } // methods

  [] { // Attributes
    Attr(#13) { // SourceFile
      #14;
    } // end SourceFile
  } // Attributes
} // end class Hello
```

从jasm，jcod格式生成class文件：

```
D:\dev\asmtools-7.0-build>java -jar asmtools.jar jcoder Hello.jcod

D:\dev\asmtools-7.0-build>java -jar asmtools.jar jcoder Hello.jcod

D:\dev\asmtools-7.0-build>java Hello
Hello

D:\dev\asmtools-7.0-build>
```


## 修改字节码

接下来展示一个使用asmtools修改字节码的例子。原始类：

```
public class Foo {
  static boolean bv;
  public static void main(String[] args) {
    bv = true;
    if (bv) {
      System.out.println("Hello, Java!");
    }
    if (bv == true){
      System.out.println("Hello, JVM!");
    } 
  }
}

```

运行后输出：

```
Hello, Java!
Hello, JVM!
```

对应的JASM格式反汇编内容：

```
super public class Foo
	version 52:0
{

static Field bv:Z;

public Method "<init>":"()V"
	stack 1 locals 1
{
		aload_0;
		invokespecial	Method java/lang/Object."<init>":"()V";
		return;
}

public static Method main:"([Ljava/lang/String;)V"
	stack 2 locals 1
{
		iconst_1;  # 入栈常量1
		putstatic	Field bv:"Z";
		getstatic	Field bv:"Z";
		ifeq	L18; 
		getstatic	Field java/lang/System.out:"Ljava/io/PrintStream;";
		ldc	String "Hello, Java!";
		invokevirtual	Method java/io/PrintStream.println:"(Ljava/lang/String;)V";
	L18:	stack_frame_type same;
		getstatic	Field bv:"Z";
		iconst_1;
		if_icmpne	L33;  # 比较
		getstatic	Field java/lang/System.out:"Ljava/io/PrintStream;";
		ldc	String "Hello, JVM!";
		invokevirtual	Method java/io/PrintStream.println:"(Ljava/lang/String;)V";
	L33:	stack_frame_type same;
		return;
}

} // end Class Foo
```

可以从中看到java中的true在字节码层面使用的int 1表示的。

如果修改下Foo.jasm。

```
super public class Foo
	version 52:0
{

static Field bv:Z;

public Method "<init>":"()V"
	stack 1 locals 1
{
		aload_0;
		invokespecial	Method java/lang/Object."<init>":"()V";
		return;
}

public static Method main:"([Ljava/lang/String;)V"
	stack 2 locals 1
{
		iconst_1;
		putstatic	Field bv:"Z";
		getstatic	Field bv:"Z";
		ifeq	L18;
		getstatic	Field java/lang/System.out:"Ljava/io/PrintStream;";
		ldc	String "Hello, Java!";
		invokevirtual	Method java/io/PrintStream.println:"(Ljava/lang/String;)V";
	L18:	stack_frame_type same;
		getstatic	Field bv:"Z";
		iconst_2;  # 修改了这里
		if_icmpne	L33;
		getstatic	Field java/lang/System.out:"Ljava/io/PrintStream;";
		ldc	String "Hello, JVM!";
		invokevirtual	Method java/io/PrintStream.println:"(Ljava/lang/String;)V";
	L33:	stack_frame_type same;
		return;
}

} // end Class Foo
```

把第二个iconst_1修改为iconst_2也就是把 1 和2比较，会得到下面的输出：

```
$ java -jar  asmtools.jar jasm Foo.jasm > Foo.class

$ java Foo
Hello, Java!
```



## 相关阅读

[Java Class文件结构分析](https://zhuanlan.zhihu.com/p/23068093)

[AsmTools](https://wiki.openjdk.java.net/display/CodeTools/asmtools)


