package exceptions.pack;

@SuppressWarnings("serial")
public class FileNotFoundException extends Exception{

	public FileNotFoundException(String enduser) {
		super(enduser);
	}
}
