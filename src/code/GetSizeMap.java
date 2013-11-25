package code;

import java.util.Arrays;

public class GetSizeMap {

	static String[] small = {"Small","small","S"};
	static String[] large = {"Large","large","L"};
	static String[] medium = {"Medium","medium","M"};
	static String[] X_large = {"XL"};
	static String[] X_small = {"XS","X-Small","XSmall"};
	
	public static String getSizeMap(String size){
		
		String map = null;
		if(size!=null){
			size = size.trim();
			if( size.contains("One"))
				map = "One-Size";
			if(Arrays.asList(small).contains(size))
				map = "Small";
			else if(Arrays.asList(large).contains(size))
				map = "Large";
			else if(Arrays.asList(medium).contains(size))
				map = "Medium";
			else if(Arrays.asList(X_large).contains(size))
				map = "X-Large";
			else if(Arrays.asList(X_small).contains(size))
				map = "X-Small";
			else
				map = "";
		}
		return map;
	}
}
