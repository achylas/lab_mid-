package lab9Mid.example.University.repository;

import lab9Mid.example.University.enitity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}