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
import com.guigu.service.CustomerDataService;
import com.guigu.service.impl.CustomerDataServiceImpl;

public class CustomerDataUi1 extends JFrame {
		private final int COR_COUNT = 5;
		// ����table����ģ��
		private DefaultTableModel model = null;
		// ����JTable����
		private JTable table = null;
		// ����List�������ڱ��汻���ص���
		private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
		private  Object[][] tableData = null;
		private CustomerDataService customerDataService = new CustomerDataServiceImpl();
		//�������
		private JPanel tablePanel = new JPanel(new BorderLayout()); 
		private JScrollPane scrollPane = null;
		Customer customer = new Customer();
		//���ݸ���
		public void dataUpdate() {
			{
		    	 try {
						tableData = customerDataService.getAllCustomer();
						//System.out.println(tableData);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					//��������
				       String[] names = {"���","��˾���","��˾ȫ��","������","�����˳�ν","�绰",
								"�ƶ��绰","����","����Ա���","�ͻ���ַ","�ͻ��ͻ���ַ","��Ʊ��ַ","����ͻ�����"};
				       DefaultTableModel tableModel = new DefaultTableModel(tableData, names);//���´���һ��TableModel
				       table.setModel(tableModel);
				       table.setEnabled(true);
		     }
		}
	
		CustomerDataUi1() {
			super("�ͻ�����");
			Object[] columnName = {"���","��˾���","��˾ȫ��","������","�����˳�ν","�绰",
					"�ƶ��绰","����","����Ա���","�ͻ���ַ","�ͻ��ͻ���ַ","��Ʊ��ַ","����ͻ�����"};
			model = new DefaultTableModel(COR_COUNT, COR_COUNT);
			//Object[][] tableData = new Object[3][6];
			try {
				tableData = customerDataService.getAllCustomer();
				//System.out.println("ִ�е���");
				//System.out.println(tableData.toString());
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
			//this.setLocation(200, 200);
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
						Customer customer = customerDataService.getCustomer(info);
						if(customer == null) {
							javax.swing.JOptionPane.showMessageDialog(null, "û�������Ϣ");
						}else {
							CustomerDataUi1.this.setVisible(false);
						CustomerDataUi2 customerDataUi2 = new CustomerDataUi2(customer);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

			});
		}
		public static void main(String[] args) {
			new CustomerDataUi1();
		}
}
