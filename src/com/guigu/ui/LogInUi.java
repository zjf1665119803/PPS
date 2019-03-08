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
    	   //��������
    	  JFrame frame = new JFrame("PPS������ϵͳ");
    	  //ʹ�þ��Զ�λ
    	  frame.setLayout(null);
    	  //�����û���������
    	  JLabel lable_user = new JLabel("�û���");
    	  JLabel lable_pass = new JLabel("��    ��");
    	  //�����û��������������
    	  JTextField userField = new JTextField();
    	  JPasswordField passField = new JPasswordField();
    	  //ָ��ȷ�Ϻ� ȡ��������ť
    	  JButton yesButton = new JButton("ȷ��");
    	  JButton exitButton = new JButton("ȡ��");
    	  //����λ��
    	  lable_user.setBounds(74, 54, 54, 15);
    	  lable_pass.setBounds(74, 107, 54, 15);
    	  userField.setBounds(123, 51, 218, 21);
    	  passField.setBounds(123, 104, 218, 20);
    	  yesButton.setBounds(100, 169, 93, 23);
    	  exitButton.setBounds(225, 169, 93, 23);
    	  //������������
    	  frame.add(lable_user);
    	  frame.add(lable_pass);
    	  frame.add(userField);
    	  frame.add(passField);
    	  frame.add(yesButton);
    	  frame.add(exitButton);
    	  //����������С
    	  frame.setBounds(100, 100, 450, 300);
    	  //���������ɼ�
    	  frame.setVisible(true);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
          //ȷ�ϼ�����¼�
    	  yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					//����û���������
					String userName = userField.getText().trim();
					String passWordCode = (new String(passField.getPassword()));
					StringBuffer sbf = new StringBuffer();
					//����¼�Ƿ�Ϸ�  ����ҵ���߼������
					User user = userService.logIn(userName,passWordCode,sbf);
					if(user == null) {
						JOptionPane.showMessageDialog(frame, sbf.toString(), "�����", JOptionPane.ERROR_MESSAGE);
					}
					else {
						//��ʾϵͳҳ��
						//System.out.println("��ҳ��");
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
    	  //�˳�������¼�
    	  exitButton.addActionListener(new ActionListener() {
  			
  			@Override
  			public void actionPerformed(ActionEvent e) {
  				
  				System.exit(0);
  			}
  		});
       
       
       }
       
}


















