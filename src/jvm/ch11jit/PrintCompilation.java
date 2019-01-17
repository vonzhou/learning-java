package jvm.ch11jit;

/**
 * P340
 * 查看即时编译的结果
 * <p>
 * 1. -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 * <p>
 * 2. -XX:+UnlockDiagnosticVMOptions -XX:+PrintOptoAssembly
 * Error: VM option 'PrintOptoAssembly' is notproduct and is available only in debug version of VM.
 * <p>
 * -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+PrintAssembly
 * Java HotSpot(TM) 64-Bit Server VM warning: PrintAssembly is enabled; turning on DebugNonSafepoints to gain additional output
 * Could not load hsdis-amd64.dylib; library not loadable; PrintAssembly is disabled
 * <p>
 * <p>
 * Created by vonzhou on 2018/2/25.
 */
public class PrintCompilation {
    public static final int NUM = 15000;

    public static int doubleValue(int n) {
        for (int j = 0; j < 100000; j++) ;
        return n * 2;
    }

    public static long calcSum() {
        long sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += doubleValue(i);
        }

        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calcSum();
        }
    }
}
