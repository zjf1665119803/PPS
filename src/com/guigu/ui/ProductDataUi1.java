package com.guigu.ui;

/**
 * 维护商品资料操作界面1
 * @author ZJF
 *
 */

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.Product;
import com.guigu.service.ProductDataService;
import com.guigu.service.SalesManService;
import com.guigu.service.impl.ProductDataServiceImpl;
import com.guigu.service.impl.SalesManServiceImpl;

	
	public class ProductDataUi1 extends JFrame {
		private final int COR_COUNT  = 5;
		//定义table数据模型
		private DefaultTableModel model = null;
		//定义JTable对象
		private JTable table = null;
		private ProductDataService  productDataService = new ProductDataServiceImpl();
		//定义List集合用于保存被隐藏的列
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private Object[][] tableData = null;
		//数据更新
		public void dataUpdate() {
			{
		    	 try {
						tableData = productDataService.getAllProuctData();
						//System.out.println(tableData);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//更新数据
				       String[] names = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量","建议购买价","建议销售价"};
				       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//重新创建一个TableModel
				       table.setModel(tableModel);
				       table.setEnabled(true);
		     }
		}
		
		/*public void repaitTable() {
			Object[] columnName = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量","建议购买价","建议销售价"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			try {
				tableData = productDataService.getAllProuctData();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			table = new JTable(tableData,columnName);
			this.add(new JScrollPane(table),BorderLayout.CENTER);
		}*/
		
		ProductDataUi1(){
			super("商品资料");
			Object[] columnName = {"编号","产品名称","安全存量","最后进货日期","最后送货日期","当前数量","建议购买价","建议销售价"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			//Object[][] tableData = null;
			try {
				tableData = productDataService.getAllProuctData();
				System.out.println(tableData);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			table = new JTable(tableData,columnName);
			this.add(new JScrollPane(table),BorderLayout.CENTER);
			this.pack();
			this.setBounds(100, 100, 800, 600);
			this.setVisible(true);
			//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
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
				try {
					Product product = productDataService.getProduct(info);
					//System.out.println(product.toString());
					ProductDataUi1.this.setVisible(false);
				    ProductDataUi2 productDataUi2= new ProductDataUi2(ProductDataUi1.this,product);
				    ProductDataUi1.this.setEnabled(false);
				    ProductDataUi1.this.setVisible(false);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
	}
		
		public static void main(String[] args) {
			new ProductDataUi1();
		}
		

}
