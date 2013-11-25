package code;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

public class GetAllFeatures {

	static int rowNum = 0;
        static int sheetNumber =0;
		
	public static FileOutputStream getFeatures(String inputFileName , String outputFileName) throws IOException, ResourceInstantiationException{
			
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

            InputStream input = new BufferedInputStream(
	                    new FileInputStream(outputFileName));
	    XSSFWorkbook wbout = new XSSFWorkbook(input);
	    XSSFSheet sheetout = wbout.getSheetAt(0);

            List<String> fields = getFields(sheetout);
	    input.close();

            readFromExcel(inputFileName,wbout,fields);
	   // MainFrame.getInstance().dispose();

	    System.out.println(".....");
            FileOutputStream out = null;
	    	//String opfileName2 = "resources/Output/op.xlsx";
            try
            {
		 out = new FileOutputStream(new File(outputFileName));
		 wbout.write(out);
		 out.close();
            }
            catch (Exception e)
            {
		 e.printStackTrace();
            }
			
            System.out.println("DONE exporting all columns into output");
            return out;
        }
		
	public static void readFromExcel(String inputFileName,XSSFWorkbook wbout, List<String> fields) throws IOException, ResourceInstantiationException{
	        InputStream input = new BufferedInputStream(
	                    new FileInputStream(inputFileName));
	        XSSFWorkbook wbin = new XSSFWorkbook(input);
	        XSSFSheet sheetin = wbin.getSheetAt(0);
	        

	        int counterOfRows = 0;
	        int c = 0;
	        Iterator<Row> rows = sheetin.rowIterator();
	        int totalNumOfRows = sheetin.getLastRowNum();
	        XSSFSheet sheetout = wbout.getSheetAt(0);

		Corpus corpus = Factory.newCorpus("Corpus");
	        
		CorpusController controller = null;
		try {
			controller = GetCCAllColumns.createController();
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
                            String product_name = null;
                            String desc =null;
                            String doc_content = null;

	        	    try{        
	        	    	Cell cellNow = row.getCell(10);
	        	    	if(cellNow.getCellType()==XSSFCell.CELL_TYPE_STRING) { 
                                    product_name = cellNow.getRichStringCellValue().toString();
                                    product_name = product_name.replaceAll("\"", "");
                                }
	        	     	else if(cellNow.getCellType()==XSSFCell.CELL_TYPE_FORMULA) { 
                                    product_name = cellNow.getCellFormula();
                                    product_name = product_name.replaceAll("\"", "");
	        	     	}      
	        	    	
	        	    	cellNow = row.getCell(36);
	        	    	if(cellNow.getCellType()==XSSFCell.CELL_TYPE_STRING) { 
                                    desc = cellNow.getRichStringCellValue().toString();
                                    desc = desc.replaceAll("\"", "");
                                }
	        	     	else if(cellNow.getCellType()==XSSFCell.CELL_TYPE_FORMULA) { 
                                    desc = cellNow.getCellFormula();
                                    desc = desc.replaceAll("\"", "");
	        	     	}      
	        	    	doc_content = product_name + " \n " +desc;
	        	    }
	        	    catch(NullPointerException e)
                            {
	        		doc_content = "empty";
                            }
	        	   
	        	    Document doc = Factory.newDocument(doc_content);
                            corpus.add(doc);
                            if(rownum == totalNumOfRows){
				process(corpus,controller,sheetout,fields);     
				corpus.cleanup();
                            }
	        	}
	        	else{
                            c++;
                            System.out.println(c*1000+ "Rows Added Into Corpus ");
                            process(corpus,controller, sheetout,fields);
                            corpus.cleanup();
                            corpus = Factory.newCorpus("Corpus");
                            counterOfRows=0;
	        	}
	        }
	        input.close();
	        Factory.deleteResource(controller);
        }
		
	public static List<String> getFields(XSSFSheet sheet){
			
        	List<String> fields = new ArrayList<>();
		Row row = sheet.getRow(2);
				
        	Iterator<Cell> cells = row.cellIterator();

        	while(cells.hasNext())
        	{
        		Cell cellNow = cells.next();
        	   	fields.add(cellNow.getStringCellValue().toString());
        	}
		return fields;
	}
			 
	private static void process(Corpus corpus, CorpusController controller, XSSFSheet sheet, List<String> fields) {

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
	    	
		System.out.println("Annie run !!");
		List<Document> docs = new ArrayList<Document>();

		Iterator<Document> it = corpus.iterator();		
		int i=(rowNum*1000)+2;
		rowNum++;

		while(it.hasNext()){
			String descColor = null;
			Map<String,String> attrsOfEachDoc = new HashMap<String,String>();

			Document doc = it.next();
			docs.add(doc);
			AnnotationSet keySet = doc.getAnnotations();
				
			if(!keySet.isEmpty()){
				for(Annotation ann : keySet){
                                	String dept_name = null;
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
					else if(type.equalsIgnoreCase("Color")){
						 descColor = ann.getFeatures().get("string").toString();
					}
					else if(type.equalsIgnoreCase("GENDER")){
						String value = null;
							
						try{
							value = ann.getFeatures().get("string").toString();
							dept_name = GetGender.getGender(value);
						}
						catch(NullPointerException e){
							value = "";
						}
						attrsOfEachDoc.put("department_name",dept_name);
						}
						else if(type.equalsIgnoreCase("fabric_type1") | type.equalsIgnoreCase("bullet_point1")){
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
						else if(type.equalsIgnoreCase("country_as_labeled")|(type.equalsIgnoreCase("bullet_point2"))){
							
							String value = ann.getFeatures().get("string").toString().trim();

							value = value.replaceAll("Start here", "");
							value = value.replaceAll("Chins", "China");
							value = value.replaceAll("Chiona", "China");
							value = value.replaceAll("USA", "United States");
							value = value.replaceAll("U.S.A", "United States");
							value = value.replaceAll("Bamgladesh","Bangladesh");
							value = value.replaceAll("Maxico", "Mexico");
							value = value.replaceAll("Blangadesh","Bangladesh");
							value = value.replaceAll("Green/Black ","");
							value = value.replaceAll("Indponesia ","Indonesia");
							if(value!="")
							{
								value = "Made in " +value;
								attrsOfEachDoc.put(type,value);
							}
						}
						else
						{
							String value = null;
							try{
								value = ann.getFeatures().get("string").toString();
								value = value.replaceAll("\\|", ",");
							}
							catch(NullPointerException e){
								value = "";
							}
							if(attrsOfEachDoc.containsKey(type)){
								String temp = attrsOfEachDoc.get(type).trim();
								if(!temp.equalsIgnoreCase(value.trim()))
									temp += " | " +value;
								attrsOfEachDoc.remove(type);
								attrsOfEachDoc.put(type, temp);
							}
							else{
								attrsOfEachDoc.put(type,value);
							}				
						}
					}
					
					Row row = sheet.getRow(i);
					if(row==null)
                                            row = sheet.createRow(i);
					for(int j=0;j<fields.size();j++){
				    	Cell cell = row.getCell(j);
			    		// 86 is color_name column
				    	if(j == 86){
				    		if(cell != null){
				    			
				    			String colorOrg = cell.getStringCellValue();
				    			if(colorOrg==null){
				    				if(descColor!=null){
				    					cell.setCellValue(descColor);
				    				}
				    				else{
				    					cell.setCellValue("");
				    				}
				    			}
				    		
				    			String colorFinal = cell.getStringCellValue();
				    			String colormap = GetColorMap.getColorMap(colorFinal);
				    			cell = row.getCell(++j);
				    			// 87 is color_map column
				    			if(cell == null){
					    			cell = row.createCell(j);
					    			cell.setCellType(Cell.CELL_TYPE_STRING);
					    			cell.setCellValue(colormap);
				    			}
				    		//	cellnum++;
				    			continue;
				    		}
				    	}
				    	String cellValue = null;
			    		if(cell == null){
			    			cell = row.createCell(j);
			    			cell.setCellType(Cell.CELL_TYPE_STRING);
			    			cellValue = attrsOfEachDoc.get(fields.get(j));
			    			// 44 is the size column -bust waist and hips
			    			if(j==44  && cellValue !=null)
					    	{
					    		cellValue = cellValue.replaceAll(",","");
					    		cellValue = cellValue.replaceAll("&quot","\"");
					    	}
					    	
			    			if(attrsOfEachDoc.get(fields.get(j))!=null)
			    				cell.setCellValue(cellValue);
			    			else
			    				cell.setCellValue("");
			    		}
			    		//119 is size_name column
			    		if(j ==119){
				    		String sizeMap = GetSizeMap.getSizeMap(cellValue);
				    		//120 is size_map column
				    		cell = row.getCell(++j);
				    		if(cell == null){
				    			cell = row.createCell(j);
				    			cell.setCellType(Cell.CELL_TYPE_STRING);
				    			cell.setCellValue(sizeMap);
				    		}
				    		//cellnum++;
				    	}
			    		//cellnum++;
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