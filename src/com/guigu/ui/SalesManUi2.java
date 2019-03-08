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
 * ά������Ա���Ĳ�������2
 * 
 * @author ZJF
 *
 */
public class SalesManUi2 {
	
	SalesMan salesMan = new SalesMan();

	// ��������
	JFrame frame = new JFrame("����Ա������");
	//����productDataUi1�Ķ���
	SalesManUi1 salesManUi1 = new SalesManUi1();
	//����ҵ���߼������
	private SalesManService salesManService = new SalesManServiceImpl();
	// ����Jlabel

	JLabel label_salesManID = new JLabel("�ֹ����");
	JLabel label_chineseName = new JLabel("��������");
	JLabel label_englishName = new JLabel("Ӣ������");
	JLabel label_telephone = new JLabel("�绰");
	JLabel label_contactAddress = new JLabel("�����ַ");
	JLabel label_email = new JLabel("E-mail");
	JLabel label_mobilePhone = new JLabel("�ƶ��绰");

	// ����JTextField
	JTextField salesManIDField = new JTextField();
	JTextField chineseNameField = new JTextField();
	JTextField englishNameField = new JTextField();
	JTextField telephoneField = new JTextField();
	JTextField contactAddressField = new JTextField();
	JTextField emailField = new JTextField();
	JTextField mobilePhoneField = new JTextField();

	// ָ����ť
	JButton addButton = new JButton("����");
	JButton returnButton = new JButton("ȡ��");
	JButton saveButton = new JButton("����");
	JButton deleteButton = new JButton("ɾ��");
	JButton exitButton = new JButton("�˳�");


	public void init() {
		// ʹ�þ��Զ�λ
		frame.setLayout(null);
		// ����λ��
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

		// ������������
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

		// ����������С
		frame.setBounds(100, 100, 600, 300);
		// ���������ɼ�
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
		
		
		//Ϊ��ť����¼�
		//������ť
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//��������Ա����1���ڲ�����
				
			    try {
			    	//ִ����������
			    	//��ȡ�����Ϣ
			    	salesMan.setSalesManID(salesManIDField.getText().trim());
			    	salesMan.setChineseName(chineseNameField.getText().trim());
			    	salesMan.setEnglishName(englishNameField.getText().trim());
			    	salesMan.setTelephone(telephoneField.getText().trim());
			    	salesMan.setEmail(emailField.getText().trim());
			    	salesMan.setMobilePhone(mobilePhoneField.getText().trim());
			    	salesMan.setContactAddress(contactAddressField.getText().trim());
			    	//System.out.println("ִ�е���");
					boolean result = salesManService.addSalesMan(salesMan);
					if(result) {
						salesManUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"��ӳɹ�");
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
		//ȡ����ť
		returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
		//���水ť
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//��������Ա����1���ڲ�����
				  try {
				    	//ִ����������
				    	//��ȡ�����Ϣ
				    	salesMan.setSalesManID(salesManIDField.getText().trim());
				    	salesMan.setChineseName(chineseNameField.getText().trim());
				    	salesMan.setEnglishName(englishNameField.getText().trim());
				    	salesMan.setTelephone(telephoneField.getText().trim());
				    	salesMan.setEmail(emailField.getText().trim());
				    	salesMan.setMobilePhone(mobilePhoneField.getText().trim());
				    	salesMan.setContactAddress(contactAddressField.getText().trim());
				    	//System.out.println("ִ�е���");
						boolean result = salesManService.saveSalesMan(salesMan);
						if(result) {
							salesManUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"����ɹ�");
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
		//ɾ����ť
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salesManUi1.setEnabled(false);//��������Ա����1���ڲ�����
		    	try {
		    		//��ȡɾ��ID��Ϣ
		    		salesMan.setSalesManID(salesManIDField.getText().trim());
					boolean result = salesManService.deleteSalesMan(salesMan);
					if(result) {
						salesManUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
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
		
		//�˳���ť
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
