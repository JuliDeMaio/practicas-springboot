package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // Se puede usar @Component, pero @Service es lo mismo y le da mas legilibidad y semantica de que es un servicio.
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByMail(student.getMail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentDni) {
        boolean exists = studentRepository.existsById(studentDni);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentDni + "does not exist");
        }
        studentRepository.deleteById(studentDni);
    }

    @Transactional
    public void updateStudent(Long studentDni, String name, String mail) {
        Student student = studentRepository.findById(studentDni).orElseThrow(() -> new IllegalStateException("student with id " + studentDni + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (mail != null && mail.length() > 0 && !Objects.equals(student.getMail(), mail)) {
            Optional<Student> studentOptional = studentRepository.findStudentByMail(mail);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setMail(mail);
        }
    }
}

