package com.amphenol.agis.czbp.test;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingTestFrame {
	public static void main( String[] args ){
		JFrame frame = new JFrame("DefaultButton");
		frame.setLayout( new FlowLayout() );
		final JTextField textField1 = new JTextField(10);
		final JTextField textField2 = new JTextField(10);
		JButton button = new JButton ("默认按钮,使下一个文本框获得焦点");
		button.addActionListener( new ActionListener(){
		public void actionPerformed( ActionEvent e){
		if( textField1.hasFocus() )
		textField2.requestFocusInWindow();
		else
		textField1.requestFocusInWindow();
		}
		});
		frame.add(button);
		frame.getRootPane().setDefaultButton(button);
		frame.add(textField1);
		frame.add(textField2);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setVisible(true);
		}
		
}
