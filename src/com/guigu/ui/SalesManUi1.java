package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.Product;
import com.guigu.pojo.SalesMan;
import com.guigu.service.SalesManService;
import com.guigu.service.impl.SalesManServiceImpl;

/**
 * 维护销售员工的操作界面1
 * @author ZJF
 *
 */

public class SalesManUi1 extends JFrame {
		private final int COR_COUNT  = 5;
		//定义table数据模型
		private DefaultTableModel model = null;
		//定义JTable对象
		private JTable table = null;
		private SalesManService  salesManService = new SalesManServiceImpl();
		//定义List集合用于保存被隐藏的列
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private Object[][] tableData = null;
		//数据更新
				public void dataUpdate() {
					{
				    	 try {
								tableData = salesManService.getAllSalesMan();
								//System.out.println(tableData);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							//更新数据
						       String[] names = {"编号","中文姓名","英文姓名","电话","移动电话","联络地址","电子邮件"};
						       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//重新创建一个TableModel
						       table.setModel(tableModel);
						       table.setEnabled(true);
				     }
				}
		public void repaitTable() {
			System.out.println("aaaa");
			Object[] columnName = {"编号","中文姓名","英文姓名","电话","移动电话","联络地址","电子邮件"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			Object[][] tableData = null;
			try {
				tableData = salesManService.getAllSalesMan();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			table = new JTable(tableData,columnName);
			this.add(new JScrollPane(table),BorderLayout.CENTER);
		}
		SalesManUi1(){
			super("销售员工资料");
			Object[] columnName = {"编号","中文姓名","英文姓名","电话","移动电话","联络地址","电子邮件"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			Object[][] tableData = null;
			try {
				tableData = salesManService.getAllSalesMan();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			table = new JTable(tableData,columnName);
			this.add(new JScrollPane(table),BorderLayout.CENTER);			
			this.pack();
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setBounds(100, 100, 800, 600);
			this.setVisible(true);
			this.setEnabled(true);
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
			    // int c= table.getSelectedColumn();
				int c = 0;
				// 得到选中的单元格的第一值，表格中都是字符串
				Object value = table.getValueAt(r, c);
				String info = value.toString();
				// String info = r+"行"+c+"列值 : "+value.toString();
				// javax.swing.JOptionPane.showMessageDialog(null,info);
				// System.out.println(value);
				try {
					SalesMan salesMan = salesManService.getSalesMan(info);
					//System.out.println(salesMan.toString());
					// ProductDataUi2 productDataUi2 = new ProductDataUi2();
					// productDataUi2.init();
					SalesManUi1.this.setVisible(false);
					SalesManUi2 salesManUi2 = new SalesManUi2(salesMan);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		}
		
		public static void main(String[] args) {
			//System.out.println("123");
			new SalesManUi1();
		}
	}

	

