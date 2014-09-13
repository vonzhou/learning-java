package javathreadprogramming.chapter4;
import java.awt.*;
import javax.swing.*;
import java.text.*;

public class SecondCounterRunnable extends JComponent implements Runnable {
	private volatile boolean keepRunning;
	private Font paintFont;
	private volatile String timeMsg;
	private volatile int arcLen;

	public SecondCounterRunnable() {
		paintFont = new Font("SansSerif", Font.BOLD, 14);
		timeMsg = "never started";
		arcLen = 0;
	}

	public void run() {
		runClock();
	}

	public void runClock() {
		DecimalFormat fmt = new DecimalFormat("0.000");
		long normalSleepTime = 100;

		int counter = 0;
		keepRunning = true;

		while ( keepRunning ) {
			try {
				Thread.sleep(normalSleepTime);
			} catch ( InterruptedException x ) {
				// ignore
			}

			counter++;
			double counterSecs = counter / 10.0;

			timeMsg = fmt.format(counterSecs);

			arcLen = ( ( ( int ) counterSecs ) % 60 ) * 360 / 60;
			repaint();
		}
	}

	// 在事件函数中调用，所以尽量做些简单的动作；
	public void stopClock() {
		keepRunning = false;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.setFont(paintFont);
		g.drawString(timeMsg, 0, 15);

		g.fillOval(0, 20, 100, 100);  // black border

		g.setColor(Color.white);
		g.fillOval(3, 23, 94, 94);  // white for unused portion

		g.setColor(Color.blue);  // blue for used portion
		g.fillArc(2, 22, 96, 96, 90, -arcLen);
	}
}
