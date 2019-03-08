package com.guigu.service;

import com.guigu.pojo.Customer;
import com.guigu.pojo.Supplier;

public interface SupplierDataService {

	Object[][] getAllSupplier() throws Exception;

	Supplier getSupplier(String info)throws Exception;

	boolean addsupplier(Supplier supplier)throws Exception;

	boolean savesupplier(Supplier supplier)throws Exception;

	boolean deletesupplier(Supplier supplier)throws Exception;

}
