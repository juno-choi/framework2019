package com.bit.action;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;

public class Ex03Action implements Action {
	Logger log = Logger.getLogger("com.bit.action.Ex03Action");
	String id;
	int num;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getId() {
		return id;
	}
	public int getNum() {
		return num;
	}
	
	@Override
	public String execute() throws Exception {
		log.debug("Iparam:"+id);
		
		log.debug("Nparam:"+(num*9475156));
		return this.SUCCESS;
	}
	
}
