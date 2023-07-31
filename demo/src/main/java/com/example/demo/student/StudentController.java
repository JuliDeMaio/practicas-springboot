package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired // Traduccion: cableado automatico -- Crea una instancia automatica de StudenService.
    public StudentController(StudentService studentService) {
        this.studentService = studentService; //@Autowired te evita hacer new StudentService acá.
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping (path = "{studentDni}")
    public void deleteStudent(@PathVariable ("studentDni") Long studentDni) {
        studentService.deleteStudent(studentDni);
    }

    @PutMapping(path = "{studentDni}")
    public void updateStudent(@PathVariable("studentDni") Long studentDni,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String mail) {
    studentService.updateStudent(studentDni, name, mail);
    }
}