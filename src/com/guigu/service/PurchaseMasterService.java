package com.guigu.service;

import java.sql.SQLException;

import com.guigu.pojo.PurchaseMaster;

public interface PurchaseMasterService {

	Object[] getSupplierID() throws Exception;


	Object[] getPurchaseID(Object object) throws Exception;

}
