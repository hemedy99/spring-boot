package egoz.go.tz.testing.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import egoz.go.tz.testing.dto.Student.StudentRequestDto;
import egoz.go.tz.testing.dto.Student.StudentResponseDto;
import egoz.go.tz.testing.models.Student;
import egoz.go.tz.testing.services.StudentService;
import egoz.go.tz.testing.web.api.StudentApi;
import javassist.NotFoundException;


@RestController
public class StudentController implements StudentApi {

    @Autowired
    private StudentService studentService;
    

    @Transactional
    public ResponseEntity<StudentResponseDto> saveStudent(StudentRequestDto student){
        Student s = new Student();
        s.setFullName(student.getFullName());
        s.setGender(student.getGender());
        Student response = studentService.saveStudent(s);
        
        StudentResponseDto resp = new StudentResponseDto();
        resp.setId(response.getId());
        resp.setFullName(response.getFullName());
        resp.setGender(response.getGender());

        return ResponseEntity.ok(resp);

    }

    @Transactional
    public ResponseEntity<List<StudentResponseDto>> listStudent(){
        List<Student> students = studentService.getAllStudents();
        List<StudentResponseDto> studs = new ArrayList<>();
        for(Student s: students){
            StudentResponseDto sr = new StudentResponseDto();
            sr.setId(s.getId());
            sr.setFullName(s.getFullName());
            sr.setGender(s.getGender());
            studs.add(sr);
        }

        return ResponseEntity.ok(studs);
        
    }


    public ResponseEntity<StudentResponseDto> searchById(Long id)throws NotFoundException{
        Optional<Student> student = studentService.getStudentById(id);
        if(!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Student s = student.get();
        // StudentResponseDto resp = new StudentResponseDto();
        // resp.setId(s.getId());
        // resp.setFullName(s.getFullName());
        // resp.setGender(s.getGender());

        ModelMapper modelMapper = new ModelMapper();
         modelMapper.getConfiguration().setFieldMatchingEnabled(true).setAmbiguityIgnored(true);

         StudentResponseDto resp = modelMapper.map(s,StudentResponseDto.class);

        return ResponseEntity.ok(resp);

    }


    public ResponseEntity<StudentResponseDto> UpdateUser(Long id,StudentRequestDto student)throws NotFoundException{
        Optional<Student> st = studentService.getStudentById(id);
        if(!st.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Student s = st.get();
        s.setFullName(student.getFullName());
        s.setGender(student.getGender());
        studentService.saveStudent(s);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setAmbiguityIgnored(true);

        StudentResponseDto resp = modelMapper.map(s,StudentResponseDto.class);

       return ResponseEntity.ok(resp);



    }

}
