package com.example.learning.nevigator.models;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(exclude = {"enrolledSubjects", "registeredExams"})
@Table(name = "students")
public class studententity {
    
    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "studentName")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<subjectentity> enrolledSubjects = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<examentity> registeredExams = new HashSet<>();

}