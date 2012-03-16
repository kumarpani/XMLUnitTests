package org.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class TextHandler {

	public String convertStreamToString(InputStream is) {
	    try {
	        return new java.util.Scanner(is).useDelimiter("\\A").next();
	    } catch (java.util.NoSuchElementException e) {
	        return "";
	    }
	}
	
	public String getStringFromFile(String fileName) throws IOException {
		FileInputStream fstream = new FileInputStream(fileName);
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        StringWriter writer = new StringWriter();
	        char buffer[] = new char[100];
	    	
	        while (br.read(buffer) != -1) {
	            writer.write(buffer);
	            buffer = new char[100];
	        }
	        in.close();
	        br.close();
	        return writer.toString().trim();
		
	}


}
