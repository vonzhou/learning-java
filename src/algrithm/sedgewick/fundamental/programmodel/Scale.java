package algrithm.sedgewick.fundamental.programmodel;

/*************************************************************************
 *  Compilation:  javac Scale.java
 *  Execution:    java Scale filename w h
 *  Data files:   http://www.cs.princeton.edu/introcs/31datatype/mandrill.jpg
 *
 *  Scales an image to w-by-h and displays both the original
 *  and the scaled version to the screen.
 * 
 *  % java Scale mandrill.jpg 200 300
 *
 *
 *************************************************************************/

import java.awt.Color;

public class Scale {
    public static void main(String[] args) {
        String filename = args[0];
        int w = Integer.parseInt(args[1]);
        int h = Integer.parseInt(args[2]);
        Picture source = new Picture(filename);
        Picture target = new Picture(w, h);
        // StdOut.println("Source image: " + source.width() + "-by-" + source.height());

        for (int ti = 0; ti < w; ti++) {
            for (int tj = 0; tj < h; tj++) {
                int si = ti * source.width()  / w;
                int sj = tj * source.height() / h;
                Color color = source.get(si, sj);
                target.set(ti, tj, color);
            }
        }

        source.show();
        target.show();
    }
}

/**
 *  java Scale mandrill.jpg 200 200
 */



