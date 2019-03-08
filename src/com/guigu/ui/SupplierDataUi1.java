package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.Customer;
import com.guigu.pojo.Supplier;
import com.guigu.service.CustomerDataService;
import com.guigu.service.SupplierDataService;
import com.guigu.service.impl.CustomerDataServiceImpl;
import com.guigu.service.impl.SupplierDataServiceImpl;

public class SupplierDataUi1 extends JFrame {
		private final int COR_COUNT = 5;
		// 定义table数据模型
		private DefaultTableModel model = null;
		// 定义JTable对象
		private JTable table = null;
		// 定义List集合用于保存被隐藏的列
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private  Object[][] tableData = null;
		private SupplierDataService supplierDataService = new SupplierDataServiceImpl();
		//创建面板
		private JPanel tablePanel = new JPanel(new BorderLayout()); 
		private JScrollPane scrollPane = null;
		Supplier supplier = new Supplier();
		//数据更新
				public void dataUpdate() {
					{
				    	 try {
								tableData = supplierDataService.getAllSupplier();
								//System.out.println(tableData);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							//更新数据
						       String[] names = {"编号","供应商简称","供应商全称","负责人","负责人称谓","电话",
										"移动电话","传真","公司地址","工厂地址","最后进货日期"};
						       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//重新创建一个TableModel
						       table.setModel(tableModel);
						       table.setEnabled(true);
				     }
				}
	
		SupplierDataUi1() {
			super("供应商资料");
			Object[] columnName = {"编号","供应商简称","供应商全称","负责人","负责人称谓","电话",
					"移动电话","传真","公司地址","工厂地址","最后进货日期"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			try {
				tableData = supplierDataService.getAllSupplier();
				if(tableData == null) {
					tableData = new Object[0][0];
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			table = new JTable(tableData, columnName);
			scrollPane = new JScrollPane(table);
			tablePanel.add(scrollPane,BorderLayout.NORTH);
			this.add(new JScrollPane(table), BorderLayout.NORTH);
			this.pack();
			this.setBounds(200, 200, 1000, 400);
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
	
			// Jtable选中触发第二个操作界面
			table.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent e) {// 仅当鼠标单击时响应
					// 得到选中的行列的索引值
					int r = table.getSelectedRow();
					int c = 0;
					// 得到选中的单元格的第一值，表格中都是字符串
					Object value = table.getValueAt(r, c);
					String info = value.toString();
					try {
						Supplier supplier = supplierDataService.getSupplier(info);
						if(supplier == null) {
                        	javax.swing.JOptionPane.showMessageDialog(null, "没有相关信息");
                        }else {
                        	SupplierDataUi1.this.setVisible(false);
						SupplierDataUi2 supplierDataUi2 = new SupplierDataUi2(supplier);
                        }
					} catch (Exception e1) {
						e1.printStackTrace();
					}
	
				}
	
			});
		}
		public static void main(String[] args) {
			new SupplierDataUi1();
		}

}
