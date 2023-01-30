package max;

import java.util.ArrayList;
import java.util.List;

import max.dao.StudentDao;
import max.dao.StudentDaoImpl;
import max.model.Student;

public class Main {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student("Max", "Maximys", "max@exemples.com");
		studentDao.saveStudent(student);
		Student student3 = new Student("Victori", "Vic", "Viv@exemples.com");
		studentDao.saveStudent(student3);

//		studentDao.insertStudent();

		// update student
		Student student1 = new Student("Last", "Maxim", "max@exempl.com");
		studentDao.updateStudent(student1);
		System.out.println(student1);

		// get single student
		Student student2 = studentDao.getStudent(1);
		System.out.println(student2.getFirstName());

		// delete student
		studentDao.deleteStudent(1);
		
		// get students
		List<Student> students = new ArrayList<>();
		for(Student s : studentDao.getStudents()) {
			students.add(s);
		}
		System.out.println();
		System.out.println(students);
	}

}
