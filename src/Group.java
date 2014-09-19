package src;

import java.util.ArrayList;
import java.lang.StringBuffer;


public class Group {
	private ArrayList<String> students;

	public Group(){
		students = new ArrayList<String>();
	}
	
	public Group(String[] studs){
		students = new ArrayList<String>();
		for(String s: studs){
			students.add(s);
		}
	}

	public boolean addStudent(String stud){
		int old = students.size();
		students.add(stud);
		return (students.size() == old + 1);
	}
	
	public boolean removeStudent(String name){
		int oldSize = students.size();
		students.remove(name);
		return students.size() == oldSize - 1;
	}

	public boolean contains(String sName){
		for(int i = 0; i < students.size(); i++){
			if(sName.equals(students.get(i))){
				return true;
			}
		}
		return false;
	}

	public String toString(){
		StringBuffer result = new StringBuffer("");
		for(String s: students){
			result.append(s);
			result.append(" "); 
		}
		result.deleteCharAt(result.length()-1);
		result.append("\n");
		return result.toString();
	}
	
	public String getStudentsForOut(){
		StringBuffer result = new StringBuffer("");
		for(int i =0; i < this.students.size(); i++){
			result.append(students.get(i));
			result.append("\n");
		}
		return result.toString();
	}

	public int size(){
		return students.size();
	}

	public String getStudent(int i){
		return students.get(i);
	}

	/* 
	 * Two groups are equal if 3 or more students
	 * are in both groups
	 */
	public boolean equals(Object other){
		int count = 0;
		if((other.getClass() == this.getClass()) && other != null){
			Group otherGroup = (Group)other;

			for(int i = 0; i < students.size(); i++){
				if(otherGroup.contains(students.get(i))){
					count++;
				}
			}
			if(count == 3){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
