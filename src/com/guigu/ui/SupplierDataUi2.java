package com.guigu.ui;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.guigu.pojo.Supplier;
import com.guigu.service.SupplierContactManService;
import com.guigu.service.SupplierDataService;
import com.guigu.service.impl.SupplierContactManServiceImpl;
import com.guigu.service.impl.SupplierDataServiceImpl;

public class SupplierDataUi2 extends JFrame{  
	
    private JTabbedPane tabbedPane;  //ѡ����
    private JPanel panel1,panel2,panel3;  //���
    
    private final int COR_COUNT = 5;
	// ����table����ģ��
	private DefaultTableModel model = null;
	private DefaultTableModel model1 = null;
	// ����JTable����
	private JTable table = null;
	private JTable table1 = null;
	// ����List�������ڱ��汻���ص���
	private List<TableColumn> hiddenList = new ArrayList<TableColumn>();
	private Object[][] tableData = null;
	private Object[][] tableData1 = null;
	private JScrollPane scrollPane = null;
	
	SupplierDataUi1 supplierDataUi1 = new SupplierDataUi1();
	SupplierDataService supplierDataService = new SupplierDataServiceImpl();
	SupplierContactManService supplierContactManService =new SupplierContactManServiceImpl();
    public SupplierDataUi2(Supplier supplier)  
    {  
        super("��Ӧ������"); 
        //setSize(400,300);  
        setBounds(400, 200, 600, 500);
        Container c = getContentPane();   //��ʼ������
        tabbedPane = new JTabbedPane();   //����ѡ�������  
        
       //������ǩ  
        JLabel label_SupplierID = new JLabel("��Ӧ�̱��");
        JLabel label_SupplierSimpleName = new JLabel("��Ӧ�̼��");
        JLabel label_SupplierName = new JLabel("��Ӧ��ȫ��");
        JLabel label_owner = new JLabel("������");
        JLabel label_title = new JLabel("�����˳�ν");
        JLabel label_telephone = new JLabel("�绰");
        JLabel label_mobilePhone = new JLabel("�ƶ��绰");
        JLabel label_fax = new JLabel("����");
        JLabel label_companyAddress = new JLabel("��˾��ַ");
        JLabel label_factoryAddress = new JLabel("������ַ");
        //�������  
        panel1=new JPanel();  
        panel2=new JPanel();  
        panel3=new JPanel();  
       //��ӱ�ǩ�����
        panel1.add(label_SupplierSimpleName);
        panel1.add(label_SupplierID);
        panel1.add(label_SupplierName);
        panel1.add(label_companyAddress);
        panel1.add(label_fax);
        panel1.add(label_factoryAddress);
        panel1.add(label_owner);
        panel1.add(label_mobilePhone);
        panel1.add(label_telephone);
        panel1.add(label_title);
        //�����ı���
        JTextField field_SupplierID = new JTextField(10);
        JTextField field_SupplierSimpleName = new JTextField(10);
        JTextField field_SupplierName = new JTextField(10);
        JTextField field_owner = new JTextField(10);
        JTextField field_title = new JTextField(10);
        JTextField field_telephone = new JTextField(10);
        JTextField field_mobilePhone = new JTextField(10);
        JTextField field_fax = new JTextField(10);
        JTextField field_companyAddress = new JTextField(10);
        JTextField field_factoryAddress = new JTextField(10);
        //����ı������
        panel1.add(field_SupplierSimpleName);
        panel1.add(field_SupplierID);
        panel1.add(field_SupplierName);
        panel1.add(field_companyAddress);
        panel1.add(field_fax);
        panel1.add(field_factoryAddress);
        panel1.add(field_owner);
        panel1.add(field_mobilePhone);
        panel1.add(field_telephone);
        panel1.add(field_title);
        // ָ����ť
    	JButton addButton = new JButton("����");
    	JButton returnButton = new JButton("ȡ��");
    	JButton saveButton = new JButton("����");
    	JButton deleteButton = new JButton("ɾ��");
    	JButton exitButton = new JButton("�˳�");
    	//��Ӱ�ť
    	panel1.add(exitButton);
		panel1.add(deleteButton);
		panel1.add(saveButton);
		panel1.add(returnButton);
		panel1.add(addButton);
        //����ǩ�����뵽ѡ���������  
        tabbedPane.addTab("��Ӧ������",null,panel1,"First panel");  
        tabbedPane.addTab("��������",null,panel2,"Second panel");  
        tabbedPane.addTab("���׼�¼",null,panel3,"Third panel");  
        //ָ��λ��
     // ʹ�þ��Զ�λ
		panel1.setLayout(null);
		// ����λ��
		label_SupplierID.setBounds(30, 30, 75, 30);
		label_title.setBounds(30, 70, 75, 30);
		label_owner.setBounds(30, 110, 75, 30);
		label_companyAddress.setBounds(30, 150, 75, 30);
		label_factoryAddress.setBounds(30, 190, 75, 30);
		
		label_SupplierSimpleName.setBounds(200, 30, 75, 30);
		label_telephone.setBounds(200, 70, 75, 30);
		label_fax.setBounds(200, 110, 75, 30);
		
		label_SupplierName.setBounds(380, 30, 75, 30);
		label_mobilePhone.setBounds(380, 70, 75, 30);
		//
		field_SupplierID.setBounds(100, 30, 95, 30);
		field_title.setBounds(100, 70, 95, 30);
		field_owner.setBounds(100, 110, 95, 30);
		field_companyAddress.setBounds(100, 150, 200, 30);
		field_factoryAddress.setBounds(100, 190, 200, 30);
		
		field_SupplierSimpleName.setBounds(270, 30, 95, 30);
		field_telephone.setBounds(270, 70, 95, 30);
		field_fax.setBounds(270, 110, 95, 30);
		
		
		field_SupplierName.setBounds(455, 30, 95, 30);
		field_mobilePhone.setBounds(455, 70, 95, 30);

		addButton.setBounds(150, 300, 60, 30);
		returnButton.setBounds(235, 300, 60, 30);
		saveButton.setBounds(320, 300, 60, 30);
		deleteButton.setBounds(405, 300, 60, 30);
		exitButton.setBounds(485, 300, 60, 30);

        c.add(tabbedPane);  
        c.setBackground(Color.white);  
        setVisible(true);  
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	supplierDataUi1.setEnabled(true);
            	supplierDataUi1.setVisible(true);
            }
        });
        //��ȡ��Ϣ
         field_SupplierID.setText(supplier.getSupplierID().trim());
         field_SupplierSimpleName.setText(supplier.getSupplierSimpleName().trim());
         field_SupplierName.setText(supplier.getSupplierName());
         field_owner.setText(supplier.getOwner());
         field_title.setText(supplier.getTitle());
         field_telephone.setText(supplier.getTelephone());
         field_mobilePhone.setText(supplier.getMobilePhone());
         field_fax.setText(supplier.getFax());
         field_companyAddress.setText(supplier.getCompanyAddress());
         field_factoryAddress.setText(supplier.getFactoryAddress());
        
     // ��ӵڶ���ǩ���
    	
		Object[] columnName = {"���","��������", "Ӣ������", "��ϵ�˳�ν", "�绰", "�ƶ��绰" };
		model = new DefaultTableModel(6, 4);
		//Object[][] tableData = new Object[3][6];

		try {
			tableData = supplierContactManService.getsupplierContactMan(supplier.getSupplierID());
			if(tableData == null) {
				tableData = new Object[0][0];
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		

		table = new JTable(tableData, columnName);
		panel2.add(new JScrollPane(table), BorderLayout.NORTH);

		// ��ӵ�����ǩ�ı��
		Object[] columnName1 = { "���ݱ��", "�ɹ�������", "��������","��Ʊ��","�ܽ��" };
		model = new DefaultTableModel();
	    //Object[][] tableData1 = new Object[3][5];
		try {
			tableData1 = supplierContactManService.getDeliveryData(supplier.getSupplierID());
			if(tableData1 == null) {
				tableData1 = new Object[0][0];
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		table1 = new JTable(tableData1, columnName1);
		panel3.add(new JScrollPane(table1), BorderLayout.NORTH);
		
		 //����¼�
		 //��һ����
	// ������ť
	addButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			supplierDataUi1.setEnabled(false);

			try {
				// ִ����������
				// ��ȡ�����Ϣ
				supplier.setSupplierID(field_SupplierID.getText().trim());
				supplier.setSupplierSimpleName(field_SupplierSimpleName.getText().trim());;
				supplier.setSupplierName(field_SupplierName.getText().trim());
				supplier.setTitle(field_title.getText().trim());
				supplier.setTelephone(field_telephone.getText().trim());
				supplier.setMobilePhone(field_mobilePhone.getText().trim());
				supplier.setOwner(field_owner.getText().trim());
				supplier.setFax(field_fax.getText().trim());
				supplier.setCompanyAddress(field_companyAddress.getText().trim());
				supplier.setFactoryAddress(field_factoryAddress.getText().trim());
				boolean result = supplierDataService.addsupplier(supplier);
				if (result) {
					supplierDataUi1.dataUpdate();
					javax.swing.JOptionPane.showMessageDialog(null, "��ӳɹ�");
				}
				supplierDataUi1.setEnabled(true);
				supplierDataUi1.repaint();
				setVisible(false); 
				supplierDataUi1.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	// ȡ����ť
	returnButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false); 

		}
	});
	// ���水ť
	saveButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			supplierDataUi1.setEnabled(false);
			try {
				// ��ȡ�޸���Ϣ
				supplier.setSupplierID(field_SupplierID.getText().trim());
				supplier.setSupplierSimpleName(field_SupplierSimpleName.getText().trim());;
				supplier.setSupplierName(field_SupplierName.getText().trim());
				supplier.setTitle(field_title.getText().trim());
				supplier.setTelephone(field_telephone.getText().trim());
				supplier.setMobilePhone(field_mobilePhone.getText().trim());
				supplier.setOwner(field_owner.getText().trim());
				supplier.setFax(field_fax.getText().trim());
				supplier.setCompanyAddress(field_companyAddress.getText().trim());
				supplier.setFactoryAddress(field_factoryAddress.getText().trim());
				boolean result = supplierDataService.savesupplier(supplier);
				if (result) {
					supplierDataUi1.dataUpdate();
					javax.swing.JOptionPane.showMessageDialog(null, "����ɹ�");
				}
				supplierDataUi1.setEnabled(true);
				supplierDataUi1.repaint();
				setVisible(false); 
				supplierDataUi1.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	// ɾ����ť
	deleteButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			supplierDataUi1.setEnabled(false);
			try {
				// ��ȡɾ��ID��Ϣ
				supplier.setSupplierID(field_SupplierID.getText().trim());
				boolean result = supplierDataService.deletesupplier(supplier);
				if (result) {
					supplierDataUi1.dataUpdate();
					javax.swing.JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}
				supplierDataUi1.setEnabled(true);
				supplierDataUi1.repaint();
				setVisible(false); 
				supplierDataUi1.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	});

	// �˳���ť
	exitButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.exit(0);
		}
	});
	
		

	}
      
    public static void main(String args[])  
    {  
    	// new SupplierDataUi2(null);  
    }  

}
