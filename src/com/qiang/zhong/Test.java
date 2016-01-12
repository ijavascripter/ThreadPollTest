package com.qiang.zhong;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		ThreadPollManager manager=ThreadPollManager.getInstance();
		manager.addArrTask(createTask());
		Thread.sleep(2000);
		manager.destory();
	//111
	}
	public static List<TaskLoad> createTask(){
		List<TaskLoad> list=new ArrayList<>();
		for(int i=0;i<20;i++){
			list.add(new Task());
		}
		return list;
	}
}
