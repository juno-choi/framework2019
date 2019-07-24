package com.bit.action;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class InsertAction implements Action,ModelDriven<Struts04Dto>,Preparable {

	Struts04Dto bean;
	
	public Struts04Dto getBean() {
		return bean;
	}
	
	@Override
	public String execute() throws Exception {
		new Struts04Dao().insetOne(bean);
		return this.SUCCESS;
	}

	@Override
	public Struts04Dto getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean=new Struts04Dto();
	}

	
}
