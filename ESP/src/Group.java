import java.util.ArrayList;


public class Group {
	private ArrayList<String> students;

	public Group(){
		students = new ArrayList<String>();
	}

	public boolean addStudent(String stud){
		int old = students.size();
		students.add(stud);
		return (students.size() == old + 1);


	}

	public boolean contains(String sName){
		for(int i = 0; i < students.size(); i++){
			if(sName.equals(students.get(i))){
				return true;
			}
		}
		return false;
	}

	public void getStudents(){
		String result = "";
		for(int i =0; i < this.students.size(); i++){
			result += students.get(i) + "\n";
		}
		System.out.println(result);
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
