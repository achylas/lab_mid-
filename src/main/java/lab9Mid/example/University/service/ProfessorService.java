package lab9Mid.example.University.service;

import lab9Mid.example.University.enitity.Professor;
import lab9Mid.example.University.enitity.Course;
import lab9Mid.example.University.repository.ProfessorRepository;
import lab9Mid.example.University.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;

    public ProfessorService(ProfessorRepository professorRepository, CourseRepository courseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor assignCoursesToProfessor(Long professorId, List<Long> courseIds) {
        Optional<Professor> optionalProfessor = professorRepository.findById(professorId);
        if (optionalProfessor.isEmpty()) {
            throw new RuntimeException("Professor not found");
        }

        Professor professor = optionalProfessor.get();
        List<Course> courses = courseRepository.findAllById(courseIds);

        professor.setCourses(courses);
        return professorRepository.save(professor);
    }
}
