package jvm.ch07loading;

/**
 * P211
 * 被动使用类演示1:通过子类引用父类的静态字段,不会导致子类的初始化.
 * <p>
 * 输出:
 * SuperClass init!
 * 123
 * <p>
 * -XX:+TraceClassLoading 的输出:
 * ......
 * [Loaded com.vonzhou.learn.jvm.ch07loading.SuperClass from file:/Users/vonzhou/Github/jvm-concourse/target/classes/]
 * [Loaded com.vonzhou.learn.jvm.ch07loading.SubClass from file:/Users/vonzhou/Github/jvm-concourse/target/classes/]
 * SuperClass init![Loaded java.net.SocketAddress from /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/rt.jar]
 * [Loaded java.net.InetSocketAddress from /Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/jre/lib/rt.jar]
 * <p>
 * 123
 * <p>
 * 可以看到子类加载了.
 * Created by vonzhou on 2018/2/20.
 */
public class NotInitialization1 {
    public static void main(String[] args) {
        System.out.println(SubClass.VAL);
    }
}
