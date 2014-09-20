package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GroupGenerator implements Students {

	private static ArrayList<Group> allGroups = new ArrayList<Group>();
	private static ArrayList<String> students = new ArrayList<String>();
	private static List<Group> newGroups = new ArrayList<Group>();
	private static int groupSize;
	private static int plusOneCount;

	private static void init(String students, Group[] groups){
		initGroups(groups);
		initStudents(students);
		loadInput("oldGroups.txt");
	}
	
	private static void loadInput(String fileName){
		try{
			Scanner fileReader = new Scanner(new File(fileName));
			String s = "";
			while(fileReader.hasNext()){
				s = fileReader.nextLine();

				String[] students = s.split(" ");
				allGroups.add(new Group(students));
			}
			fileReader.close();

		}
		catch(FileNotFoundException e){
			System.out.println("File not found!");
			return;
		}

	}

	private static void output(String fileName, List<Group> listOfGroups){
		try {
			FileWriter fw = new FileWriter(fileName, true);
			int count = 0;
			for(Group g: listOfGroups){
				fw.write(g.toString());
			}
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	private static void initGroups(Group[] g){
		for(int i = 0; i < g.length; ++i){
			g[i] = new Group();
		}
	}

	private static void initStudents(String studentFileName){
		try{
			Scanner fileReader = new Scanner(new File(studentFileName));
			String s = "";
			while(fileReader.hasNext()){
				s = fileReader.nextLine();

				String[] studentList = s.split(",");
				for(String stud: studentList){
					students.add(stud);
				}
			}
			fileReader.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File doesn't exist!");
			return;
		}
	}
	
	public static void createGroup(ArrayList<String> studs, Group[] groups){
		ArrayList<String> studentsCopy = new ArrayList<String>(studs);
		createGroupHelper(studentsCopy, groups);
	}
	
	private static void createGroupHelper(ArrayList<String> studs, Group[] groups){
		if(studs.size() == 1){
			groups[0].addStudent(studs.get(0));
			if(isValid(groups) && noDoubles(groups)){
				newGroups = Arrays.asList(groups);
				return;
			}
		}
		else{
			for(Group g: groups){
				if(newGroups.size() == 0){
					if(g.size() != groupSize){// && g.size() != (groupSize+1)){
						int rnd = (int)(Math.random() * studs.size());
						g.addStudent(studs.get(rnd));
						String removedStudent = studs.remove(rnd);
						createGroupHelper(studs, groups);
						studs.add(removedStudent);
					}
				}
			}
		}
	}
	
	private static boolean noDoubles(Group[] newGroups){
		for(Group g: newGroups){
			for(Group oldGroup: allGroups){
				if(g.equals(oldGroup)){
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isValid(Group[] groups){
		for(Group g: groups){
			if(g.size() == 0 || g.size() < groupSize){
				System.out.println("FALSE");
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		Group[] Groups = new Group[6];
		init("students.txt", Groups);
		//String[] t = {"Jacob", "Whitney", "Jennie", "Lizzie", "Paul", "Brandon"};
		/*
		ArrayList<String> test = new ArrayList<String>();
		
		for(String s: t){
			test.add(s);
		} */
		
		groupSize = 3;
		int numGroups = students.size()/groupSize;
		plusOneCount = students.size()%groupSize;
		
		System.out.println("You will have " + numGroups + " groups: " + (numGroups-plusOneCount) + " groups of "
				+ groupSize + " and " + plusOneCount + " groups of " + (groupSize + 1));
		
		createGroup(students, Groups);
		
		StringBuffer output = new StringBuffer("");
		output.append("Your groups are:\n");
		
		for(int i = 0; i < newGroups.size(); ++i){
			output.append("Group " + (i+ 1) + ": ");
			output.append(newGroups.get(i).toString());
		}
		System.out.println(output);
		
		output("oldGroups.txt", newGroups);
		
		System.out.println("Done.");
	}

}
