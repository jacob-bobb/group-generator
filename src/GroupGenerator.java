package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class GroupGenerator implements Students {

	private static ArrayList<Group> allGroups = new ArrayList<Group>();
	private static ArrayList<String> students = new ArrayList<String>();

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

	private static void output(String fileName, Group[] listOfGroups){
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
	
	public static void createGroup(ArrayList<String> studs, Group[] g){
		/*ArrayList<String> studentsCopy = new ArrayList<String>(studs);
		for(int i = 0; i < g.length; ++i){
			for(int j = 0; j < 3; ++j){
				int rnd = (int)(Math.random()*studentsCopy.size());
				g[i].addStudent(studentsCopy.get(rnd));
				studentsCopy.remove(rnd);
			}
		}
		System.out.println(studs); */
		
		createGroupHelper(studs, g, 0);
	}
	
	private static void createGroupHelper(ArrayList<String> studs, Group[] groups, int index){
		if(index == studs.size()){
			
		}
		else{
			for(Group g: groups){
				//add student to a group, then go to next student in list
				//if conflict, roll back
				g.addStudent(studs.get(index));
				createGroupHelper(studs, groups, index+1);
				g.removeStudent(studs.get(index));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Group[] groups = new Group[6];
		init("students.txt", groups);

		createGroup(students,groups);
		
		System.out.println(Arrays.toString(groups));
		System.out.println(students);
		System.out.println("Done.");
	}

}
