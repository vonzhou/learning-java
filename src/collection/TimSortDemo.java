package collection;

/**
 * Created by vonzhou on 16/9/2.
 */
public class TimSortDemo {
    public static int minRunLength(int n) {
        assert n >= 0;
        int r = 0;      // Becomes 1 if any 1 bits are shifted off
        while (n >= 32) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void main(String[] args) {
        for(int i=32; i<100; i+=1){
            System.out.print(minRunLength(i) + ",");
        }
    }
}
