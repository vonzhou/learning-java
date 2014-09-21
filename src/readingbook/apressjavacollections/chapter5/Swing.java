package readingbook.apressjavacollections.chapter5;

import javax.swing.*;
import java.awt.*;

public class Swing {
  public static void main (String args[]) {
    JFrame frame = new JFrame("UIDefaults Example");
    frame.setDefaultCloseOperation(3);
    Container c = frame.getContentPane();
    UIManager.put("Button.background", Color.red);
    UIManager.put("Button.foreground", Color.white);
    Font f = new Font("Serif", Font.ITALIC, 24);
    UIManager.put("Button.font", f);

    JButton north = new JButton ("North");
    JButton south = new JButton ("South");
    JButton east = new JButton ("East");
    JButton west = new JButton ("West");
    JButton center = new JButton ("Center");
    c.add(north, BorderLayout.NORTH);
    c.add(south, BorderLayout.SOUTH);
    c.add(east, BorderLayout.EAST);
    c.add(west, BorderLayout.WEST);
    c.add(center, BorderLayout.CENTER);
    frame.pack();
    frame.show();
  }
}