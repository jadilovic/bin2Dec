package vjezbe;

public class CustomHexExcep extends Exception{
	
	private String hexText;

	public CustomHexExcep(String hex){
		super("Not an hex");
		System.out.println("Text entered " + hex + " is not hexDecimal");
		hexText = hex;
	}
	
	public String getHexText(){
		return hexText;
	}
}
