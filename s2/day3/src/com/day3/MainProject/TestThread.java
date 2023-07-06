package com.day3.MainProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThread extends Thread{
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	private String message;
	
	public TestThread(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			try {
				log.info(i+ ": " + message);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
