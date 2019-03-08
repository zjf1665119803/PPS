package com.guigu.service;

/**
 * 客户联系人业务逻辑接口
 * @author ZJF
 *
 */

public interface CustomerContactManService {

	Object[][] getcustomerContactMan(String string) throws Exception;

	Object[][] getDeliveryData(String string)throws Exception;

}
