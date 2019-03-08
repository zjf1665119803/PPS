package com.guigu.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.guigu.pojo.SalesMan;
import com.guigu.service.SalesManService;
import com.guigu.service.UserService;
import com.guigu.service.impl.SalesManServiceImpl;
import com.guigu.service.impl.UserServiceImpl;

/**
 * 维护销售员工的操作界面2
 * 
 * @author ZJF
 *
 */
public class SalesManUi2 {
	
	SalesMan salesMan = new SalesMan();

	// 创建容器
	JFrame frame = new JFrame("销售员工资料");
	//创建productDataUi1的对象
	SalesManUi1 salesManUi1 = new SalesManUi1();
	//创建业务逻辑层对象
	private SalesManService salesManService = new SalesManServiceImpl();
	// 创建Jlabel

	JLabel label_salesManID = new JLabel("手工编号");
	JLabel label_chineseName = new JLabel("中文姓名");
	JLabel label_englishName = new JLabel("英文姓名");
	JLabel label_telephone = new JLabel("电话");
	JLabel label_contactAddress = new JLabel("联络地址");
	JLabel label_email = new JLabel("E-mail");
	JLabel label_mobilePhone = new JLabel("移动电话");

	// 创建JTextField
	JTextField salesManIDField = new JTextField();
	JTextField chineseNameField = new JTextField();
	JTextField englishNameField = new JTextField();
	JTextField telephoneField = new JTextField();
	JTextField contactAddressField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField mobilePhoneField = new JTextField();

	// 指定按钮
	JButton addButton = new JButton("新增");
	JButton returnButton = new JButton("取消");
	JButton saveButton = new JButton("保存");
	JButton deleteButton = new JButton("删除");
	JButton exitButton = new JButton("退出");


	public void init() {
		// 使用绝对定位
		frame.setLayout(null);
		// 设置位置
		label_salesManID.setBounds(30, 30, 75, 30);
		label_chineseName.setBounds(200, 30, 75, 30);
		label_englishName.setBounds(380, 30, 75, 30);
		label_telephone.setBounds(30, 70, 75, 30);
		label_contactAddress.setBounds(200, 120, 120, 15);
		label_email.setBounds(200, 75, 75, 30);
		label_mobilePhone.setBounds(30, 110, 75, 30);

		addButton.setBounds(120, 150, 75, 30);
		returnButton.setBounds(205, 150, 75, 30);
		saveButton.setBounds(290, 150, 75, 30);
		deleteButton.setBounds(375, 150, 75, 30);
		exitButton.setBounds(470, 150, 75, 30);

		salesManIDField.setBounds(85, 30, 105, 30);
		chineseNameField.setBounds(260, 30, 105, 30);
		englishNameField.setBounds(440, 30, 105, 30);
		telephoneField.setBounds(85, 70, 105, 30);
		contactAddressField.setBounds(260, 110, 285, 30);
		emailField.setBounds(260, 70, 105, 30);
		mobilePhoneField.setBounds(85, 110, 105, 30);

		// 添加组件到容器
		frame.add(label_salesManID);
		frame.add(label_chineseName);
		frame.add(label_englishName);
		frame.add(label_telephone);
		frame.add(label_contactAddress);
		frame.add(label_email);
		frame.add(label_mobilePhone);

		frame.add(exitButton);
		frame.add(deleteButton);
		frame.add(saveButton);
		frame.add(returnButton);
		frame.add(addButton);

		frame.add(mobilePhoneField);
		frame.add(emailField);
		frame.add(contactAddressField);
		frame.add(telephoneField);
		frame.add(englishNameField);
		frame.add(chineseNameField);
		frame.add(salesManIDField);

		// 设置容器大小
		frame.setBounds(100, 100, 600, 300);
		// 设置容器可见
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				salesManUi1.setEnabled(true);
				salesManUi1.setVisible(true);
			}
		});
		
		
		//为按钮添加事件
		//新增按钮
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//设置销售员资料1窗口不可用
				
			    try {
			    	//执行新增操作
			    	//获取添加信息
			    	salesMan.setSalesManID(salesManIDField.getText().trim());
			    	salesMan.setChineseName(chineseNameField.getText().trim());
			    	salesMan.setEnglishName(englishNameField.getText().trim());
			    	salesMan.setTelephone(telephoneField.getText().trim());
			    	salesMan.setEmail(emailField.getText().trim());
			    	salesMan.setMobilePhone(mobilePhoneField.getText().trim());
			    	salesMan.setContactAddress(contactAddressField.getText().trim());
			    	//System.out.println("执行到这");
					boolean result = salesManService.addSalesMan(salesMan);
					if(result) {
						salesManUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"添加成功");
					}
					salesManUi1.setEnabled(true);
					salesManUi1.repaint();
					frame.setVisible(false);
					salesManUi1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//取消按钮
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
		//保存按钮
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//设置销售员资料1窗口不可用
				  try {
				    	//执行新增操作
				    	//获取添加信息
				    	salesMan.setSalesManID(salesManIDField.getText().trim());
				    	salesMan.setChineseName(chineseNameField.getText().trim());
				    	salesMan.setEnglishName(englishNameField.getText().trim());
				    	salesMan.setTelephone(telephoneField.getText().trim());
				    	salesMan.setEmail(emailField.getText().trim());
				    	salesMan.setMobilePhone(mobilePhoneField.getText().trim());
				    	salesMan.setContactAddress(contactAddressField.getText().trim());
				    	//System.out.println("执行到这");
						boolean result = salesManService.saveSalesMan(salesMan);
						if(result) {
							salesManUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"保存成功");
						}
						salesManUi1.setEnabled(true);
						salesManUi1.repaint();
						frame.setVisible(false);
						salesManUi1.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		//删除按钮
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//设置销售员资料1窗口不可用
		    	try {
		    		//获取删除ID信息
		    		salesMan.setSalesManID(salesManIDField.getText().trim());
					boolean result = salesManService.deleteSalesMan(salesMan);
					if(result) {
						salesManUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"删除成功");
					}
					salesManUi1.setEnabled(true);
					salesManUi1.repaint();
					frame.setVisible(false);
					salesManUi1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		//退出按钮
		 exitButton.addActionListener(new ActionListener() {
	  			
	  			@Override
	  			public void actionPerformed(ActionEvent e) {
	  				
	  				System.exit(0);
	  			}
	  		});
		 

	}
	public SalesManUi2(SalesMan salesMan) {
		init();
		salesManIDField.setText(salesMan.getSalesManID());
		chineseNameField.setText(salesMan.getChineseName());
		englishNameField.setText(salesMan.getEnglishName());;
		telephoneField.setText(salesMan.getTelephone());
		contactAddressField.setText(salesMan.getContactAddress());
		emailField.setText(salesMan.getEmail());
		mobilePhoneField.setText(salesMan.getMobilePhone());
	}

	public static void main(String[] args) {
		/*
		SalesManUi2 salesManUi2 = new SalesManUi2();
		salesManUi2.init();*/

	}
}
