package com.example.learning.nevigator.models;

import java.util.HashSet;
import java.util.Set;

import javax.security.auth.Subject;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EntityScan
@EqualsAndHashCode(exclude = {"enrolledStudents"})
@Table(name = "exams")
public class examentity {
    
    @Id
    @Generated(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private subjectentity subjectEntity;

    @ManyToMany(mappedBy = "registeredExams", fetch = FetchType.EAGER)
    private Set<studententity> enrolledStudents = new HashSet<>();
}
