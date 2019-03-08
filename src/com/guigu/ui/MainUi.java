package com.guigu.ui;
/**
 * ϵͳ������
 */

import java.awt.BorderLayout;
import java.awt.CheckboxMenuItem;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.omg.CORBA.RepositoryIdHelper;

import com.guigu.pojo.User;

public class MainUi {
	static MainUi mainUi = new MainUi();
	//��������
	 static JFrame jframe = new JFrame("PPS������ϵͳ");
	//�����˵���
	private static JMenuBar mb = new JMenuBar();
	//�����˵�
	private  JMenu basicData = new JMenu("��������(D)");
	private  JMenu stockManage = new JMenu("�ɹ�����(S)");
	private  JMenu deliveryManage = new JMenu("���۹���(M)");
	private  JMenu store = new JMenu("������(O)");
	private  JMenu report = new JMenu("������(R)");
	private  JMenu hold = new JMenu("ϵͳά��(U)");
	private  JMenu help = new JMenu("����(H)");
	//�����������ϲ˵���
	private JMenuItem saleManDate = new JMenuItem("����Ա����");
	private JMenuItem customerDate = new JMenuItem("�ͻ�����");
	private JMenuItem productDate = new JMenuItem("��Ʒ����");
	private JMenuItem supplierData = new JMenuItem("��Ӧ������");
	//�ɹ�����˵���
	private JMenuItem  stockLog = new JMenuItem("�ɹ���¼��");
	private JMenuItem  stockBackLog = new JMenuItem("�˻���¼��");
	//���۹���˵���
	private JMenuItem  deliveryLog = new JMenuItem("���۵�¼��");
	private JMenuItem  deliveryBackLog = new JMenuItem("�˻���¼��");
	//������˵���
	private JMenuItem  stockQuery = new JMenuItem("����ѯ");
	//�������˵���
	private JMenuItem  stockReport = new JMenuItem("���Ԥ��");
	private JMenuItem  productReport = new JMenuItem("��Ʒ����");
	private JMenuItem  sCollectReport = new JMenuItem("�ɹ�����");
	private JMenuItem  sYearReport = new JMenuItem("�ɹ��걨��");
	//ϵͳά���˵���
	private JMenuItem  userInfo = new JMenuItem("�û����Ϲ���");
	private JMenuItem  passWordModify = new JMenuItem("�����޸�");
	//�����˵���
	private JMenuItem userHelp = new JMenuItem("����");
	private JMenuItem about = new JMenuItem("����");
	
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("�Զ�����");
	//�������
	private JPanel jpanel = new JPanel(new BorderLayout());

	
	public void init(User user) {
		// ��Ӳ˵����˵�����
		mb.add(basicData);
		//basicData.setFont(new Font("����",Font.PLAIN,20));
		mb.add(stockManage);
		mb.add(deliveryManage);
		mb.add(store);
		mb.add(report);
		mb.add(hold);
		mb.add(help);
		//��Ӳ˵���˵���
		basicData.add(saleManDate);
		basicData.add(customerDate);
		basicData.add(productDate);
		basicData.add(supplierData);
		
		stockManage.add(stockLog);
		stockManage.add(stockBackLog);
		
		deliveryManage.add(deliveryLog);
		deliveryManage.add(deliveryBackLog);
		
		store.add(stockQuery);
		
		report.add(stockReport);
		report.add(productReport);
		report.add(sCollectReport);
		report.add(sYearReport);
		
		hold.add(userInfo);
		hold.add(passWordModify);
		
		help.add(userHelp);
		help.add(about);
		
		
		jframe.setJMenuBar(mb);
		jframe.add(jpanel);

		
		jframe.pack();
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setBounds(100, 100, 800, 600);
		
		//����¼�
		
		//�������ϲ˵���
		//����Ա�����¼�
		saleManDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new SalesManUi1();
				System.out.println(user.getUserName());
				
				
			}
		});
		//�ͻ������¼�
		customerDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new CustomerDataUi1();
				
			}
		});
		
		//��Ʒ�����¼�
		productDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new ProductDataUi1();
				
			}
		});
		
		//��Ӧ������
		supplierData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new SupplierDataUi1();
				
			}
		});
		
		//������˵���
		//�������¼�
		stockQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new StockQueryUi();
				
			}
		});
		
		//ϵͳά���˵���
		//�û����Ϲ����¼�
		userInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new UserInfoUi();
				
			}
		});
		//�����޸��¼�
		passWordModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				System.out.println(user.getUserName());
				System.out.println(user.getPasswordCode());
				new PassWordModifyUi1(user);
				
			
				
			}
		});
		
		
	}
	public static void main(String[] args) {
		
		//MainUi mainUi = new MainUi();
		//mainUi.init(null);
		
		
	}
	
	
}















