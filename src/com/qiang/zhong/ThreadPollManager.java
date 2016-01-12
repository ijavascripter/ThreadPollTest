package com.qiang.zhong;

import java.util.LinkedList;
import java.util.List;

public class ThreadPollManager {

	private static ThreadPollManager instance;
	private LinkedList<TaskLoad> list = new LinkedList<TaskLoad>();
	private WorkThread[] works;
	private int workCount;

	
	
	
	
	private ThreadPollManager() {
		this(5);
	}

	
	
	
	private ThreadPollManager(int threadCount) {
		this.workCount = threadCount;
		works = new WorkThread[threadCount];
		for (int i = 0; i < threadCount; i++) {
			works[i] = new WorkThread(i, list);
		}
	}

	
	
	
	public static ThreadPollManager getInstance() {
		if (instance == null) {
			instance = new ThreadPollManager();
		}
		return instance;
	}

	
	
	
	public void addTask(TaskLoad task) {
		synchronized (list) {

			if (task != null) {
				list.add(task);
				list.notifyAll();
			}
		}
	}

	
	
	
	
	
	public void addArrTask(List<TaskLoad> lists) {
		synchronized (list) {

			for (TaskLoad load : lists) {
				list.add(load);
				list.notifyAll();
			}
		}
	}

	
	
	
	
	
	
	public void destory() {
		for (int i = 0; i < works.length; i++) {
			works[i].stopRun();
			works[i] = null;
		}
		synchronized (list) {
			list.clear();
		}
	}

}
