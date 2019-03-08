package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guigu.service.UserService;
import com.guigu.service.impl.UserServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PassWordModifyUi2 extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private UserService userService = new UserServiceImpl();

	/**
	 * Create the frame.
	 */
	public PassWordModifyUi2(String userName ,String password) {
		super("用户密码修改");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u786E\u8BA4\u65B0\u5BC6\u7801");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(167, 50, 128, 15);
		contentPane.add(label);
		
		JLabel label_password = new JLabel("\u518D\u6B21\u8F93\u5165\u65B0\u5BC6\u7801");
		label_password.setBounds(57, 125, 121, 15);
		contentPane.add(label_password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(167, 122, 177, 21);
		contentPane.add(passwordField);
		
		JButton savebutton = new JButton("\u786E\u8BA4");
		savebutton.setBounds(167, 195, 93, 23);
		contentPane.add(savebutton);
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainUi.jframe.setEnabled(true);
                MainUi.jframe.setVisible(true);
            }
        });
		savebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(password.toString());
				String newPassword = (new String(passwordField.getPassword())).trim();
				if(password.equals(newPassword)) {
					try {
						boolean result = userService.savePasswordUser(userName,password);
						if(result) {
							JOptionPane.showMessageDialog(null, "密码修改成功");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//修改用户密码
				}else {
					JOptionPane.showMessageDialog(null, "两次输入密码不一致");
				}
			}
		});
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new PassWordModifyUi2(null,null);
		
	}

}
