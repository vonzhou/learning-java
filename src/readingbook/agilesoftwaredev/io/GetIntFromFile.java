package readingbook.agilesoftwaredev.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Created by vonzhou on 2018/9/22.
 */
//PushbackInputStream 学习实例
public class GetIntFromFile {

    public int getInt(PushbackInputStream input) {
        int c, res = 0;
        try {
            //跳过空白
            while ((c = input.read()) == ' ')
                ;
            //不是数字，不是+-符号
            if (!isDigit(c) && c != -1 && c != '+' && c != '-') {
                input.unread(c);
                return -1;  //读出的不是一个数字
            }

            int sign = (c == '-') ? -1 : 1; //符号
            if (c == '+' || c == '-')
                c = input.read();

            for (res = 0; isDigit(c); c = input.read())
                res = 10 * res + (c - '0');

            res *= sign;

            if (c != -1)
                input.unread(c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    private boolean isDigit(int c) {
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        PushbackInputStream input = new PushbackInputStream(new FileInputStream("/tmp/int.txt"), 1);
        System.out.println((new GetIntFromFile().getInt(input)));
    }
}
