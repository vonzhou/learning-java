package jvm.chapter3;

/**
 * P67
 * @version 2018/2/8.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 第一次成功拯救了自己
        SAVE_HOOK = null;
        System.gc();
        // finalize 方法优先级较低，等待他运行
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("i am dead:)");
        }

        // 和上面一样，但此次拯救失败，因为每个对象的finalize方法只会被系统自动调用一次
        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("i am dead:)");
        }

    }
}
