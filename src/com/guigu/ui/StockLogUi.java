package com.guigu.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.guigu.pojo.PurchaseDetail;
import com.guigu.pojo.PurchaseMaster;
import com.guigu.pojo.SalesMan;
import com.guigu.service.PurchaseMasterService;
import com.guigu.service.PurchaseDetailService;
import com.guigu.service.impl.PurchaseDetailServiceImpl;
import com.guigu.service.impl.purchaseMasterServiceImpl;
import com.guigu.util.DateChooserJButton;

/**
 * �ɹ���¼��
 * 
 * @author ZJF
 *
 */

public class StockLogUi {
	
	PurchaseMasterService purchaseMasterService = new purchaseMasterServiceImpl();
	PurchaseDetailService purchaseDetailService = new PurchaseDetailServiceImpl();
	private JFrame jframe = new JFrame("PPS������ϵͳ");
	private int index = 0;
	private Object[][] tableData = null;
	private DefaultTableModel model = null;
	JLabel label_SupplierID = new JLabel("��Ӧ�̱��");
	JLabel label_purchaseID = new JLabel("�ֹ�����");
	JLabel label_purchaseDate = new JLabel("�ɹ�����");
	JLabel label_allPurchaseAmount = new JLabel("�ܽ��");
	// �����ֹ����ź��ܽ�������
	JTextField field_purchaseID = new JTextField(10);
	JTextField field_allPurchaseAmount = new JTextField(10);

	// ָ����ť
	JButton lastButton = new JButton("��һ��");
	JButton nextButton = new JButton("��һ��");
	JButton exitButton = new JButton("�˳�");

	JButton updateButton = new JButton("�޸�");
	JButton addButton = new JButton("����");
	JButton deleteButton = new JButton("ɾ��");
	JButton findButton = new JButton("��ѯ");
	
	//�����������
	DateChooserJButton dateJButton = new DateChooserJButton();
	
	// �������
	JPanel jpanel1 = new JPanel();
	JPanel jpanel2 = new JPanel();
	JPanel jpanel3 = new JPanel();

	public void init() throws Exception {
		// ����������ť
		//��ȡ���й�Ӧ�̱��
		Object[] str = purchaseMasterService.getSupplierID();
		/*Object str2 ;
		for(int i = 0;i < str1.length;i++) {
			if(str1[i].equals(customer.getSalesManID())) {
				str = str1[i];
				str1[i] = str1[0];
				str1[0] = str;	
			}
		}*/
		JComboBox<Object> jcomboBox = new JComboBox<>(str);
		
		//�������
		Object[] columnName = {"��Ʒ���","����","����","���" };
		//Object[][] tableData = new Object[5][6];
		//��ȡ����
		//��ӽ����ʼ����
		Object[] str1 = purchaseMasterService.getPurchaseID(str[0]);
				for(int s = 0;s < str1.length;s++) {
			       System.out.println("==============");
					System.out.println(str1[s]);
					tableData = purchaseDetailService.getPurchaseDetail(str1[s]);
					model = new DefaultTableModel(tableData, columnName);
				}
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(600, 400));
		
		// ��ӵ�һ��������
		jpanel1.add(lastButton);
		jpanel1.add(nextButton);
		jpanel1.add(exitButton);
		// ��ӵڶ���������
	    jpanel2.add(label_purchaseID);
		jpanel2.add(label_allPurchaseAmount);
		jpanel2.add(label_purchaseDate);
		jpanel2.add(label_SupplierID);

		jpanel2.add(field_allPurchaseAmount);
		jpanel2.add(field_purchaseID);
		jpanel2.add(jcomboBox);
		jpanel2.add(dateJButton);

		jpanel2.add(addButton);
		jpanel2.add(deleteButton);
		jpanel2.add(updateButton);
		jpanel2.add(findButton);
		
		//��ӵ���������
		jpanel3.add(scrollPane);

		jpanel1.setLayout(null);
		lastButton.setBounds(60,20, 75, 30);
		nextButton.setBounds(150,20, 75, 30);
		exitButton.setBounds(240,20, 75, 30);
		
		jpanel2.setLayout(null);
		label_purchaseID.setBounds(380, 120, 75, 30);
		label_allPurchaseAmount.setBounds(380, 170, 75, 30);
		label_purchaseDate.setBounds(70, 170, 75, 30);
		label_SupplierID.setBounds(70, 120, 75, 30);

		field_allPurchaseAmount.setBounds(450, 170, 175, 30);
		field_purchaseID.setBounds(450, 120, 175, 30);
		jcomboBox.setBounds(150, 120, 175, 30);
		dateJButton.setBounds(150, 170, 175, 30);

		addButton.setBounds(270, 220, 75, 30);
		deleteButton.setBounds(360, 220, 75, 30);
		updateButton.setBounds(450, 220, 75, 30);
		findButton.setBounds(540, 220, 75, 30);
		
		jframe.add(jpanel1);
		jframe.add(jpanel2);
		jframe.add(jpanel3,BorderLayout.SOUTH);
		jpanel1.setBounds(10, 10, 600, 100);
		jpanel2.setBounds(10, 105, 600, 200);
		
		jframe.pack();
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(100, 100, 700, 750);

		
	    //����¼�
		lastButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = index ;
				if(i > 1) {
					
				}
				
			}
		});
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = index ;
				if(i < 1) {
					
				}
				
			}
		});
	}

	public static void main(String[] args) throws Exception {
		StockLogUi stockLogUi = new StockLogUi();
		stockLogUi.init();

	}
}
