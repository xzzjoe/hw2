package controller;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import student.Student;
import teacher.Teacher;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        entityManager.persist(student);
        return student;
    }

    @GetMapping("value=/")
    public List<Student> getAllStudents() {
        // Hardcoded list of students for testing
        Teacher teacher1 = new Teacher(1L, "Teacher1");

        Teacher teacher2 = new Teacher(2L, "Teacher2");


        Student student1 = new Student(1L, "Student1");
        student1.setName("John Doe");
        student1.setTeachers(Set.of(teacher1));

        Student student2 = new Student(2L, "Student2");
        student2.setName("Jane Smith");
        student2.setTeachers(Set.of(teacher2));

        // Return hardcoded list of students
        return List.of(student1, student2);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return entityManager.find(Student.class, id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setTeachers(updatedStudent.getTeachers());
            entityManager.merge(student);
        }
        return student;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        Student student = entityManager.find(Student.class, id);
        if (student != null) {
            entityManager.remove(student);
        }
    }
}

