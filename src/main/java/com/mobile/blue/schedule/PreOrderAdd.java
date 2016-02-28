package com.mobile.blue.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PreOrderAdd {
	private Log log = LogFactory.getLog(this.getClass());
	//定时扫描用户预强的设置信息
	public void preOrder(){
		log.info(this.getClass()+"log start");
		
		log.info(this.getClass()+"log end");
	}
}
