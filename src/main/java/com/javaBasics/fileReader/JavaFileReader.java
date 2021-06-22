package com.javaBasics.fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaFileReader {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("C:\\Users\\kepatel\\Desktop\\KP.txt");
			int i;
			try {
				while ((i = fr.read()) != -1)
					System.out.print((char) i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
