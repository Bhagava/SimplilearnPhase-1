package pack.file;

import java.util.Comparator;

public class SortFiles implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		String str1 = (String)o1;
		String str2 = (String)o2;
		return str1.toLowerCase().compareTo(str2.toLowerCase());
	}

}
