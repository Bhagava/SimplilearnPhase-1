package pack.file;

import exceptions.pack.FileNotFoundException;
import exceptions.pack.SearchFileNotFoundException;
import start.app.MainApp;
import start.app.WelcomeScreen;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileManipulation implements Files {
	
	 static String directory = "C:\\Users\\mamid\\eclipse-workspace\\SimplilearnProject\\Files";
	 static File file = new File(directory);
	 static ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(file.list()));

	public FileManipulation()
	{
		new WelcomeScreen().welcome();
	}
	
	
	
	boolean check = false;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void sortfiles()
	{
		FileManipulation.updateFiles();
		Collections.sort(filenames, new SortFiles()); // collections, comparator 
		filenames.forEach(System.out::println);      // Lambda function 
		MainApp.main(null);
	}
	
	
	@Override
	public void searchfile() throws SearchFileNotFoundException
	{
		System.out.println("Please enter the file name...");
		String file = sc.nextLine();
		if(filenames.contains(file))
			System.out.println("Your search file "+file +" is present in the directory"+"\n\n");
		else
			throw new SearchFileNotFoundException("Sorry, Your search file is not present in the directory"+"\n\n");
		MainApp.main(null);
	}
	
	@Override
	public void deletefile() throws FileNotFoundException
	{
		System.out.println("Please enter the file name...");
		String name = sc.nextLine();
		file = new File(directory+"\\"+name);
		if(file.delete())
			System.out.println("Successfully file "+name+" is deleted from the directory"+"\n\n");
		else
			throw new FileNotFoundException("Exception, "+name+" FileNotFound"+"\n\n");
		MainApp.main(null);
	}
	
	
	@Override
	public void addfile() 
	{
		boolean check = false;
		try {
			System.out.println("Please enter the file name..."+"\n\n");
			String name = sc.nextLine();
			file = new File(directory+"\\"+name);
			check = file.createNewFile();
			if(check) 
				System.out.println("Successfully file "+name+" is added"+"\n\n");
			else
				System.out.println("Already this "+name+" exists"+"\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			MainApp.main(null);
		}
	}
	
	public static void updateFiles()
	{
		file = new File(directory);
		filenames = new ArrayList<String>(Arrays.asList(file.list()));
	}
	
}
