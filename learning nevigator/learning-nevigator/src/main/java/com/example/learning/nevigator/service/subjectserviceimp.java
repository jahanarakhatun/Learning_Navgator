package com.example.learning.nevigator.service;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;

public class subjectserviceimp implements studentservice{
    // @Autowired
   // private SubjectRepositoryService subjectRepositoryService;
@Autowired
private subjectservice subjectservice;
    @Override
    public Subject createSubject(CreateSubjectRequest createSubjectRequest) {
        String subjectName = createSubjectRequest.getSubjectName();
        Subject subject = subjectservice.createSubject(subjectName);
        return subject;
    }

    @Override
    public Subject findSubjectById(long subjectId) throws SubjectNotFoundException {
        Subject subject = subjectservice.findSubjectById(subjectId);
        return subject;
    }

    @Override
    public List<Subject> findAllSubjects() {
        List<Subject> subjects = subjectservice.findAllSubjects();
        return subjects;
    }

    @Override
    public void deleteSubject(long subjectId) throws SubjectNotFoundException {
       subjectRepositoryService.deleteSubject(subjectId);
    }
    
}
    
}
