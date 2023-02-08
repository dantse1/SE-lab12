package edu.miu.lab12.services.implementations;

import edu.miu.lab12.models.Student;
import edu.miu.lab12.repositories.StudentRepository;
import edu.miu.lab12.services.IStudent;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Service
public class StudentService implements IStudent{
   
    @Autowired
    private StudentRepository studentRepository;
   
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Student student) {
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    
}
