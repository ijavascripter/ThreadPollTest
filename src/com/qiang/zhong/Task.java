package com.qiang.zhong;

public class Task extends TaskLoad {
	
	@Override
	public boolean load() {
		System.out.println("ʹ�ý��̣�"+Thread.currentThread().getName()+"��������");
		return false;
	}

}