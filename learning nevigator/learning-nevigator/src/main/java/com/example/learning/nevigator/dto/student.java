package com.example.learning.nevigator.dto;

import java.util.Set;

import javax.security.auth.Subject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"enrolledSubjects", "registeredExams"})
public class student {

    private long id;

    private String name;

    private Set<Subject> enrolledSubjects;

    private Set<exam> registeredExams;
    
}

