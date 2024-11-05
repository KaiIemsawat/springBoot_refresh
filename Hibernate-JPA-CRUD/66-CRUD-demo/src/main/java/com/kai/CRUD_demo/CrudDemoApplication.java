package com.kai.CRUD_demo;

import com.kai.CRUD_demo.dao.StudentDAO;
import com.kai.CRUD_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

//			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		studentDAO.deleteAll();
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		System.out.println("Deleting student id : " + studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Get student with id : " + studentId);

		Student student = studentDAO.findById(studentId);

		System.out.println("Start updating student...");
		student.setFirstName("Zukii");
		student.setEmail("zukkii@email.com");
		studentDAO.update(student);

		System.out.println("Student updated ::> " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Iem");

		for(Student student  : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAllStudents();

		for (Student st : studentList) {
			System.out.println(st);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object..");

		Student tempStudent = new Student("Biscuit", "Hampton", "bisham@email.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		int studentId = tempStudent.getId();
		System.out.println("Saved student. Generated id : " + studentId);

		System.out.println("Retrieving student with id : " + studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("The studend : " + student);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student object..");

		Student temtStudent1 = new Student("Titann", "Iem", "titann@email.com");
		Student temtStudent2 = new Student("Kinkin", "Iem", "kinkin@email.com");
		Student temtStudent3 = new Student("Stokii", "Hampton", "stokii@email.com");

		System.out.println("Saving the students....");
		studentDAO.save(temtStudent1);
		studentDAO.save(temtStudent2);
		studentDAO.save(temtStudent3);


	}


	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object..");

		Student tempStudent = new Student("Zukkii", "Iem", "zukiem@email.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id : " + tempStudent.getId());
	}

}
