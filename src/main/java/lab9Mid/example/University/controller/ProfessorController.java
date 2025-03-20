package lab9Mid.example.University.controller;

import lab9Mid.example.University.enitity.Professor;
import lab9Mid.example.University.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GetMapping("/{id}")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorService.getProfessorById(id);
    }

    @PostMapping
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @PostMapping("/{professorId}/assign-courses")
    public Professor assignCoursesToProfessor(@PathVariable Long professorId, @RequestBody List<Long> courseIds) {
        return professorService.assignCoursesToProfessor(professorId, courseIds);
    }
}
