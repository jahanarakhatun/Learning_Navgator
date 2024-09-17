package com.example.learning.nevigator.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.learning.nevigator.dto.student;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.examentity;
import com.example.learning.nevigator.models.studententity;
import com.example.learning.nevigator.models.subjectentity;

public class studentrepositoryservice {
    
 @Autowired
    private Studentrepository studentRepository;

    @Autowired
    private Studentrepository subjectRepository;

    @Autowired
    private Examrepository examRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;


    public student createStudent(String studentName) {
        ModelMapper modelMapper = modelMapperProvider.get();
        studententity studentEntity = new studententity();
        studentEntity.setName(studentName);
        student student = modelMapper.map(studentRepository.save(studentEntity), Student.class);
        return student;
    }

    
    public student findStudentById(long studentId) throws studentNotFoundexception {
        ModelMapper modelMapper = modelMapperProvider.get();
        Optional<studententity> maybeStudentEntity = Studentrepository.findById(studentId);
        
        if(maybeStudentEntity.isPresent()) {
            studententity studentEntity = maybeStudentEntity.get();
            // System.out.println("Enrolled Subjects: " + studentEntity.getEnrolledSubjects());
            student student = modelMapper.map(studentEntity, student.class);
            return student;
        }
        else {
            String message = "Could not find student with ID: " + String.valueOf(studentId);
            throw new studentNotFoundexception(message);
        }
    }

    
    public student enrollStudentInSubject(long studentId, long subjectId)
            throws studentNotFoundexception, subjectNotFoundexception {
        ModelMapper modelMapper = modelMapperProvider.get();
        String studentNotFoundMessage = "Could not find student with ID: " + String.valueOf(studentId);
        String subjectNotFoundMessage = "Could not find subject with ID: " + String.valueOf(subjectId);

        studententity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentNotFoundMessage));
        subjectentity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(subjectNotFoundMessage));

        Set<subjectentity> enrolledSubjects = studententity.getEnrolledSubjects();
        enrolledSubjects.add(subjectEntity);

        student student = modelMapper.map(studentRepository.save(studentEntity), student.class);
        
        return student;
    }
    public student registerStudentForExam(long studentId, long examId)
            throws studentNotFoundexception, examNotFoundexception, subjectNotFoundexception {
        ModelMapper modelMapper = modelMapperProvider.get();
        String studentNotFoundMessage = "Could not find student with ID: " + String.valueOf(studentId);
        String examNotFoundMessage = "Could not find exam with ID: " + String.valueOf(examId);

        studententity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(studentNotFoundMessage));
        examentity examEntity = Examrepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(examNotFoundMessage));
        subjectentity subjectEntity = examEntity.getSubjectEntity();

        String subjectNotEnrolledMessage = "Student has not enrolled in subject with ID: " + String.valueOf(subjectEntity.getId());

        if(isSubjectEnrolled(studentEntity, subjectEntity)) {
            Set<examentity> registeredExams = studentEntity.getRegisteredExams();
            registeredExams.add(examEntity);
            student student = modelMapper.map(studentRepository.save(studentEntity), student.class);
            return student;
        }
        else {
            throw new subjectNotFoundexception(subjectNotEnrolledMessage);
        }
    }

    
    public List<student> findAllStudents() {
        List<studententity> studentEntities = studentRepository.findAll();
        List<student> students = mapToStudentList(studentEntities);
        return students;
    }


    public void deleteStudent(long studentId) throws studentNotFoundexception {
        String message = "Could not find student with ID: " + String.valueOf(studentId);
        studententity studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(message));
        studentRepository.delete(studentEntity);
    }

    private List<student> mapToStudentList(List<studententity> studentEntities) {
        List<student> students = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(studententity studentEntity : studentEntities) {
            student student = modelMapper.map(studentEntity, student.class);
            students.add(student);
        }

        return students;
    }

    private boolean isSubjectEnrolled(studententity studentEntity, subjectentity subjectEntity) {
        Set<subjectentity> enrolledSubjects = studentEntity.getEnrolledSubjects();

        if(enrolledSubjects.contains(subjectEntity))
            return true;
        return false;
    }
    
}
