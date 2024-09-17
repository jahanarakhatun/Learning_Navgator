package com.example.learning.nevigator.service;

import java.util.List;

import javax.security.auth.Subject;

import com.example.learning.nevigator.exception.subjectNotFoundexception;

public interface subjectservice {
    Subject createSubject(CreateSubjectRequest createSubjectRequest);

    Subject findSubjectById(long subjectId) throws subjectNotFoundexception;

    List<Subject> findAllSubjects();

    void deleteSubject(long subjectId) throws subjectNotFoundexception;

}
}
