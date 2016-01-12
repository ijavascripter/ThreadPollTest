package com.qiang.zhong;

public class Task extends TaskLoad {
	
	@Override
	public boolean load() {
		System.out.println("使用进程："+Thread.currentThread().getName()+"运行了我");
		return false;
	}

}
