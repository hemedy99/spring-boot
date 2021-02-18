package egoz.go.tz.testing.web.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egoz.go.tz.testing.dto.Student.StudentRequestDto;
import egoz.go.tz.testing.dto.Student.StudentResponseDto;
import javassist.NotFoundException;

@RequestMapping("/student")
public interface StudentApi {
    
    //Saving
    @RequestMapping(value = "/save",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<StudentResponseDto> saveStudent(@RequestBody StudentRequestDto student);


    //Get All Students
    @RequestMapping(value="/list",method=RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<StudentResponseDto>> listStudent();

    //GetBy ID
    @RequestMapping(value="/", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<StudentResponseDto> searchById(@RequestParam Long id)throws NotFoundException;

    //Update
    @RequestMapping(value="/", method = RequestMethod.PUT, produces="application/json",consumes="application/json")
    public ResponseEntity<StudentResponseDto> UpdateUser(@RequestParam Long id, @RequestBody StudentRequestDto student)throws NotFoundException;

}
