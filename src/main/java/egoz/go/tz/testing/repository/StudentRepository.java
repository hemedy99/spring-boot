package egoz.go.tz.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import egoz.go.tz.testing.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
