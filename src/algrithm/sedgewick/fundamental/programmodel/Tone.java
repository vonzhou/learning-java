package algrithm.sedgewick.fundamental.programmodel;

/*************************************************************************
 *  Compilation:  javac Tone.java
 *  Execution:    java Tone hz seconds
 *  Dependencies: StdAudio.java
 *
 *  This program takes the frequency and duration from the command line,
 *  and plays a sine wave of the given frequency for the given duration.
 *
 *  % java Tone 440.0 1.5
 *
 *************************************************************************/

public class Tone {
    public static void main(String[] args) {
        double hz       = Double.parseDouble(args[0]);    // frequency in Hz
        double duration = Double.parseDouble(args[1]);    // duration in seconds

        int N = (int) (StdAudio.SAMPLE_RATE * duration);

        // build sine wave with desired frequency
        double[] a = new double[N+1];
        for (int i = 0; i <= N; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }

        // play using standard audio
        StdAudio.play(a);
    }
}
/*
 * 
 * java Tone 440.0 3.0
 * */
