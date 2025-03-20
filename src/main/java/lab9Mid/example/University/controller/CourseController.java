package lab9Mid.example.University.controller;

import lab9Mid.example.University.enitity.Course;
import lab9Mid.example.University.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping("/professor/{professorId}")
    public List<Course> getCoursesByProfessor(@PathVariable Long professorId) {
        return courseService.getCoursesByProfessorId(professorId);
    }
}
