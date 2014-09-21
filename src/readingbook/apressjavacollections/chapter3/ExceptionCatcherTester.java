package readingbook.apressjavacollections.chapter3;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExceptionCatcherTester {
  public ExceptionCatcherTester() {
    JFrame f = new JFrame("Exception Catcher Tester");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    final JTextArea textArea = new JTextArea();
    textArea.setEditable(false);

    JButton button = new JButton("Alive");
    ActionListener buttonListener = new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("I'm Alive");
      }
    };
    button.addActionListener(buttonListener);

    final JTextField textField = new JTextField();
    ActionListener textFieldListener = new ActionListener() {
      public void actionPerformed(final ActionEvent e) {
        // Code to load URL contents in separate thread
        Runnable r = new Runnable() {
          public void run() {
            textField.setEditable(false);
            String urlString = e.getActionCommand();
            try {
              System.out.println("Loading " + urlString);
              textArea.setText("");
              URL url = new URL(urlString);
              InputStream is = url.openStream();
              InputStreamReader isr = new InputStreamReader(is);
              BufferedReader br = new BufferedReader(isr);
              StringWriter sw = new StringWriter();
              char buf[] = new char[1024];
              int count;
              while ((count = br.read(buf, 0, 1024)) != -1) {
                sw.write(buf, 0, count);
              }
              System.out.println("Done Loading");
              updateTextArea(textArea, sw.toString());
            } catch (IOException e) {
            	// 说明url非法，无法加载页面
              throw new ThreadException(this, e);
            } finally {
              textField.setEditable(true);
            }
          }
        };
        
        ExceptionCatcherThread runner = new ExceptionCatcherThread(r);

        // Listener in case of exception
        ThreadListener threadListener = new ThreadListener() {
          public void exceptionHappened(ThreadException e) {
            Throwable t = e.getSourceException();
            final String message = t.getClass().getName() + ": " + t.getMessage();
            Runnable r = new Runnable() {
              public void run() {
                JOptionPane.showMessageDialog(null, message);
              }
            };
            SwingUtilities.invokeLater(r);
          }
        };
        // 
        runner.addThreadExceptionListener(threadListener);

        runner.start();
      }
    };
    textField.addActionListener(textFieldListener);
    Container c = f.getContentPane();
    c.add(textField, BorderLayout.NORTH);
    JScrollPane pane = new JScrollPane (textArea);
    c.add(pane, BorderLayout.CENTER);
    c.add(button, BorderLayout.SOUTH);
    f.setSize(300, 300);
    f.show();
  }
  public void updateTextArea(final JTextArea ta, final String text) {
    // Because file loading happening not blocking event thread
    // We have to set text area in event thread
    Runnable r = new Runnable() {
      public void run() {
        ta.setText(text);
        ta.setCaretPosition(0);
      }
    };
    SwingUtilities.invokeLater(r);
  }
  public static void main(String args[]) {
    new ExceptionCatcherTester();
  }
}