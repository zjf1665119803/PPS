package com.guigu.ui;
/**
 * 系统主界面
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
	//创建容器
	 static JFrame jframe = new JFrame("PPS进存销系统");
	//创建菜单条
	private static JMenuBar mb = new JMenuBar();
	//创建菜单
	private  JMenu basicData = new JMenu("基本资料(D)");
	private  JMenu stockManage = new JMenu("采购管理(S)");
	private  JMenu deliveryManage = new JMenu("销售管理(M)");
	private  JMenu store = new JMenu("库存管理(O)");
	private  JMenu report = new JMenu("报表导出(R)");
	private  JMenu hold = new JMenu("系统维护(U)");
	private  JMenu help = new JMenu("帮助(H)");
	//创建基本资料菜单项
	private JMenuItem saleManDate = new JMenuItem("销售员资料");
	private JMenuItem customerDate = new JMenuItem("客户资料");
	private JMenuItem productDate = new JMenuItem("商品资料");
	private JMenuItem supplierData = new JMenuItem("供应商资料");
	//采购管理菜单项
	private JMenuItem  stockLog = new JMenuItem("采购单录入");
	private JMenuItem  stockBackLog = new JMenuItem("退货单录入");
	//销售管理菜单项
	private JMenuItem  deliveryLog = new JMenuItem("销售单录入");
	private JMenuItem  deliveryBackLog = new JMenuItem("退货单录入");
	//库存管理菜单项
	private JMenuItem  stockQuery = new JMenuItem("库存查询");
	//报表导出菜单项
	private JMenuItem  stockReport = new JMenuItem("库存预警");
	private JMenuItem  productReport = new JMenuItem("商品资料");
	private JMenuItem  sCollectReport = new JMenuItem("采购汇总");
	private JMenuItem  sYearReport = new JMenuItem("采购年报表");
	//系统维护菜单项
	private JMenuItem  userInfo = new JMenuItem("用户资料管理");
	private JMenuItem  passWordModify = new JMenuItem("密码修改");
	//帮助菜单项
	private JMenuItem userHelp = new JMenuItem("帮助");
	private JMenuItem about = new JMenuItem("关于");
	
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自动换行");
	//创建面板
	private JPanel jpanel = new JPanel(new BorderLayout());

	
	public void init(User user) {
		// 添加菜单到菜单条中
		mb.add(basicData);
		//basicData.setFont(new Font("楷体",Font.PLAIN,20));
		mb.add(stockManage);
		mb.add(deliveryManage);
		mb.add(store);
		mb.add(report);
		mb.add(hold);
		mb.add(help);
		//添加菜单项到菜单中
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
		
		//添加事件
		
		//基本资料菜单项
		//销售员资料事件
		saleManDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new SalesManUi1();
				System.out.println(user.getUserName());
				
				
			}
		});
		//客户资料事件
		customerDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new CustomerDataUi1();
				
			}
		});
		
		//商品资料事件
		productDate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new ProductDataUi1();
				
			}
		});
		
		//供应商资料
		supplierData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new SupplierDataUi1();
				
			}
		});
		
		//库存管理菜单项
		//库存管理事件
		stockQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new StockQueryUi();
				
			}
		});
		
		//系统维护菜单项
		//用户资料管理事件
		userInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jframe.setEnabled(false);
				jframe.setVisible(false);
				new UserInfoUi();
				
			}
		});
		//密码修改事件
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















