package readingbook.javaconcurrencyinpractice.vonzhou;

/**
 * long变量读写不是原子的，会分为2个字操作。
 * @author Jerry Lee(oldratlee at gmail dot com)
 */
public class InvalidLongDemo {
    long count = 0;

    public static void main(String[] args) {

        InvalidLongDemo demo = new InvalidLongDemo();

        Thread thread = new Thread(demo.getConcurrencyCheckTask());
        thread.start();

        for (int i = 0; ; i++) {// 无限次的修改这个count，高低32bit是一样的。
            long l = i;
            demo.count = l << 32 | l;
        }
    }

    ConcurrencyCheckTask getConcurrencyCheckTask() {
        return new ConcurrencyCheckTask();
    }

    private class ConcurrencyCheckTask implements Runnable {
        @Override
        public void run() {
            int c = 0;
            for (int i = 0; ; i++) {//无限次的检查高低字
                long l = count;//访问外部类的变量
                long high = l >>> 32;
                long low = l & 0xFFFFFFFFL; // 高32位为0
                if (high != low) {
                    c++;
                    System.err.printf("Fuck! Got invalid long!! check time=%s, happen time=%s(%s%%), count value=%s|%s\n",
                            i + 1, c, (float) c / (i + 1) * 100, high, low);
                } else {
                	// 如果去掉这个输出，则在我的开发机上没有观察到invalid long
                    System.out.printf("Emm... %s|%s\n", high, low);
                }
            }
        }
    }

}
