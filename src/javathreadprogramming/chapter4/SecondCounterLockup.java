package javathreadprogramming.chapter4;

import java.awt.*;
import javax.swing.*;
import java.text.*;

public class SecondCounterLockup extends JComponent {
	private boolean keepRunning;
	private Font paintFont;
	private String timeMsg;
	private int arcLen;

	public SecondCounterLockup() {
		paintFont = new Font("SansSerif", Font.BOLD, 14);
		timeMsg = "never started";
		arcLen = 0;
	}

	public void runClock() {
		System.out.println("thread running runClock() is " +
				Thread.currentThread().getName());

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

	public void stopClock() {
		keepRunning = false;
	}

	public void paint(Graphics g) {
		System.out.println("thread that invoked paint() is " +
				Thread.currentThread().getName());

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
