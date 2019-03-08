package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.guigu.pojo.Product;
import com.guigu.pojo.User;
import com.guigu.service.ProductDataService;
import com.guigu.service.UserService;
import com.guigu.service.impl.ProductDataServiceImpl;
import com.guigu.service.impl.UserServiceImpl;

public class StockQueryUi extends JFrame {
		private final int COR_COUNT = 5;
		// 定义table数据模型
		private DefaultTableModel model = null;
		// 定义JTable对象
		private JTable table = null;
		private JTable table1 = null;
		// 定义List集合用于保存被隐藏的列
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private  Object[][] tableData = null;
		private ProductDataService productDataService = new ProductDataServiceImpl();
		//创建面板
		private JPanel tablePanel = new JPanel(new BorderLayout()); 
		private JScrollPane scrollPane = null;
		Product product = new Product();
		// 创建查询信息标签
		JLabel lable_productID = new JLabel("产品编号");
		JLabel lable_productName = new JLabel("产品名称");
		JLabel lable_quantity = new JLabel("当前数量");
		JLabel lable_safeStock = new JLabel("安全存量");
		// 创建查询信息输入框
		JTextField productIDField = new JTextField(10);
		JTextField productNameField = new JTextField(10);
		
		// 指定按钮
		JButton findButton = new JButton("查询");
		JButton exitButton = new JButton("退出");
	    //创建一个面板
		JPanel  jpanel1 = new JPanel();
		JPanel  jpanel2 = new JPanel();
		//创建下拉按钮
		String[] str = {">","<","="};
		JComboBox<String> jcomboBox = new JComboBox<>(str);
		StockQueryUi() {
			super("库存查询");
			Object[] columnName = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量" };
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			Object[][] tableData = new Object[3][6];
			/*try {
				tableData = productDataService.getProuctDataBySafeStockAndQuantity("1",">");
				if(tableData == null) {
					tableData = new Object[0][0];
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}*/
			table = new JTable(tableData, columnName);
			scrollPane = new JScrollPane(table);
			tablePanel.add(scrollPane,BorderLayout.NORTH);
			this.add(new JScrollPane(table), BorderLayout.NORTH);
			//添加第二的面板组件
			jpanel1.add(lable_productID);
			jpanel1.add(productIDField);
			jpanel1.add(lable_productName);
			jpanel1.add(productNameField);
			//添加第三个面板组件
			jpanel2.add(lable_quantity);
		     //添加按钮
			jpanel2.add(jcomboBox);
			jpanel2.add(lable_safeStock);
			jpanel2.add(findButton);
			jpanel2.add(exitButton);
			
			this.add(jpanel1,BorderLayout.CENTER);
			this.add(jpanel2,BorderLayout.SOUTH);
			this.add(new JScrollPane(table), BorderLayout.NORTH);
			this.pack();
			this.setLocation(400, 200);
			this.setVisible(true);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					// TODO Auto-generated method stub
					MainUi.jframe.setEnabled(true);
					MainUi.jframe.setVisible(true);
				}
			});
			/*//添加下拉框监听
		    jcomboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					String select = (String) jcomboBox.getSelectedItem();
					System.out.println(select);
				}
			});*/
			
			//查询键事件
			findButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//System.out.println((String) jcomboBox.getSelectedItem());
					//repaitTable();
					//table.setVisible(false);
					Object[][] tableData1 = null;
					product.setProductID(productIDField.getText().trim());
					try {
						tableData1 = productDataService.getProuctDataBySafeStockAndQuantity((productIDField.getText().trim()),
								(productNameField.getText().trim()),(String) jcomboBox.getSelectedItem());
						if(tableData1 == null) {
							tableData1 = new Object[0][0];
							 String[] names = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量"};
						       DefaultTableModel tableModel = new DefaultTableModel(tableData1, names);//重新创建一个TableModel
						       table.setModel(tableModel);
						       table.setEnabled(true);
						       JOptionPane.showMessageDialog(null, "没有该类商品");
						}else {
						       //更新数据
						       String[] names = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量"};
						       DefaultTableModel tableModel = new DefaultTableModel(tableData1, names);//重新创建一个TableModel
						       table.setModel(tableModel);
						       table.setEnabled(true);
						    JOptionPane.showMessageDialog(null, "查询成功");
						}
					} catch (Exception e1) {
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
		public static void main(String[] args) {
			new StockQueryUi();

		}
}
