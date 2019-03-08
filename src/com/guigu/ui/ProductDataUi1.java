package com.guigu.ui;

/**
 * ά����Ʒ���ϲ�������1
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
		//����table����ģ��
		private DefaultTableModel model = null;
		//����JTable����
		private JTable table = null;
		private ProductDataService  productDataService = new ProductDataServiceImpl();
		//����List�������ڱ��汻���ص���
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private Object[][] tableData = null;
		//���ݸ���
		public void dataUpdate() {
			{
		    	 try {
						tableData = productDataService.getAllProuctData();
						//System.out.println(tableData);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//��������
				       String[] names = {"���","��Ʒ����","��ȫ����","����������","����ͻ�����","��ǰ����","���鹺���","�������ۼ�"};
				       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//���´���һ��TableModel
				       table.setModel(tableModel);
				       table.setEnabled(true);
		     }
		}
		
		/*public void repaitTable() {
			Object[] columnName = {"���","��Ʒ����","��ȫ����","����������","����ͻ�����","��ǰ����","���鹺���","�������ۼ�"};
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
			super("��Ʒ����");
			Object[] columnName = {"���","��Ʒ����","��ȫ����","����������","����ͻ�����","��ǰ����","���鹺���","�������ۼ�"};
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
		// Jtableѡ�д����ڶ�����������
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {// ������굥��ʱ��Ӧ
				// �õ�ѡ�е����е�����ֵ
				int r = table.getSelectedRow();
				// int c= table.getSelectedColumn();
				int c = 0;
				// �õ�ѡ�еĵ�Ԫ��ĵ�һֵ������ж����ַ���
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
