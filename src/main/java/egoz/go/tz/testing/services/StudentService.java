package egoz.go.tz.testing.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import egoz.go.tz.testing.models.Student;
import egoz.go.tz.testing.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student saveStudent(Student s){
        return studentRepository.save(s);

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }


    public Optional<Student> getStudentById(Long id){
       return studentRepository.findById(id); 
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
    
}
