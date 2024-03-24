package me.sanjeevsharma.studentms.controller;

import lombok.RequiredArgsConstructor;
import me.sanjeevsharma.studentms.entity.Student;
import me.sanjeevsharma.studentms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(
            @RequestBody Student student
        ) {
        service.saveStudent(student);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> findAllStudent() {
        return ResponseEntity.ok(service.findAllStudent());
    }

    @GetMapping("/school/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Student>> findAllStudent(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(service.findAllStudentWithSchool(schoolId));
    }
}


