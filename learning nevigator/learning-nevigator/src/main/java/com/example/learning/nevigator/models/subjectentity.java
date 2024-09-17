package com.example.learning.nevigator.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@EqualsAndHashCode(exclude = {"registeredStudents"})
@Table(name = "subjects")
public class subjectentity {
    
    @Id
    @Column(name = "subjectId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  

    @Column(name = "subjectName")
    private String name;

    @ManyToMany(mappedBy = "enrolledSubjects", fetch = FetchType.EAGER)
    private Set<studententity> registeredStudents = new HashSet<>();
}
