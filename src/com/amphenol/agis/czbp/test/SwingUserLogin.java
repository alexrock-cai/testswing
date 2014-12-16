package com.amphenol.agis.czbp.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.*;

import com.amphenol.agis.czbp.util.SwingUtils;

public class SwingUserLogin extends JFrame implements ActionListener,ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6437605901395294313L;
	JPanel panel1,panel2;
	JLabel userType,userLabel,passwordLabel;
	JTextField userTextField;
	JPasswordField passwordTextField;
	JButton yesBtn,cancelBtn,exitBtn;
	JComboBox<String> userSelect;
	
	String[] user={"学生用户","老师用户","管理员用户"};
	Container c;
	int i=0;
	
	public  SwingUserLogin() {
		// TODO Auto-generated constructor stub
		super("用户登录");
		userType=new JLabel("用户类型", JLabel.CENTER);
		userSelect = new JComboBox<String>(user);
		userSelect.addItemListener(this);
		userLabel = new JLabel("用户名",JLabel.CENTER);
		passwordLabel = new JLabel("密码",JLabel.CENTER);
		userTextField = new JTextField(10);
		passwordTextField = new JPasswordField(10);
		yesBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		exitBtn = new JButton("Exit");
		
		yesBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		SwingUtils.enterPressesWhenFocused(userTextField, this);
		SwingUtils.enterPressesWhenFocused(passwordTextField, this);
		SwingUtils.enterPressesWhenFocused(yesBtn);
		SwingUtils.enterPressesWhenFocused(exitBtn);
		SwingUtils.enterPressesWhenFocused(cancelBtn);
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		panel2 = new JPanel();
		
		c = getContentPane();
		c.setLayout(new BorderLayout());
		panel1.add(userType);
		panel1.add(userSelect);
		panel1.add(userLabel);
		panel1.add(userTextField);
		panel1.add(passwordLabel);
		panel1.add(passwordTextField);
		c.add(panel1,BorderLayout.CENTER);
		panel2.add(yesBtn);
		panel2.add(cancelBtn);
		panel2.add(exitBtn);
		c.add(panel2,BorderLayout.SOUTH);
		
		//this.getRootPane().setDefaultButton(yesBtn);
		
		setBounds(300,300,300,160);
		setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		i=userSelect.getSelectedIndex();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==cancelBtn) {
			userTextField.setText("");
			passwordTextField.setText("");
			return;
		} else if (e.getSource()==exitBtn) {
			System.exit(0);
			
		} else {
			if(userTextField.getText().trim().equals("")){
				JOptionPane.showMessageDialog(null, "用户名不能为空");
				return;
			}
			if(new String(passwordTextField.getPassword()).trim().equals("")){
				JOptionPane.showMessageDialog(null, "密码不能为空");
				return;
			}
			switch(i){
			
			case 0:
				if(paserLogin("s","s")){
					JOptionPane.showMessageDialog(null, "学生用户登录成功");
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				break;
			case 1:
				if(paserLogin("t", "t")){
					JOptionPane.showMessageDialog(null, "老师用户登录成功");
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				break;
			case 2:
				if(paserLogin("admin", "admin")){
					JOptionPane.showMessageDialog(null, "管理员登录成功");
				}else {
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
				}
				break;
			default :
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
					
			}
		}
	}
	
	private boolean paserLogin(String password,String user) {
		return new String(passwordTextField.getPassword()).trim().equals(password) &&
				userTextField.getText().trim().equals(user);
	}
	
	

}
