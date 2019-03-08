package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.SalesMan;
import com.guigu.pojo.User;
import com.guigu.service.SalesManService;
import com.guigu.service.UserService;
import com.guigu.service.impl.SalesManServiceImpl;
import com.guigu.service.impl.UserServiceImpl;

public class UserInfoUi extends JFrame {
	private final int COR_COUNT = 5;
	// ����table����ģ��
	private DefaultTableModel model = null;
	// ����JTable����
	private JTable table = null;
	// ����List�������ڱ��汻���ص���
	private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
	private Object[][] tableData = null;
	private UserService userService = new UserServiceImpl();
	// �����û���Ϣ��ǩ
	JLabel lable_userID = new JLabel("�û����");
	JLabel lable_user = new JLabel("��ʵ����");
	JLabel lable_pass = new JLabel("����");
	// �����û���Ϣ�����
	JTextField userIDField = new JTextField(10);
	JTextField userField = new JTextField(10);
	JPasswordField passField = new JPasswordField(10);
	// ָ����ť
	JButton addButton = new JButton("����");
	JButton saveButton = new JButton("����");
	JButton deleteButton = new JButton("ɾ��");
	JButton noButton = new JButton("����");
	JButton exitButton = new JButton("�˳�");
    //����һ�����
	JPanel  jpanel = new JPanel();
	JPanel  jpanel2 = new JPanel();
	//���ݸ���
	public void dataUpdate() {
		{
	    	 try {
					tableData = userService.getAllUsers();
					System.out.println(tableData);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//��������
			       String[] names = {"�û����", "�û�����", "�û�����", "�Ƿ����"};
			       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//���´���һ��TableModel
			       table.setModel(tableModel);
			       table.setEnabled(true);
	     }
	}
	
	//�����û�����
	User user = new User();
	public void repaitTable() {
		Object[] columnName = { "�û����", "�û�����", "�û�����", "�Ƿ����" };
		model = new DefaultTableModel(COR_COUNT, COR_COUNT);
		try {
			tableData = userService.getAllUsers();
			System.out.println(userService.getAllUsers().toString());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		table = new JTable(tableData, columnName);
		this.add(new JScrollPane(table), BorderLayout.NORTH);
	}
    

	UserInfoUi() {
		super("�û����Ϲ���");
		Object[] columnName = { "�û����", "�û�����", "�û�����", "�Ƿ����" };
		model = new DefaultTableModel(COR_COUNT, COR_COUNT);
		// Object[][] tableData = null;
		try {
			tableData = userService.getAllUsers();
			System.out.println(tableData);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		table = new JTable(tableData, columnName);
		//��ӵڶ���������
		jpanel.add(lable_userID);
		jpanel.add(userIDField);
		jpanel.add(lable_user);
		jpanel.add(userField);
		jpanel.add(lable_pass);
		jpanel.add(passField);
		//��ӵ�����������
		jpanel2.add(addButton);
		jpanel2.add(saveButton);
		jpanel2.add(deleteButton);
		jpanel2.add(noButton);
		jpanel2.add(exitButton);
		this.add(jpanel,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.SOUTH);
		this.add(new JScrollPane(table), BorderLayout.NORTH);
		this.pack();
		//this.setBounds(100, 100, 800, 500);
		this.setLocation(200, 200);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainUi.jframe.setEnabled(true);
                MainUi.jframe.setVisible(true);
            }
        });
	     
		//Ϊ��ť����¼�
		//������ť
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 try {
				    	//ִ����������
				    	//��ȡ�����Ϣ
				    	user.setUserID(userIDField.getText().trim());
				    	user.setUserName(userField.getText().trim());
				    	user.setPasswordCode(new String(passField.getPassword()));
				    	//System.out.println("ִ�е���");
				    	int s = userIDField.getText().trim().length()+userField.getText().trim().length();
				    	System.out.println(s);
				    	if(s < 2) {
							javax.swing.JOptionPane.showMessageDialog(null,"�����������Ϣ");
						}else {
							boolean result = userService.addUser(user);
							//UserInfoUi.this.setVisible(false);
							if(result) {
								dataUpdate();
								javax.swing.JOptionPane.showMessageDialog(null,"��ӳɹ�");
							}
						}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
				}
			}
		});
		//���水ť
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int r = table.getSelectedRow();
					// int c= table.getSelectedColumn();
					// �õ�ѡ���е�ֵ������ж����ַ���
					Object value1 = table.getValueAt(r, 0);
					Object value2 = table.getValueAt(r, 1);
					Object value3 = table.getValueAt(r, 2);
					Object value4 = table.getValueAt(r, 3);
					
					String info1 = value1.toString();
					String info2 = value2.toString();
					String info3 = value3.toString();
					String info4 = value4.toString();
					// String info = r+"��"+c+"��ֵ : "+value.toString();
					// javax.swing.JOptionPane.showMessageDialog(null,info);
					boolean result = userService.saveUser(info1,info2,info3,info4);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
					}
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
				try {
					// �õ�ѡ����ID������ж����ַ���
					int r = table.getSelectedRow();
					Object value1 = table.getValueAt(r, 0);
					String info1 = value1.toString();
					boolean result = userService.deleteUser(info1);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//���ð�ť
		noButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// �õ�ѡ����ID������ж����ַ���
					int r = table.getSelectedRow();
					Object value1 = table.getValueAt(r, 0);
					String info1 = value1.toString();
					boolean result = userService.noUser(info1);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"���óɹ�");
					}
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

	public static void main(String[] args) {
		new UserInfoUi();

	}

}
