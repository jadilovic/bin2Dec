package vjezbe;

public class CustomBinExcep extends Exception {

	private String binText;
	
	public CustomBinExcep(String binText){
		super("Entered text " + binText + " is not a binary number");
		this.binText = binText;
	}
	
	public String getBin(){
		return binText;
	}
}
