package me.sanjeevsharma.schoolms.service;

import lombok.RequiredArgsConstructor;
import me.sanjeevsharma.schoolms.client.StudentClient;
import me.sanjeevsharma.schoolms.entity.School;
import me.sanjeevsharma.schoolms.model.SchoolWithStudents;
import me.sanjeevsharma.schoolms.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        repository.save(school);
    }

    public List<School> findAllSchool() {
        return repository.findAll();
    }

    public SchoolWithStudents findAllSchoolWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(
                        School
                                .builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build());

        var students = studentClient.findStudentsBySchool(schoolId);
        return SchoolWithStudents.builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
