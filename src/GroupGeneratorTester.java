package src;

public class GroupGeneratorTester {

	private static void printPass(int testNum){
		System.out.println("-------------PASSED TEST " + testNum + " -------------");
	}
	
	private static void printFail(String expected, String actual, int testNum){
		System.out.println("-------------FAILED TEST " + testNum + " -------------\n" +
				"expected:\n" + expected + "\nactual:\n" + actual);
	}
	
	private static void printFail(boolean expected, boolean actual, int testNum){
		System.out.println("-------------FAILED TEST " + testNum + " -------------\n" +
				"expected: " + expected + "\nactual: " + actual);
	}
	
	public static void main(String[] args) {
		Group g1 = new Group();
		g1.addStudent("Jacob");
		g1.addStudent("Whitney");
		g1.addStudent("Jennie");
		
		//Test 1
		String expected = "Jacob\nWhitney\nJennie\n";
		String actual = g1.getStudents();
		if(actual.equals(expected)){
			printPass(1);
		}
		else{
			printFail(expected, actual, 1);
		}
		
		//Test 2
		
		boolean bExpected = true;
		boolean bActual = g1.contains("Jacob");
		if(bActual == bExpected){
			printPass(2);
		}
		else{
			printFail(bExpected, bActual, 2);
		}
		
		//Test 3
		bActual = g1.contains("Liz");
		if(!(bActual == bExpected)){
			printPass(3);
		}
		else{
			printFail(bExpected, bActual, 3);
		}
		
		
		Group g2 = new Group();
		g2.addStudent("Lizzy");
		g2.addStudent("Kate");
		g2.addStudent("Annie");
		
		Group g3 = new Group();
		g3.addStudent("Jacob");
		g3.addStudent("Whitney");
		g3.addStudent("Jennie");
		
		//Test 4
		bExpected = false;
		if(!(bActual = g1.equals(g2))){
			printPass(4);
		}
		else{
			printFail(bExpected, bActual, 4);
		}
		
		//Test 5
		bExpected = true;
		if((bActual = g1.equals(g3))){
			printPass(5);
		}
		else{
			printFail(bExpected, bActual, 5);
		}
		
		//Test 6
		g3.addStudent("Jesse");
		if((bActual = g1.equals(g3))){
			printPass(6);
		}
		else{
			printFail(bExpected, bActual, 6);
		}
		
		//Test 7
		bExpected = false;
		Group g4 = new Group();
		g4.addStudent("Lizzy");
		g4.addStudent("Annie");
		g4.addStudent("Paul");
		
		if(!(bActual = g2.equals(g4))){
			printPass(7);
		}
		else{
			printFail(bExpected, bActual, 7);
		}
	}

}
