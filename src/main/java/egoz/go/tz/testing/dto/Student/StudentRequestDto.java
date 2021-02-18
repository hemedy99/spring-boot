package egoz.go.tz.testing.dto.Student;

import egoz.go.tz.testing.enums.GenderEnum;
import lombok.Data;

@Data
public class StudentRequestDto {
    
    private String fullName;
    private GenderEnum gender;
}
