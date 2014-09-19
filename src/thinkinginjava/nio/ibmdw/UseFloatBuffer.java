package thinkinginjava.nio.ibmdw;

import java.nio.*;

/**
 * User: 智深
 * Date-Time: 2013-04-17
 */
public class UseFloatBuffer {
    static public void main(String args[]) throws Exception {
        // 创建FloatBuffer，容�?10,单位 float，也就是说创建的 buffer 放的�?10�? float
        FloatBuffer buffer = FloatBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity(); ++i) {
            float f = (float) Math.sin((((float) i) / 10) * (2 * Math.PI));
            buffer.put(f); // position ++
        }

        buffer.flip(); // position = 0

        while (buffer.hasRemaining()) {
            float f = buffer.get(); // position ++
            System.out.println(f);
        }
    }
}
