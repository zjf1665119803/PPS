package com.guigu.ui;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.service.impl.UserServiceImpl;


public class LogInUi {
	
	 private static UserService userService = new UserServiceImpl();
       public static void main(String[] args) {
    	   //创建容器
    	  JFrame frame = new JFrame("PPS进销存系统");
    	  //使用绝对定位
    	  frame.setLayout(null);
    	  //创建用户名、密码
    	  JLabel lable_user = new JLabel("用户名");
    	  JLabel lable_pass = new JLabel("密    码");
    	  //创建用户名及密码输入框
    	  JTextField userField = new JTextField();
    	  JPasswordField passField = new JPasswordField();
    	  //指定确认和 取消两个按钮
    	  JButton yesButton = new JButton("确认");
    	  JButton exitButton = new JButton("取消");
    	  //设置位置
    	  lable_user.setBounds(74, 54, 54, 15);
    	  lable_pass.setBounds(74, 107, 54, 15);
    	  userField.setBounds(123, 51, 218, 21);
    	  passField.setBounds(123, 104, 218, 20);
    	  yesButton.setBounds(100, 169, 93, 23);
    	  exitButton.setBounds(225, 169, 93, 23);
    	  //添加组件到容器
    	  frame.add(lable_user);
    	  frame.add(lable_pass);
    	  frame.add(userField);
    	  frame.add(passField);
    	  frame.add(yesButton);
    	  frame.add(exitButton);
    	  //设置容器大小
    	  frame.setBounds(100, 100, 450, 300);
    	  //设置容器可见
    	  frame.setVisible(true);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
          //确认键添加事件
    	  yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					//获得用户名和密码
					String userName = userField.getText().trim();
					String passWordCode = (new String(passField.getPassword()));
					StringBuffer sbf = new StringBuffer();
					//检查登录是否合法  建立业务逻辑层对象
					User user = userService.logIn(userName,passWordCode,sbf);
					if(user == null) {
						JOptionPane.showMessageDialog(frame, sbf.toString(), "错误框", JOptionPane.ERROR_MESSAGE);
					}
					else {
						//显示系统页面
						//System.out.println("主页面");
						MainUi mainUi = new MainUi();
						mainUi.init(user);
						frame.setVisible(false);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
    	  //退出键添加事件
    	  exitButton.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				
  				System.exit(0);
  			}
  		});
       
       
       }
       
}


















