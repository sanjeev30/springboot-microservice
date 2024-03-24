package me.sanjeevsharma.schoolms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolWithStudents {

    private String name;
    private String email;
    private List<Student> students;
}
