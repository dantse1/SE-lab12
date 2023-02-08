package edu.miu.lab12.repositories;

import edu.miu.lab12.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel Tsegay Meresie
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
}
