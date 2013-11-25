package code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile {

	public static ArrayList<String> readFile(File file) {
		
		 BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		 ArrayList<String> lines = new ArrayList<>(); 
		 String line;
		 try {
			while ((line = reader.readLine()) != null) {
			     lines.add(line);
			 }
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		 try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
		 return lines;
	}
}
