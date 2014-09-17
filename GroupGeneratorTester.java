
public class GroupGeneratorTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Group g1 = new Group();
		g1.addStudent("Jacob");
		g1.addStudent("Whitney");
		g1.addStudent("Jennie");
		
		g1.getStudents();
		System.out.println(g1.contains("Jacob"));
		System.out.println(g1.contains("Lizzy"));
		
		Group g2 = new Group();
		g2.addStudent("Lizzy");
		g2.addStudent("Kate");
		g2.addStudent("Annie");
		
		Group g3 = new Group();
		g3.addStudent("Jacob");
		g3.addStudent("Whitney");
		g3.addStudent("Jennie");
		
		System.out.println("\nEquals");
		System.out.println(g1.equals(g2)); //should be false
		System.out.println(g1.equals(g3)); //should be true
		
		g3.addStudent("Jesse");
		System.out.println(g1.equals(g3)); //should still be true
		
		Group g4 = new Group();
		g4.addStudent("Lizzy");
		g4.addStudent("Annie");
		g4.addStudent("Paul");
		
		System.out.println();
		System.out.println(g2.equals(g4));

	}

}
