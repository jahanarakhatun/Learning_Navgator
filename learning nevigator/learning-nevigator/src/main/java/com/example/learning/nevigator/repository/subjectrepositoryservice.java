package com.example.learning.nevigator.repository;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.subjectentity;

public class subjectrepositoryservice {
    
    @Autowired
    private Studentrepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    
    public Subject createSubject(String subjectName) {
        ModelMapper modelMapper = modelMapperProvider.get();
        subjectentity subjectEntity = new subjectentity();
        subjectEntity.setName(subjectName);

        Subject subject = modelMapper.map(subjectRepository.save(subjectEntity), Subject.class);
        return subject;
    }

    
    public Subject findSubjectById(long subjectId) throws subjectNotFoundexception {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        ModelMapper modelMapper = modelMapperProvider.get();

        subjectentity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));
        Subject subject = modelMapper.map(subjectEntity, Subject.class);
        return subject;
    }


    public List<Subject> findAllSubjects() {
        List<subjectentity> subjectEntities = subjectRepository.findAll();
        List<Subject> subjects = mapToSubjectList(subjectEntities);
        return subjects;
    }

    
    public void deleteSubject(long subjectId) throws subjectNotFoundexception {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        subjectentity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));
        subjectRepository.delete(subjectEntity);
    }

    private List<Subject> mapToSubjectList(List<subjectentity> subjectEntities) {
        List<Subject> subjects = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(subjectentity subjectEntity : subjectEntities) {
            Subject subject = modelMapper.map(subjectEntity, Subject.class);
            subjects.add(subject);
        }
        
        return subjects;
    }
    
}