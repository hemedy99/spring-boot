package egoz.go.tz.testing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import egoz.go.tz.testing.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name="students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")
    @SequenceGenerator(name = "student_id", sequenceName = "student_id_sequence",initialValue = 1)
    @Column(name = "studentid", updatable = false, nullable = false)
    private Long id;

    @NonNull
    @Column(name="fullname")
    private String fullName;

    @NonNull
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;


    
}
