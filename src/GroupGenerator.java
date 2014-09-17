package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class GroupGenerator implements Students {

	private static ArrayList<Group> allGroups = new ArrayList<Group>();
	
	private static void loadInput(String fileName) throws IOException{
		Scanner fileReader = new Scanner(new File(fileName));
		String s = "";
		while(fileReader.hasNext()){
			 s = fileReader.nextLine();
			 
			 String[] students = s.split(" ");
			 allGroups.add(new Group(students));
		}
		System.out.println(allGroups.size());
		fileReader.close();
	}
	Group[] groups = new Group[6];
	//String[] students = { 
	
	public static void main(String[] args) throws IOException {
		loadInput("students.txt");
	}

}
