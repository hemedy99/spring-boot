package egoz.go.tz.testing.dto.Student;

import egoz.go.tz.testing.enums.GenderEnum;
import lombok.Data;

@Data
public class StudentResponseDto {
    
    private Long id;
    private String fullName;
    private GenderEnum gender;
}
