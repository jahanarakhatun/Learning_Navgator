package com.example.learning.nevigator.dto;

import java.util.Set;

import javax.security.auth.Subject;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

 @Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"enrolledStudents"})
public class exam {
   
    private long id;

    private Subject subject;

    @JsonIgnore
    private Set<student> enrolledStudents;
}   
