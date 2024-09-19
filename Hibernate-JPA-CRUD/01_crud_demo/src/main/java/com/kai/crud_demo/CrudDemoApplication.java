package com.kai.crud_demo;

import com.kai.crud_demo.DAO.StudentDAO;
import com.kai.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			findStudent(studentDAO);

//			queryAllStudents(studentDAO);

//			queryByLastname(studentDAO);

			findAndUpdateStudent(studentDAO);
		};
	}

	private void findAndUpdateStudent(StudentDAO studentDAO) {
		// retrieve student base on id
		int studentID = 1;
		System.out.println("Getting student with ID : " + studentID);
		Student student = studentDAO.findById(studentID);

		// update firstname
		System.out.println("Updating...");
		student.setFirstname("Zukkikkii");


		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student : " + student);

	}

	private void queryByLastname(StudentDAO studentDAO) {
		// get a list of students
		List<Student> students = studentDAO.findByLastname("Iem");

		// display list of students
		for(Student s : students) {
			System.out.println(s);
		}
	}

	private void queryAllStudents(StudentDAO studentDAO) {
		// Get a list of students
		List<Student> students = studentDAO.findAllStudent();

		// Display list of students
		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void findStudent(StudentDAO studentDAO) {
		// Create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("TestStudent1", "StudentLastname", "ts1@email.com");

		// Save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int id = tempStudent.getId();
		System.out.println("Saved student. Generated id : " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id : " + id);
		Student student = studentDAO.findById(id);

		// display student
		System.out.println("Found the student with id : " + id + " : " + student);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("Jon", "Doe", "jond@email.com");
		Student tempStudent2 = new Student("Jane", "Doe", "janed@email.com");
		Student tempStudent3 = new Student("Titann", "Iem", "titann@email.com");

		// save the student objects
		System.out.println("Saving the student ....");;
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}


	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Zukkii", "Iem", "zukkii@email.com");

		// save the student object
		System.out.println("Saving the student ....");;
		studentDAO.save(tempStudent);

		// display id of the student
		System.out.println("Saved student. Generated id : " + tempStudent.getId());
	}

}
