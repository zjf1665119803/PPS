package com.guigu.ui;
/**
 * 维护商品资料操作界面2
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.guigu.pojo.Product;
import com.guigu.pojo.SalesMan;
import com.guigu.service.ProductDataService;
import com.guigu.service.SalesManService;
import com.guigu.service.impl.ProductDataServiceImpl;
import com.guigu.service.impl.SalesManServiceImpl;

public class ProductDataUi2 {
	
	Product product= new Product();
	ProductDataUi1 productDataUi1 = new ProductDataUi1();
	//创建业务逻辑层对象
    private ProductDataService productService = new ProductDataServiceImpl();
	
	// 创建容器
		JFrame frame = new JFrame("商品资料");

		// 创建Jlabel
		JLabel label_productID = new JLabel("手工编号");
		JLabel label_productName = new JLabel("产品名称");
		JLabel label_salefStock = new JLabel("安全存量");
		JLabel label_suggestBuyPrice = new JLabel("建议购买价");
		JLabel label_suggeestSalePrice = new JLabel("建议销售价");


		// 创建JTextField
		JTextField productIDField = new JTextField();
		JTextField productNameField = new JTextField();
		JTextField salefStockField = new JTextField();
		JTextField suggestBuyPriceField = new JTextField();
		JTextField suggestSalePriceField = new JTextField();

		// 指定按钮
		JButton addButton = new JButton("新增");
		JButton returnButton = new JButton("取消");
		JButton saveButton = new JButton("保存");
		JButton deleteButton = new JButton("删除");
		JButton exitButton = new JButton("退出");

		public ProductDataUi2(ProductDataUi1 owner, Product product) {
			// 使用绝对定位
			frame.setLayout(null);
			// 设置位置
			label_productID.setBounds(30, 30, 75, 30);
			label_productName.setBounds(215, 30, 75, 30);
			label_salefStock.setBounds(30, 70, 75, 30);
			label_suggestBuyPrice.setBounds(215, 75, 75, 15);
			label_suggeestSalePrice.setBounds(30, 110, 75, 30);

			addButton.setBounds(120, 150, 75, 30);
			returnButton.setBounds(205, 150, 75, 30);
			saveButton.setBounds(290, 150, 75, 30);
			deleteButton.setBounds(375, 150, 75, 30);
			exitButton.setBounds(470, 150, 75, 30);

			productIDField.setBounds(100, 30, 105, 30);
			productNameField.setBounds(290, 30, 105, 30);
			salefStockField.setBounds(100, 70, 105, 30);
			suggestBuyPriceField.setBounds(290, 70, 105, 30);
			suggestSalePriceField.setBounds(100, 110, 105, 30);

			// 添加组件到容器
			frame.add(label_productID);
			frame.add(label_productName);
			frame.add(label_salefStock);
			frame.add(label_suggestBuyPrice);
			frame.add(label_suggeestSalePrice);
			frame.add(exitButton);
			frame.add(deleteButton);
			frame.add(saveButton);
			frame.add(returnButton);
			frame.add(addButton);

			frame.add(productIDField);
			frame.add(productNameField);
			frame.add(salefStockField);
			frame.add(suggestBuyPriceField);
			frame.add(suggestSalePriceField);

			// 设置容器大小
			frame.setBounds(100, 100, 600, 300);
			// 设置容器可见
			frame.setVisible(true);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                owner.setEnabled(true);
	                owner.setVisible(true);
	            }
	        });
			//为按钮添加事件
			//新增按钮
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//设置销售员资料1窗口不可用
					
				    try {
				    	//执行新增操作
				    	//获取添加信息
						product.setProductID(productIDField.getText().trim());
				    	product.setProductName(productNameField.getText().trim());
				    	//需要将string类型转为int
				    	product.setSafeStock(Integer.parseInt(salefStockField.getText().trim()));;
				    	product.setSuggestBuyPrice(Integer.parseInt(suggestBuyPriceField.getText().trim()));
				    	product.setSuggestSalePrice(Integer.parseInt(suggestSalePriceField.getText().trim()));
						boolean result = productService.addProuctData(product);
						if(result) {
							productDataUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"添加成功");
						}
						productDataUi1.setEnabled(true);
						productDataUi1.repaint();
						frame.setVisible(false);
						productDataUi1.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			//取消按钮
			returnButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					
				}
			});
			//保存按钮
			saveButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//设置销售员资料1窗口不可用
					  try {
					    	//执行新增操作
					    	//获取添加信息
						    //获取添加信息
							product.setProductID(productIDField.getText().trim());
					    	product.setProductName(productNameField.getText().trim());
					    	//需要将string类型转为int
					    	product.setSafeStock(Integer.parseInt(salefStockField.getText().trim()));;
					    	product.setSuggestBuyPrice(Integer.parseInt(suggestBuyPriceField.getText().trim()));
					    	product.setSuggestSalePrice(Integer.parseInt(suggestSalePriceField.getText().trim()));
					    	boolean result = productService.saveProuctData(product);
					    	if(result) {
					    		productDataUi1.dataUpdate();
								javax.swing.JOptionPane.showMessageDialog(null,"保存成功");
							}
					    	productDataUi1.setEnabled(true);
							productDataUi1.repaint();
							frame.setVisible(false);
							productDataUi1.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			//删除按钮
			deleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//设置销售员资料1窗口不可用
			    	try {
			    		//获取删除ID信息
			    		product.setProductID(productIDField.getText().trim());
						boolean result = productService.deleteProuctData(product);
						if(result) {
							productDataUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"删除成功");
							
						}
						productDataUi1.setEnabled(true);
						productDataUi1.repaint();
						frame.setVisible(false);
						productDataUi1.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			//退出按钮
			 exitButton.addActionListener(new ActionListener() {
		  			
		  			@Override
		  			public void actionPerformed(ActionEvent e) {
		  				
		  				System.exit(0);
		  			}
		  		});
			//init();
			productIDField.setText(product.getProductID());
			productNameField.setText(product.getProductName());
			salefStockField.setText(product.getSafeStock()+"");
			suggestBuyPriceField.setText(product.getSuggestBuyPrice()+"");
			suggestSalePriceField.setText(product.getSuggestSalePrice()+"");
		}

		public static void main(String[] args) {
			
			/*ProductDataUi2 productDataUi2 = new ProductDataUi2();
			productDataUi2.init();*/

		}

}
