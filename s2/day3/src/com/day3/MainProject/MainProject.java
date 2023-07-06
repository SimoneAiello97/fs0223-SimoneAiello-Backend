package com.day3.MainProject;

import java.io.File;
import java.lang.reflect.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day3.threads.ThreadArray;

public class MainProject {
	static Logger log = LoggerFactory.getLogger(TestThread.class);
	private static File file = new File("doc/test.txt");

	public static void main(String[] args) throws InterruptedException {
		
		//ESERCIZIO 1
		TestThread t1 = new TestThread("*");
		TestThread t2 = new TestThread("#");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		//ESERCIZIO 2
		int[] arr = generateArr(3000);
		ThreadArray t3 = new ThreadArray(arr, 0, 1000);
		ThreadArray t4 = new ThreadArray(arr, 1001, 2000);
		ThreadArray t5 = new ThreadArray(arr, 2001, 3000);
		t3.start();
		t4.start();
		t5.start();
		
		t3.join();
		t4.join();
		t5.join();
		
		sommaArray(t3,t4,t5);
		
		//ESERCIZIO 3
		

	}
	
	public static int[] generateArr(int lenght) {
		int[] arr = new int[lenght];
		 for (int i = 0; i < lenght; i++) {
	            arr[i] = (int) (Math.random() * 100);
	        }
		 return arr;
		
	}

	public synchronized static  void sommaArray(ThreadArray t3,ThreadArray t4,ThreadArray t5) {
		log.info("Somma di tutti i thread: " + (t3.getSum()+t4.getSum()+t5.getSum()));
	}
}
