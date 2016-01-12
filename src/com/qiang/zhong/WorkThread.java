package com.qiang.zhong;

import java.util.LinkedList;

public class WorkThread extends Thread {

	private boolean isRun=true;
	private boolean isWaing=false;
	private int taskId;
	private LinkedList<TaskLoad> list;
	public  WorkThread(int taskId,LinkedList<TaskLoad> list) {
		this.taskId=taskId;
		this.list=list;
		this.start();
	}
	@Override
	public void run() {
		while(isRun){
			TaskLoad task=null;
			synchronized (list) {
				while(isRun&&list.isEmpty()){
					try {
						list.wait(200);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(isRun){
			synchronized (list) {
				task=list.remove(0);
			}
			}
			if(task!=null){
				task.load();
			}
		}
	}
	
	
	public void stopRun(){
		isRun=false;
	}
	
	public boolean isWaing(){
		return isWaing;
		
	}
}