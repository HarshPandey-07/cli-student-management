import java.util.HashMap;
import java.util.Scanner;

/*This is student management system*/

class StudentSystem{
	
	// Colors
	final static String RESET = "\033[0m";
	final static String BOLD = "\033[1m";
	final static String RED = "\033[31m";
	final static String ROSE = "\033[91m";
	final static String GREEN = "\033[92m";
	final static String BLUE = "\033[36m";
	final static String PURPLE = "\033[94m";


	Scanner in = new Scanner(System.in);
	private HashMap<Integer, Student> students = new HashMap<>();

	private class Student{
		private int id;
		private String name;
		
		Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		public String getName() {
			return name;
		}		
	}
	
	void addStudent() {
		System.out.print("Enter name of the student: ");
		String name = in.nextLine();
		System.out.print("Enter id of the student: ");
		int id = in.nextInt();
		in.nextLine();
		
		if(students.containsKey(id)) {
			System.out.println("ID already exsits!");
			return;
		}

		students.put(id, new Student(id, name));
	}

	void getStudent() {
		if(students.isEmpty()) {
			System.out.println("No record");
			return;
		}

		students.forEach((k, v) -> {System.out.println("Id: " + BOLD + k + RESET + "\tName: " + BOLD + v.getName() + RESET);});
	}
	
	void getSize() {
		System.out.println("Total amount of students: " + BOLD + students.size() + RESET);
	}
	
	void updateStudent() {
		if(students.isEmpty()) {
			System.out.println("No record");
			return;
		}
		
		System.out.print("Enter id: ");
		int id = in.nextInt();
		in.nextLine();
		
		if(!students.containsKey(id)) {
			System.out.println("Invalid ID");
			return;
		}
		
		System.out.print("Enter new name: ");
		String newName = in.nextLine();
		
		System.out.println("Element replaced: " + BOLD + BLUE + students.replace(id, new Student(id, newName)).getName() + RESET);
	}
	
	void deleteStudent() {
		if(students.isEmpty()) {
			System.out.println("No record");
			return;
		}
		
		System.out.print("Enter id: ");
		int id = in.nextInt();
		in.nextLine();

		if(!students.containsKey(id)) {
			System.out.println("Invalid ID");
			return;
		}
		
		System.out.println("Element removed: " + BOLD + RED + students.remove(id).getName() + RESET);
	}

	void menu() {
		int key;
		do {			
			System.out.println(BOLD + "\n____Student-Management-System____" + RESET);
			System.out.println(GREEN + "1.Add\t" + RESET + "2.Display\t3.Size\n" + PURPLE + "4.Update\t" + RESET + ROSE + "5.Delete\t" + RESET + RED + "6.Quit" + RESET);
			System.out.print("Enter value: ");
			key = in.nextInt();
			in.nextLine();
			switch (key) {
			case 1:
				addStudent();
				break;
			case 2:
				getStudent();
				break;
			case 3:
				getSize();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 6:
				System.out.println("Exited...");
				break;
			default:
				System.out.println("Invalid input!");
			}
		} while (key != 6);
		in.close();
	}
}

public class StudManagement {
	public static void main(String[] args) {
		StudentSystem s1 = new StudentSystem();
		s1.menu();
	}
}