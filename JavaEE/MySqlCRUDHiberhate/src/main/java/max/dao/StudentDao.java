package max.dao;

import java.util.List;

import max.model.Student;

public interface StudentDao {

	void saveStudent(Student student);

	void insertStudent();

	void updateStudent(Student student);

	void deleteStudent(int id);

	Student getStudent(int id);

	List<Student> getStudents();

}