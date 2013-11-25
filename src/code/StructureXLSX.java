package code;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gate.Annotation;
import gate.AnnotationSet;
import gate.Corpus;
import gate.CorpusController;
import gate.Document;
import gate.Factory;
import gate.creole.ExecutionException;
import gate.creole.ResourceInstantiationException;
import gate.gui.MainFrame;
import gate.util.GateException;

public class StructureXLSX {

	static String fileName = "resources/Input/Source_File.xlsx";
	static int rowNum = 0;
	static int sheetNumber =0;
						
	
	static String[] fields = {"CARE_INSTRUCTIONS","MATERIAL","MODEL_WEARING_SIZE","MODEL_SPECS","MANUFACTURER","Bust",
				 "Waist","Hips","Chest","Height","Season","Tags","Color","Made_in","GENDER","FinalGender",
				 "Name","Description","Wash_Type","Dry_Type"};
	
	public static void main(String[] args) throws IOException, ResourceInstantiationException{
		
		FileWriter fstream = null;
		try {
			fstream = new FileWriter(new File("resources/Output/Tags.txt"));
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		 
		BufferedWriter buf = new BufferedWriter(fstream);
		
		Properties props = System.getProperties();

    	props.setProperty("gate.home", "F:/gate/");
        props.setProperty("gate.plugins.home", "F:/gate/plugins");
         	
     	System.setProperties(props);
    	try {
			gate.Gate.init();
		} catch (GateException e) {
			e.printStackTrace();
		}
    	MainFrame.getInstance().setVisible(true);

    	System.out.println("GATE initialized !!!");

    	
    	FileInputStream file = null;
		try {
			file = new FileInputStream(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	    XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	   
    	readFromExcel(workbook,buf);

		System.out.println("DONE");
		String opfile = "resources/Output/OutputDescNew.xlsx";

		  try
	        {
	            FileOutputStream out = new FileOutputStream(new File(opfile));
	            workbook.write(out);
	            out.close();
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		  buf.close();
		  stripDuplicatesFromFile("resources/Output/Tags.txt");
	}
	
	public static void stripDuplicatesFromFile(String filename) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    Set<String> lines = new HashSet<String>(); 
	    String line;
	    while ((line = reader.readLine()) != null) {
	        lines.add(line);
	    }
	    reader.close();
	    BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Output/TagsComplete.txt"));
	    for (String unique : lines) {
	        writer.write(unique);
	        writer.newLine();
	    }
	    writer.close();
	}
	
	public static void readFromExcel(XSSFWorkbook workbook, BufferedWriter buf) throws IOException, ResourceInstantiationException{
        InputStream input = new BufferedInputStream(
                    new FileInputStream(fileName));
        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);
       
        int counterOfRows = 0;
        int c = 0;
        Iterator<Row> rows = sheet.rowIterator();
        int totalNumOfRows = sheet.getLastRowNum();
        XSSFSheet sheetNew = workbook.getSheetAt(0);

		Corpus corpus = Factory.newCorpus("Corpus");
        
		CorpusController controller = null;
		try {
			controller = GetCreoleControllerForDescParsing.createController();
		} catch (GateException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        while( rows.hasNext() ) {  
        
        	List<Integer> rowNums = new ArrayList<>();
        	
        	if(counterOfRows <1000) {
            	counterOfRows++;

        		XSSFRow row = (XSSFRow) rows.next();
        		int rownum = row.getRowNum();
        		rowNums.add(rownum);
        		String desc = null;
        	    try{        
        	    	Cell cellNow = row.getCell(36);
        	    	if(cellNow.getCellType()==XSSFCell.CELL_TYPE_STRING) { 
            	    	desc = cellNow.getRichStringCellValue().toString();
            	    	desc = desc.replaceAll("Maria-", "Maria");
            	    	desc = desc.replaceAll("Alina-", "Alina");
            	    } 
        	     	else if(cellNow.getCellType()==XSSFCell.CELL_TYPE_FORMULA) { 
        	     	 	desc = cellNow.getCellFormula(); 
        	     	}            		
        	    }
        	    catch(NullPointerException e)
        		{
        			desc = "...";
        		}
        	   
        	    Document doc = Factory.newDocument(desc);
				corpus.add(doc);
				if(rownum == totalNumOfRows){
					process(corpus,controller,sheetNew,buf);     
					corpus.cleanup();
				}
        	}
        	else{
        			c++;
        			System.out.println(c*1000 + "Rows Added Into Corpus ");
        		 	process(corpus,controller, sheetNew,buf);         
     				corpus.cleanup();
     				corpus = Factory.newCorpus("Corpus");
     				counterOfRows=0;
        	}
        }
	}
	
	private static void process(Corpus corpus, CorpusController controller, XSSFSheet sheet, BufferedWriter buf) {

		try {
			gate.Gate.init();
		} catch (GateException e1) {
			e1.printStackTrace();
		}
		
		controller.setCorpus(corpus);
    	try {
			controller.execute();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    	
		System.out.println("==================================================================================Annie run !!");
		List<Document> docs = new ArrayList<Document>();

		Iterator<Document> it = corpus.iterator();		
		int i=(rowNum*1000);
		rowNum++;

		while(it.hasNext()){
			
			Map<String,String> attrsOfEachDoc = new HashMap<String,String>();

			Document doc = it.next();
			docs.add(doc);
			AnnotationSet keySet = doc.getAnnotations();
			
			if(!keySet.isEmpty()){
				for(Annotation ann : keySet){

					String type = ann.getType();
					if(type.equalsIgnoreCase("Token"))
						continue;
					else if(type.equalsIgnoreCase("SpaceToken"))
						continue;
					else if(type.equalsIgnoreCase("Split"))
						continue;
					else if(type.equalsIgnoreCase("Sentence"))
						continue;
					else if(type.equalsIgnoreCase("Lookup"))
						continue;
					else if(type.equalsIgnoreCase("GENDER")){
						String value = null;
						String featureType = "FinalGender";
						String featureVal = null;
						try{
							value = ann.getFeatures().get("string").toString();
							
							featureVal = GetGender.getGender(value);
						}
						catch(NullPointerException e){
							value = "";
						}
						attrsOfEachDoc.put(featureType,featureVal);
						attrsOfEachDoc.put(type,value);
					}
					else if(type.equalsIgnoreCase("MATERIAL")){
						String value = null;
						value = ann.getFeatures().get("string").toString().trim();
						value = value.replaceAll("\\|", "/");
						
						if(value.endsWith(","))
							value = value.replaceAll(",","");
						if(value.startsWith(","))
							value = value.replaceAll(",","");
						if(value.startsWith("/"))
							value = value.replaceAll("/","");
						value = value.replaceAll(",","/");
						value = value.replaceAll("\\.","/");
						value = value.trim();
						int length = value.length();
						if(value.endsWith("/"))
							value = value.substring(0,(length-1));
						attrsOfEachDoc.put(type,value);
					}
					else{
						String value = null;
						try{
							value = ann.getFeatures().get("string").toString();
							value = value.replaceAll("&quot", "\"");
							value = value.replaceAll("\\|", ",");
							
							if(type.equalsIgnoreCase("Made_in"))
							{
								value = value.replaceAll("Start here", "NA");
								value = value.replaceAll("Chins", "China");
								value = "Made in " +value;
							}
							if(type.equalsIgnoreCase("Tags")){
								
								String[] tags = value.split(",");
								for(String tg:tags){
									try {
										tg = tg.replaceAll("\\...", "");
										tg = tg.replaceAll("\\.", "");
										tg = tg.trim();
										if(tg.equalsIgnoreCase(".")|tg.equalsIgnoreCase("...")|tg.equalsIgnoreCase("...."))
											continue;
										buf.write(tg+"\n");
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							}
						}
						catch(NullPointerException e){
							value = "";
						}
						attrsOfEachDoc.put(type,value);
					}
				}
				
				Row row = sheet.getRow(i);
				int cellnum = 40;
				for(int j=0;j<fields.length;j++){
			    	Cell cell = row.getCell(cellnum);

		    		if(i==0){
		    			if(cell == null)
		    				cell = row.createCell(cellnum);
		    			cell.setCellType(Cell.CELL_TYPE_STRING);
		    			cell.setCellValue(fields[j]);
		    		}
		    		else{
		    			if(cell == null)
		    				cell = row.createCell(cellnum);
		    			cell.setCellType(Cell.CELL_TYPE_STRING);
		    			
		    			//System.out.println("........"+attrsOfEachDoc.get(attrs[j]));
		    			
		    			if(attrsOfEachDoc.get(fields[j])!=null)
		    				cell.setCellValue(attrsOfEachDoc.get(fields[j]));
		    			else
		    				cell.setCellValue("NA");
		    			
		    			//System.out.println(attrs[j]+"==="+i+"..."+cell.getStringCellValue());
		    		}
		    		cellnum++;
		    	}
				i++;
			}
		}
		corpus.cleanup();
		cleanUp(corpus, docs);
	}
	
	
	public static void cleanUp(Corpus corp, List<Document> docs){
		
		Iterator<Document> it = docs.iterator();
		while(it.hasNext()){
			
			Document doc = it.next();
			Factory.deleteResource(doc);
		}
		Factory.deleteResource(corp);
	}
}

