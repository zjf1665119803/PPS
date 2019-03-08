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
		// ����table����ģ��
		private DefaultTableModel model = null;
		// ����JTable����
		private JTable table = null;
		// ����List�������ڱ��汻���ص���
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private  Object[][] tableData = null;
		private SupplierDataService supplierDataService = new SupplierDataServiceImpl();
		//�������
		private JPanel tablePanel = new JPanel(new BorderLayout()); 
		private JScrollPane scrollPane = null;
		Supplier supplier = new Supplier();
		//���ݸ���
				public void dataUpdate() {
					{
				    	 try {
								tableData = supplierDataService.getAllSupplier();
								//System.out.println(tableData);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							//��������
						       String[] names = {"���","��Ӧ�̼��","��Ӧ��ȫ��","������","�����˳�ν","�绰",
										"�ƶ��绰","����","��˾��ַ","������ַ","����������"};
						       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//���´���һ��TableModel
						       table.setModel(tableModel);
						       table.setEnabled(true);
				     }
				}
	
		SupplierDataUi1() {
			super("��Ӧ������");
			Object[] columnName = {"���","��Ӧ�̼��","��Ӧ��ȫ��","������","�����˳�ν","�绰",
					"�ƶ��绰","����","��˾��ַ","������ַ","����������"};
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
	
			// Jtableѡ�д����ڶ�����������
			table.addMouseListener(new MouseAdapter() {
	
				public void mouseClicked(MouseEvent e) {// ������굥��ʱ��Ӧ
					// �õ�ѡ�е����е�����ֵ
					int r = table.getSelectedRow();
					int c = 0;
					// �õ�ѡ�еĵ�Ԫ��ĵ�һֵ������ж����ַ���
					Object value = table.getValueAt(r, c);
					String info = value.toString();
					try {
						Supplier supplier = supplierDataService.getSupplier(info);
						if(supplier == null) {
                        	javax.swing.JOptionPane.showMessageDialog(null, "û�������Ϣ");
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
