package algrithm.sedgewick.strings;

public class Count {
    public static void main(String[] args) {
        Alphabet alpha = new Alphabet("abc");
        int R = alpha.R();
        int[] count = new int[R];
        String a = "abcccccccccccaaaaaaaaaaaaaabbbbbbbbasfsdafasdfasdf";
        int N = a.length();
        //依次处理数据集中的每个字符，判断是否存在，存在的话利用字符索引来进行统计
        for (int i = 0; i < N; i++)
            if (alpha.contains(a.charAt(i)))
                count[alpha.toIndex(a.charAt(i))]++;
        for (int c = 0; c < R; c++)
            System.out.println(alpha.toChar(c) + " " + count[c]);
    }
}
