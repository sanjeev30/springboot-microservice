package me.sanjeevsharma.schoolms.controller;

import lombok.RequiredArgsConstructor;
import me.sanjeevsharma.schoolms.entity.School;
import me.sanjeevsharma.schoolms.model.SchoolWithStudents;
import me.sanjeevsharma.schoolms.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveSchool(
            @RequestBody School school
    ) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchool());
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<SchoolWithStudents> findAllSchools(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(service.findAllSchoolWithStudents(schoolId));
    }
}
