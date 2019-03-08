package com.guigu.ui;
/**
 * ά����Ʒ���ϲ�������2
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
	//����ҵ���߼������
    private ProductDataService productService = new ProductDataServiceImpl();
	
	// ��������
		JFrame frame = new JFrame("��Ʒ����");

		// ����Jlabel
		JLabel label_productID = new JLabel("�ֹ����");
		JLabel label_productName = new JLabel("��Ʒ����");
		JLabel label_salefStock = new JLabel("��ȫ����");
		JLabel label_suggestBuyPrice = new JLabel("���鹺���");
		JLabel label_suggeestSalePrice = new JLabel("�������ۼ�");


		// ����JTextField
		JTextField productIDField = new JTextField();
		JTextField productNameField = new JTextField();
		JTextField salefStockField = new JTextField();
		JTextField suggestBuyPriceField = new JTextField();
		JTextField suggestSalePriceField = new JTextField();

		// ָ����ť
		JButton addButton = new JButton("����");
		JButton returnButton = new JButton("ȡ��");
		JButton saveButton = new JButton("����");
		JButton deleteButton = new JButton("ɾ��");
		JButton exitButton = new JButton("�˳�");

		public ProductDataUi2(ProductDataUi1 owner, Product product) {
			// ʹ�þ��Զ�λ
			frame.setLayout(null);
			// ����λ��
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

			// ������������
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

			// ����������С
			frame.setBounds(100, 100, 600, 300);
			// ���������ɼ�
			frame.setVisible(true);
			//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                owner.setEnabled(true);
	                owner.setVisible(true);
	            }
	        });
			//Ϊ��ť����¼�
			//������ť
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//��������Ա����1���ڲ�����
					
				    try {
				    	//ִ����������
				    	//��ȡ�����Ϣ
						product.setProductID(productIDField.getText().trim());
				    	product.setProductName(productNameField.getText().trim());
				    	//��Ҫ��string����תΪint
				    	product.setSafeStock(Integer.parseInt(salefStockField.getText().trim()));;
				    	product.setSuggestBuyPrice(Integer.parseInt(suggestBuyPriceField.getText().trim()));
				    	product.setSuggestSalePrice(Integer.parseInt(suggestSalePriceField.getText().trim()));
						boolean result = productService.addProuctData(product);
						if(result) {
							productDataUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"��ӳɹ�");
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
			//ȡ����ť
			returnButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
					
				}
			});
			//���水ť
			saveButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//��������Ա����1���ڲ�����
					  try {
					    	//ִ����������
					    	//��ȡ�����Ϣ
						    //��ȡ�����Ϣ
							product.setProductID(productIDField.getText().trim());
					    	product.setProductName(productNameField.getText().trim());
					    	//��Ҫ��string����תΪint
					    	product.setSafeStock(Integer.parseInt(salefStockField.getText().trim()));;
					    	product.setSuggestBuyPrice(Integer.parseInt(suggestBuyPriceField.getText().trim()));
					    	product.setSuggestSalePrice(Integer.parseInt(suggestSalePriceField.getText().trim()));
					    	boolean result = productService.saveProuctData(product);
					    	if(result) {
					    		productDataUi1.dataUpdate();
								javax.swing.JOptionPane.showMessageDialog(null,"����ɹ�");
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
			//ɾ����ť
			deleteButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					productDataUi1.setEnabled(false);//��������Ա����1���ڲ�����
			    	try {
			    		//��ȡɾ��ID��Ϣ
			    		product.setProductID(productIDField.getText().trim());
						boolean result = productService.deleteProuctData(product);
						if(result) {
							productDataUi1.dataUpdate();
							javax.swing.JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
							
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
			//�˳���ť
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
