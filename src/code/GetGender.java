package code;

public class GetGender {

	public static String getGender(String value) {
		String gender = null;
		String[] str = {"Boys","Boys-Toddlers","Boy-Toddler","Girls","Girl-Toddler","Men","Women"};
	
		value=value.trim();
	
			if(value.equalsIgnoreCase(str[0])) {
				gender = "boys";
			}
			else if(value.equalsIgnoreCase(str[1])) {
				gender = "baby-boys";
			}
			else if(value.equalsIgnoreCase(str[2])){
				gender = "baby-boys";
			}
			else if(value.equalsIgnoreCase(str[3])) {
				gender = "girls";
			}
			else if(value.equalsIgnoreCase(str[4])) {
				gender = "baby-girls";
			}
			else if(value.equalsIgnoreCase(str[5])) {
				gender = "mens";
			}
			else if(value.equalsIgnoreCase(str[6])) {
				gender = "womens";
			}
			else {
				gender = "unisex";
			}
			return gender;
	}
}
