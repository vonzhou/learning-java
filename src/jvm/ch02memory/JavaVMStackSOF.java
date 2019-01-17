package jvm.ch02memory;


/**
 * -Xss128k
 * 
 * 
 * stack length : 959
 Exception in thread "main" java.lang.StackOverflowError
 at com.vonzhou.learn.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:13)
 at com.vonzhou.learn.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:14)
 at com.vonzhou.learn.jvm.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:14)
 * 
 * 
 * @version 2018/2/7.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable a) {
            System.out.println("stack length : " + sof.stackLength);
            throw a;
        }
    }

}
