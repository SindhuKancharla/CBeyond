package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetDiffOfLists {
	
	public static void main(String[] args) throws IOException{
	
		File file = new File("resources/Output/KeywordsComplete.txt");
		List<String> list1 = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while ((line = br.readLine()) != null) {	
				list1.add(line);
		}
		br.close();
		
		File file2 = new File("resources/Output/KeywordsNew.txt");
		List<String> list2 = new ArrayList<>();
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		String line2;
		while ((line2 = br2.readLine()) != null) {	
				list2.add(line2);
		}
		br2.close();
		
		
		list1.removeAll(list2);
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Output/KeywordsDiff.txt"));
		for (String unique : list1) {
		        writer.write(unique);
		        writer.newLine();
		    }
		writer.close();
		
	}
	
}
