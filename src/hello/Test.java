package hello;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {
	public static void main(String[] args) {
		JFrame f=new JFrame("Hello Ant");
		JButton button=new JButton("A N T");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f=new JFrame("vonzhou");
				f.add(new JLabel("====================="));
				f.setBounds(300,300, 200, 100);
				f.setVisible(true);
			}
			
		});
		f.setBackground(new Color(100,200,200));
		f.setBounds(100, 200, 200, 250);
		f.getContentPane().add(button);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setAlwaysOnTop(true);
		f.setVisible(true);
	}

}
