package com.day3.Registro;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {
	private static File file = new File("doc/test.txt");
	private static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	
	
	public void segnaPresenze() {
		try {
			registraPresenza("Presenze:");
			System.out.println("Testo :" + leggidaFile());
			//cancellaFile();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	
	public static void registraPresenza(String testo) throws IOException {
		FileUtils.writeStringToFile(file, testo, "UTF-8", true); 
		log.info("Testo scritto su file " + file.getPath());
	}
	
	public static String leggidaFile() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
	}

	public static void cancellaFile() throws IOException {
		FileUtils.deleteQuietly(file);
		log.info("File eliminato");
	}
	
	
}
