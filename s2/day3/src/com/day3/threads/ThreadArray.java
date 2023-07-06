package com.day3.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day3.MainProject.TestThread;

public class ThreadArray extends Thread{
	private Logger log = LoggerFactory.getLogger(TestThread.class);
	private int[] arr;
	private int numero;
	private int endpoint;
	private int sum;
	
	public ThreadArray(int[] arr, int numero, int endpoint) {
		this.arr = arr;
		this.numero = numero;
		this.endpoint = endpoint;
		this.sum = 0;
	}

	public int getSum() {
		return sum;
	}

	@Override
	public void run() {
		for(int i = numero;i < endpoint; i++ ) {
			sum += arr[i];
		}
		log.info("Somma ottenuta: " + sum);
	}
	
	

}
