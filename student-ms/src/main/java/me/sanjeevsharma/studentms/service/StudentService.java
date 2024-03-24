package me.sanjeevsharma.studentms.service;

import lombok.RequiredArgsConstructor;
import me.sanjeevsharma.studentms.entity.Student;
import me.sanjeevsharma.studentms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student) {
        repository.save(student);
    }

    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    public List<Student> findAllStudentWithSchool(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}
