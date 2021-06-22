package com.javaBasics.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaFileReader {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\kepatel\\Desktop\\KP.txt");

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			try {
				while ((st = br.readLine()) != null)
					System.out.println(st);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
