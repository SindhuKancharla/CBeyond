package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDupsFromTxt {

	public static void main(String []args) throws IOException {
		
		
	    BufferedReader reader = new BufferedReader(new FileReader(new File("resources/Input/size.txt")));
	    Set<String> lines = new HashSet<String>(); 
	    String line;
	    while ((line = reader.readLine()) != null) {
	        lines.add(line);
	    }
	    reader.close();
	    BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Output/SizesComplete.txt"));
	    for (String unique : lines) {
	        writer.write(unique);
	        writer.newLine();
	    }
	    writer.close();
	}
	
}
