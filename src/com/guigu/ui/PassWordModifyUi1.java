package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.guigu.pojo.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PassWordModifyUi1 extends JFrame {
    
	private JPanel contentPane;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
    //ser user = new User();
    //PassWordModifyUi1 frame = new PassWordModifyUi1();

	/**
	 * Create the frame.
	 */
	public PassWordModifyUi1(User user) {
		super("用户密码修改");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel user_Label = new JLabel("\u7528\u6237\u767B\u5F55\u540D"+ "   "+user.getUserName());
		user_Label.setBounds(136, 28, 132, 15);
		contentPane.add(user_Label);
		
		JLabel label_oldPassword = new JLabel("\u8F93\u5165\u65E7\u5BC6\u7801");//老密码标签
		label_oldPassword.setBounds(102, 96, 76, 15);
		contentPane.add(label_oldPassword);
		
		JLabel label_newPassword = new JLabel("\u8F93\u5165\u65B0\u5BC6\u7801");//新密码标签
		label_newPassword.setBounds(102, 139, 76, 15);
		contentPane.add(label_newPassword);
		
		oldPasswordField = new JPasswordField();//老输入密码框
		oldPasswordField.setBounds(204, 93, 132, 21);
		contentPane.add(oldPasswordField);
		
		newPasswordField = new JPasswordField();//新输入密码框
		newPasswordField.setBounds(204, 136, 132, 21);
		contentPane.add(newPasswordField);
		
		JButton saveButton = new JButton("\u786E\u8BA4");
		saveButton.setBounds(97, 195, 93, 23);
		contentPane.add(saveButton);
		
		JButton exitButton = new JButton("\u9000\u51FA");
		exitButton.setBounds(243, 195, 93, 23);
		contentPane.add(exitButton);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainUi.jframe.setEnabled(true);
                MainUi.jframe.setVisible(true);
            }
        });
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PassWordModifyUi1.this.setVisible(false);
				//获得用户名和密码
				String oldpassword = (new String(oldPasswordField.getPassword())).trim();;
				String newpassword = (new String(newPasswordField.getPassword())).trim();
				if(oldpassword.equals(user.getPasswordCode())){
					//弹出密码修改第二个框
					new PassWordModifyUi2(user.getUserName(),newpassword);
				}else {
					JOptionPane.showMessageDialog(null, "旧密码输入不正确，请重新输入");
					PassWordModifyUi1.this.setVisible(true);//重新弹出修改界面1
				}
			}
			
		});
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PassWordModifyUi1.this.setVisible(false);
			}
		});
	}
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassWordModifyUi1 frame = new PassWordModifyUi1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		//new PassWordModifyUi1(null);
	}
}
