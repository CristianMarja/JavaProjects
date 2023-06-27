package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		
		//Ask how many new users we want to add
		System.out.println("Please enter number of new students to enroll: ");
		Scanner in=new Scanner(System.in);
		int numberStudents=in.nextInt();
		Student[] students=new Student[numberStudents];
		// Create n number of new student
		for (int i = 0; i <numberStudents; i++) {
			students[i]=new Student();
			students[i].enroll();
			students[i].payTuition();
		}
		for (int i = 0; i <numberStudents; i++) {
			System.out.println(students[i].showInfo());
			
		}
	

	}

}
