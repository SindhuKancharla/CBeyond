package code;

import java.util.Arrays;

public class GetColorMap {

	static String[] Beige = {"Beige" ,"Dark Beige" ,"Dark Peach","Peach Puff","Pale Peach","Cream"
		,"Peach-Puff","peach"};
	
	static String[] Black = {"Black" ,"Olive Black", "Black-828HD068" , "Black-828HD034"
		, "Black-828HD025" , "Black-828FN007" ,"Black-828JY014" ,"Super Dark","dark"};
	
	static String[] Blue = {"Dodger Blue", "Light Steel Blue","Dark Blue","Blue Berry"
		,"Pale Blue","Slate Blue", "Tiffany Blue", "Light Blue","Whipple Blue","Crystal Blue"
		,"Cornflower Blue","Steel Blue", "Cloudy Blue","Violet-Blue","Blue Berry", "Baby Blue"
		, "Royal Blue" , "Blue-Violet" ,"Aqua Blue" ,"Powder Blue" , "Very Light Blue"
		, "Dark/Light Blue" , "Medium Slate Blue" ,"Super Light Blue" , "Bright Blue"
		, "Super Dark Blue" , "Medium Blue" , "Faded Blue" , "Sky Blue" , "Blue" , "Navy"
		,"Aquamarine", "aqua","Denim" ,"mint cream","Light Teal","Dark Mint","Jade","Dark Teal"
		,"Dark Cyan","Teal","mint"};
	
	static String[] Bronze = {"Bronze"};
	
	static String[] Brown = {"Rosy-Brown","Saddle Brown","Mahogany Brown",
		"Dark Chocolate Brown" ,"Pale Brown" , "Rosy Brown","Brown" ,"Light Brown", 
		"Dark Brown" ,"Sandy Brown" ,"Latte Brown","Faded Brown"
		, "Rosie Brown", "Cherry Brown","Chocolate Browm" , "Chocolate" , "Dark Br own"
		,"Chestnut","Caramel","Peru","Khaki","Mahogany","Tan","Almond","Sienna"
		,"Brick","Camel","Sandy","Camo","sand","Mocha"} ;
	
	static String[] Gold = {"Gold" , "Golden" , "Inca Gold" , "Goldenrod" ,"Champagne"};
	
	static String[] Green = {"Green" , "Sea-Green" , "Pale Green" , "Lime Green","Bright Green",
		"Lime-Green","Yellow-Green","Pale Lime Green","Neon Green","Olive Green","Drab Green",
		"Dark Green","Sea Green","Forrest Green","Hunter Green","Mint Green","lime-green",
				"Light Sea Green" , "Neon Yellow-Green" ,"Light Green" ,"Forest Green"
				,"Spring Green","Lime-Gree","Olive","Pale Olive","Dark Olive" , "Olive Drab"
				, "lime","Lemon","Key Lime","Neon Lime","Dark Emerald" ,"Thyme","Natural"
				,"Emerald","pistachio","Spearmint","Pale Lime"};
	
	static String[] Grey = {"Grey" , "Light Gray" , "Dark Grey" ,"Light Grey" , "Steel Grey"
		, "Dim Grey" , "Slate Grey" ,"Dark Slate Grey" , "Gray" , "Dark Gray","Charcoal"
		,"Pewter","Dark Taupe","taupe"};
	
	static String[] Metallic = {"Metallic Black" , "Metallic Bronze" , "Metallic Ivory" , 
		"Metallic White" , "Metallic Pink" , "Metallic Magenta" , "Metallic Charcoal"};
	
	static String[] Multicoloured = {"Multicolor" ,"Multi-Color" ,"multi-color"  , 
		"flowy color" , "tri-color" , "Dark Multi-Color" , "Multicolored" , "Multi" , 
		"Light Multicolor" , "Rainbow"};
	
	static String[] Off_White ={"Off White" , "Ivory","Pearl"};
	
	static String[] Orange = {"Bright Orange" , "Burnt Orange" , "Dark Orange" , "Brick Orange" , 
		"Neon Orange" , "Deep Orange" , "Pale Orange" , "Orange Multi" , 
		"Orange" ,"Orange Peel" ,"Tangerine"};
	
	static String[] Pink = {"Pink" , "Neon Pink" , "Hot Pink Teal" ,"Light Pink" , "Pale Pink" ,
		"Pink Pastel" , "Bubblegum Pink" , "Rusty Pink" , "Dark Pink" , "Dusty Pink" ,
		"Brink Pink" ,"Pink Multi", "salmon","Pnk","Raspberry","Light Salmon","Fandango",
		"Berry","rose","bright rose","Wild Aster","Soft rose","Thulian","Pale Rose"
		,"Dark Salmon","Misty Rose"} ;
	
	static String[] Purple = {"Purple" , "Pale Purple" , "Violet" , "Lavender" ,"Dark Purple"
		, "Deep Purple" , "Light Purple" ,"lilac","Pale Lilac","Lila" , "Dark Indigo" ,
		"Thistle","Dark Violet","Orchid","Soft Lavender","Plum","Mauve","Indigo"};
	
	static String[] Red = {"Burnt Red" ,"Victorian Red" , "Indian Red","Coral Red" , 
		"Tomato Red" , "Bright Red" , "Scarlet Red" , "Pale Red" , "Faded Red" , "Orange-Red" ,
		"Red" ,"Maroon","Burgundy","Neon Coral","Cerise","Neon","Light Magenta","Fandanngo",
		"Fuchsa","Carmine","Deep Carmine","Fandango","Vermilion","Barberry","Blood Wine"
		,"Acid","Dark Coral","Light Coral","Coral,wine","Crimson","Dark Magenta","Fuchsia"};
	
	static String[] Silver = {"Silver" , "Siver"};
	static String[] Transparent = {"Nude"};
	static String[] Turquoise = {"Turquoise" , "Dark Turquoise"};
	static String[] White = {"White", "Bright White" , "Cornsilk","Snow","Burlywood","Whie"};
	static String[] Yellow = {"Yellow", "Bright Yellow" , "Light Yellow" , "Neon Yellow" , "Yellow-Lime" ,"Mustard","blush"};
	
	public static String getColorMap(String color){
		
		String map = null;
		color = color.trim();
		if(color.contains(",") | color.contains("And") | color.contains("/")){
			map = "Multicoloured";
		}
		else{
			if(Arrays.asList(Beige).contains(color))
				map = "Beige";
			else if(Arrays.asList(Black).contains(color))
				map = "Black";
			else if(Arrays.asList(Blue).contains(color))
				map = "Blue";
			else if(Arrays.asList(Bronze).contains(color))
				map = "Bronze";
			else if(Arrays.asList(Gold).contains(color))
				map = "Gold";
			else if(Arrays.asList(Green).contains(color))
				map = "Green";
			else if(Arrays.asList(Grey).contains(color))
				map = "Grey";
			else if(Arrays.asList(Metallic).contains(color))
				map = "Metallic";
			else if(Arrays.asList(Multicoloured).contains(color))
				map = "Multicoloured";
			else if(Arrays.asList(Off_White).contains(color))
				map = "Off-White";
			else if(Arrays.asList(Orange).contains(color))
				map = "Orange";
			else if(Arrays.asList(Pink).contains(color))
				map = "Pink";
			else if(Arrays.asList(Purple).contains(color))
				map = "Purple";
			else if(Arrays.asList(Red).contains(color))
				map = "Red";
			else if(Arrays.asList(Silver).contains(color))
				map = "Silver";
			else if(Arrays.asList(Transparent).contains(color))
				map = "Transparent";
			else if(Arrays.asList(Turquoise).contains(color))
				map = "Turquoise";
			else if(Arrays.asList(White).contains(color))
				map = "White";
			else if(Arrays.asList(Yellow).contains(color))
				map = "Yellow";
		}
		
		return map;
	}
}
