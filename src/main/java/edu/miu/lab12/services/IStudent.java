package edu.miu.lab12.services;

import edu.miu.lab12.models.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Tsegay Meresie
 */
public interface IStudent {
    List<Student> getAllStudents();
    void deleteStudent(Student student);
    Student getStudentById(Integer id);
    Student addStudent(Student student);
    void deleteStudentById(Integer id);
    
}
