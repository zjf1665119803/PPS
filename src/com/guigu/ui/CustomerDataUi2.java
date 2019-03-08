package com.guigu.ui;
/**
 * 客户数据操作维护界面2
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.Customer;
import com.guigu.service.CustomerContactManService;
import com.guigu.service.CustomerDataService;
import com.guigu.service.impl.CustomerContactManServiceImpl;
import com.guigu.service.impl.CustomerDataServiceImpl;

public class CustomerDataUi2 extends JFrame{  
	
	    private JTabbedPane tabbedPane;  //选项卡面板
	    private JPanel panel1,panel2,panel3;  //面板
	    
		private final int COR_COUNT = 5;
		// 定义table数据模型
		private DefaultTableModel model = null;
		private DefaultTableModel model1 = null;
		// 定义JTable对象
		private JTable table = null;
		private JTable table1 = null;
		// 定义List集合用于保存被隐藏的列
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private Object[][] tableData = null;
		private Object[][] tableData1 = null;
		private JScrollPane scrollPane = null;
		private JPanel tablePanel = new JPanel(new BorderLayout());
		private JScrollPane scrollPane1 = null;
		private JPanel tablePanel1 = new JPanel(new BorderLayout());
		private CustomerDataService customerDataService = new CustomerDataServiceImpl();
		private CustomerDataUi1 customerDataUi1 = new CustomerDataUi1();
	    private CustomerContactManService customerContactManService =new CustomerContactManServiceImpl();
		
		public CustomerDataUi2(Customer customer) throws Exception  {  
	        super("客户资料"); 
	        //setSize(400,300);  
	        setBounds(400, 200, 600, 500);
	        Container c = getContentPane();   //初始化容器
	        tabbedPane = new JTabbedPane();   //创建选项卡面板对象  
	        
	       //创建标签  
	        JLabel label_customerID = new JLabel("客户编号");
	        JLabel label_customerSimpleName = new JLabel("公司简称");
	        JLabel label_customerName = new JLabel("公司全称");
	        JLabel label_owner = new JLabel("负责人");
	        JLabel label_title = new JLabel("负责人称谓");
	        JLabel label_telephone = new JLabel("电话");
	        JLabel label_mobilePhone = new JLabel("移动电话");
	        JLabel label_fax = new JLabel("传真");
	        JLabel label_salesManID = new JLabel("销售员");
	        JLabel label_customerAddress = new JLabel("客户地址");
	        JLabel label_deliveryAddress = new JLabel("送货地址");
	        JLabel label_invoiceAddress = new JLabel("开票地址");
	        //创建面板  
	        panel1=new JPanel();  
	        panel2=new JPanel();  
	        panel3=new JPanel();  
	       //添加标签到面板
	        panel1.add(label_customerAddress);
	        panel1.add(label_customerID);
	        panel1.add(label_customerName);
	        panel1.add(label_customerSimpleName);
	        panel1.add(label_deliveryAddress);
	        panel1.add(label_fax);
	        panel1.add(label_invoiceAddress);
	        panel1.add(label_owner);
	        panel1.add(label_mobilePhone);
	        panel1.add(label_salesManID);
	        panel1.add(label_telephone);
	        panel1.add(label_title);
	        //创建文本框
	        JTextField field_customerID = new JTextField(10);
	        JTextField field_customerSimpleName = new JTextField(10);
	        JTextField field_customerName = new JTextField(10);
	        JTextField field_owner = new JTextField(10);
	        JTextField field_title = new JTextField(10);
	        JTextField field_telephone = new JTextField(10);
	        JTextField field_mobilePhone = new JTextField(10);
	        JTextField field_fax = new JTextField(10);
	        
	        //创建下拉按钮
			//获取所有销售员编号
			Object[] str1 = customerDataService.getSalesManID();
			Object str ;
			for(int i = 0;i < str1.length;i++) {
				if(str1[i].equals(customer.getSalesManID())) {
					str = str1[i];
					str1[i] = str1[0];
					str1[0] = str;	
				}
			}
		    JComboBox<Object> jcomboBox = new JComboBox<>(str1);
	        JTextField field_customerAddress = new JTextField(10);
	        JTextField field_deliveryAddress = new JTextField(10);
	        JTextField field_invoiceAddress = new JTextField(10);
	        //添加文本框到面板
	        panel1.add(field_customerAddress);
	        panel1.add(field_customerID);
	        panel1.add(field_customerName);
	        panel1.add(field_customerSimpleName);
	        panel1.add(field_deliveryAddress);
	        panel1.add(field_fax);
	        panel1.add(field_invoiceAddress);
	        panel1.add(field_owner);
	        panel1.add(field_mobilePhone);
	        panel1.add(jcomboBox);
	        panel1.add(field_telephone);
	        panel1.add(field_title);
	        
	     // 指定按钮
	    	JButton addButton = new JButton("新增");
	    	JButton returnButton = new JButton("取消");
	    	JButton saveButton = new JButton("保存");
	    	JButton deleteButton = new JButton("删除");
	    	JButton exitButton = new JButton("退出");
	    	//添加按钮
	    	panel1.add(exitButton);
			panel1.add(deleteButton);
			panel1.add(saveButton);
			panel1.add(returnButton);
			panel1.add(addButton);
	        //将标签面板加入到选项卡面板对象上  
	        tabbedPane.addTab("客户资料",null,panel1,"First panel");  
	        tabbedPane.addTab("联络资料",null,panel2,"Second panel");  
	        tabbedPane.addTab("交易记录",null,panel3,"Third panel");  
	        //指定位置
	     // 使用绝对定位
			panel1.setLayout(null);
			// 设置位置
			label_customerID.setBounds(30, 30, 75, 30);
			label_title.setBounds(30, 70, 75, 30);
			label_owner.setBounds(30, 110, 75, 30);
			label_salesManID.setBounds(30, 150, 75, 30);
			label_invoiceAddress.setBounds(30, 190, 75, 30);
			
			label_customerSimpleName.setBounds(200, 30, 75, 30);
			label_telephone.setBounds(200, 70, 75, 30);
			label_fax.setBounds(200, 110, 75, 30);
			label_customerAddress.setBounds(200, 150, 75, 30);
			label_deliveryAddress.setBounds(200, 190, 75, 30);
			
			label_customerName.setBounds(380, 30, 75, 30);
			label_mobilePhone.setBounds(380, 70, 75, 30);
			//
			field_customerID.setBounds(100, 30, 95, 30);
			field_title.setBounds(100, 70, 95, 30);
			field_owner.setBounds(100, 110, 95, 30);
			jcomboBox.setBounds(100, 150, 95, 30);
			field_invoiceAddress.setBounds(100, 190, 95, 30);

		    field_customerSimpleName.setBounds(260, 30, 95, 30);
		    field_telephone.setBounds(260, 70, 95, 30);
			field_fax.setBounds(260, 110, 95, 30);
			field_customerAddress.setBounds(260, 150, 150, 30);
			field_deliveryAddress.setBounds(260, 190, 150, 30);
	
			field_customerName.setBounds(440, 30, 95, 30);
			field_mobilePhone.setBounds(440, 70, 95, 30);
	
			addButton.setBounds(150, 300, 60, 30);
			returnButton.setBounds(235, 300, 60, 30);
			saveButton.setBounds(320, 300, 60, 30);
			deleteButton.setBounds(405, 300, 60, 30);
			exitButton.setBounds(485, 300, 60, 30);

			// 添加第二标签表格
	
			Object[] columnName = { "中文名称", "英文名称", "联系人称谓", "电话", "移动电话" };
			model = new DefaultTableModel(6, 4);
			//Object[][] tableData = new Object[3][5];
			
	        tableData = customerContactManService.getcustomerContactMan(customer.getCustomerID());
	        if(tableData == null) {
				tableData = new Object[0][0];
			} 
			table = new JTable(tableData, columnName);
			panel2.add(new JScrollPane(table), BorderLayout.NORTH);
			table = new JTable(tableData, columnName);
			scrollPane = new JScrollPane(table);
			tablePanel.add(scrollPane, BorderLayout.NORTH);
			
			//添加第三标签的表格
			Object[] columnName1 = { "单据编号", "销售单属性", "交易日期", "销售员", "送货地址","发票号" };
			model = new DefaultTableModel(6, 6);
			//Object[][] tableData1 = new Object[3][6];
			tableData1 = customerContactManService.getDeliveryData(customer.getCustomerID());
			if(tableData1 == null) {
				tableData1 = new Object[0][0];
			}
			table1 = new JTable(tableData1, columnName1);
			panel3.add(new JScrollPane(table1), BorderLayout.NORTH);
			table1 = new JTable(tableData, columnName1);
			scrollPane1 = new JScrollPane(table1);
			tablePanel1.add(scrollPane1, BorderLayout.NORTH);
			
	        c.add(tabbedPane);  
	        c.setBackground(Color.white);  
	        setVisible(true);  
	        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	            	customerDataUi1.setEnabled(true);
	            	customerDataUi1.setVisible(true);
	            }
	        });
	        
	         field_customerID.setText(customer.getCustomerID());
	         field_customerSimpleName.setText(customer.getCustomerSimpleName());
	         field_customerName.setText(customer.getCustomerName());
	         field_owner.setText(customer.getOwner());
	         field_title.setText(customer.getTitle());
	         field_telephone.setText(customer.getTelephone());
	         field_mobilePhone.setText(customer.getMobilePhone());
	         field_fax.setText(customer.getFax());
             field_customerAddress.setText(customer.getCustomerAddress());
			 field_deliveryAddress.setText(customer.getDeliveryAddress());
			 field_invoiceAddress.setText(customer.getInvoiceAddress());
	     
			 //添加事件
			 //第一界面
		// 新增按钮
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerDataUi1.setEnabled(false);// 设置销售员资料1窗口不可用

				try {
					// 执行新增操作
					// 获取添加信息
					customer.setCustomerID(field_customerID.getText().trim());
					customer.setCustomerSimpleName(field_customerSimpleName.getText().trim());;
					customer.setCustomerName(field_customerName.getText().trim());
					customer.setTitle(field_title.getText().trim());
					customer.setTelephone(field_telephone.getText().trim());
					customer.setTelephone(field_telephone.getText().trim());
					customer.setMobilePhone(field_mobilePhone.getText().trim());
					customer.setOwner(field_owner.getText().trim());
					customer.setFax(field_fax.getText().trim());
					customer.setCustomerAddress(field_customerAddress.getText().trim());
					customer.setInvoiceAddress(field_invoiceAddress.getText().trim());
					customer.setDeliveryAddress(field_deliveryAddress.getText().trim());
					customer.setSalesManID((String) jcomboBox.getSelectedItem());
		   		    // System.out.println("执行到这");
					boolean result = customerDataService.addCustomer(customer);
					if (result) {
						customerDataUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null, "添加成功");
					}
					customerDataUi1.setEnabled(true);
					customerDataUi1.repaint();
					setVisible(false);  
					customerDataUi1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// 取消按钮
		returnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);  

			}
		});
		// 保存按钮
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerDataUi1.setEnabled(false);// 设置销售员资料1窗口不可用
				try {
					// 获取修改信息
					customer.setCustomerID(field_customerID.getText().trim());
					customer.setCustomerSimpleName(field_customerSimpleName.getText().trim());;
					customer.setCustomerName(field_customerName.getText().trim());
					customer.setTitle(field_title.getText().trim());
					customer.setTelephone(field_telephone.getText().trim());
					customer.setTelephone(field_telephone.getText().trim());
					customer.setMobilePhone(field_mobilePhone.getText().trim());
					customer.setOwner(field_owner.getText().trim());
					customer.setFax(field_fax.getText().trim());
					customer.setCustomerAddress(field_customerAddress.getText().trim());
					customer.setInvoiceAddress(field_invoiceAddress.getText().trim());
					customer.setDeliveryAddress(field_deliveryAddress.getText().trim());
					customer.setSalesManID((String) jcomboBox.getSelectedItem());
					// System.out.println("执行到这");
					boolean result = customerDataService.saveCustomer(customer);
					if (result) {
						customerDataUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null, "保存成功");
					}
					customerDataUi1.setEnabled(true);
					customerDataUi1.repaint();
					setVisible(false);  
					customerDataUi1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// 删除按钮
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customerDataUi1.setEnabled(false);// 设置销售员资料1窗口不可用
				try {
					// 获取删除ID信息
					customer.setCustomerID(field_customerID.getText().trim());
					boolean result = customerDataService.deleteCustomer(customer);
					if (result) {
						customerDataUi1.dataUpdate();
						javax.swing.JOptionPane.showMessageDialog(null, "删除成功");
					}
					customerDataUi1.setEnabled(true);
					customerDataUi1.repaint();
					setVisible(false);  
					customerDataUi1.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		// 退出按钮
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});
		}
	      
	    

		public static void main(String args[]) throws Exception  
	    {  
	    	 new CustomerDataUi2(null);  
	    }  
	}  



