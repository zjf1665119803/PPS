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
	// 定义table数据模型
	private DefaultTableModel model = null;
	// 定义JTable对象
	private JTable table = null;
	// 定义List集合用于保存被隐藏的列
	private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
	private Object[][] tableData = null;
	private UserService userService = new UserServiceImpl();
	// 创建用户信息标签
	JLabel lable_userID = new JLabel("用户编号");
	JLabel lable_user = new JLabel("真实姓名");
	JLabel lable_pass = new JLabel("密码");
	// 创建用户信息输入框
	JTextField userIDField = new JTextField(10);
	JTextField userField = new JTextField(10);
	JPasswordField passField = new JPasswordField(10);
	// 指定按钮
	JButton addButton = new JButton("新增");
	JButton saveButton = new JButton("保存");
	JButton deleteButton = new JButton("删除");
	JButton noButton = new JButton("禁用");
	JButton exitButton = new JButton("退出");
    //创建一个面板
	JPanel  jpanel = new JPanel();
	JPanel  jpanel2 = new JPanel();
	//数据更新
	public void dataUpdate() {
		{
	    	 try {
					tableData = userService.getAllUsers();
					System.out.println(tableData);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				//更新数据
			       String[] names = {"用户编号", "用户姓名", "用户密码", "是否禁用"};
			       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//重新创建一个TableModel
			       table.setModel(tableModel);
			       table.setEnabled(true);
	     }
	}
	
	//定义用户对象
	User user = new User();
	public void repaitTable() {
		Object[] columnName = { "用户编号", "用户姓名", "用户密码", "是否禁用" };
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
		super("用户资料管理");
		Object[] columnName = { "用户编号", "用户姓名", "用户密码", "是否禁用" };
		model = new DefaultTableModel(COR_COUNT, COR_COUNT);
		// Object[][] tableData = null;
		try {
			tableData = userService.getAllUsers();
			System.out.println(tableData);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		table = new JTable(tableData, columnName);
		//添加第二的面板组件
		jpanel.add(lable_userID);
		jpanel.add(userIDField);
		jpanel.add(lable_user);
		jpanel.add(userField);
		jpanel.add(lable_pass);
		jpanel.add(passField);
		//添加第三个面板组件
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
	     
		//为按钮添加事件
		//新增按钮
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 try {
				    	//执行新增操作
				    	//获取添加信息
				    	user.setUserID(userIDField.getText().trim());
				    	user.setUserName(userField.getText().trim());
				    	user.setPasswordCode(new String(passField.getPassword()));
				    	//System.out.println("执行到这");
				    	int s = userIDField.getText().trim().length()+userField.getText().trim().length();
				    	System.out.println(s);
				    	if(s < 2) {
							javax.swing.JOptionPane.showMessageDialog(null,"请输入添加信息");
						}else {
							boolean result = userService.addUser(user);
							//UserInfoUi.this.setVisible(false);
							if(result) {
								dataUpdate();
								javax.swing.JOptionPane.showMessageDialog(null,"添加成功");
							}
						}
					
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
				}
			}
		});
		//保存按钮
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					int r = table.getSelectedRow();
					// int c= table.getSelectedColumn();
					// 得到选中行的值，表格中都是字符串
					Object value1 = table.getValueAt(r, 0);
					Object value2 = table.getValueAt(r, 1);
					Object value3 = table.getValueAt(r, 2);
					Object value4 = table.getValueAt(r, 3);
					
					String info1 = value1.toString();
					String info2 = value2.toString();
					String info3 = value3.toString();
					String info4 = value4.toString();
					// String info = r+"行"+c+"列值 : "+value.toString();
					// javax.swing.JOptionPane.showMessageDialog(null,info);
					boolean result = userService.saveUser(info1,info2,info3,info4);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"修改成功");
					}
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
				try {
					// 得到选中行ID，表格中都是字符串
					int r = table.getSelectedRow();
					Object value1 = table.getValueAt(r, 0);
					String info1 = value1.toString();
					boolean result = userService.deleteUser(info1);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"删除成功");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//禁用按钮
		noButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 得到选中行ID，表格中都是字符串
					int r = table.getSelectedRow();
					Object value1 = table.getValueAt(r, 0);
					String info1 = value1.toString();
					boolean result = userService.noUser(info1);
					if(result) {
						dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null,"禁用成功");
					}
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

	public static void main(String[] args) {
		new UserInfoUi();

	}

}
