package pack.file;

import exceptions.pack.FileNotFoundException;
import exceptions.pack.SearchFileNotFoundException;

public interface Files {
	public void sortfiles();
	public void addfile();
	public void deletefile() throws FileNotFoundException;
	public void searchfile() throws SearchFileNotFoundException;
}
