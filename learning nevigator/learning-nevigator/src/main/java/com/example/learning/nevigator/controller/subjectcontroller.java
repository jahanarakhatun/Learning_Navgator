package com.example.learning.nevigator.controller;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(SubjectController.SUBJECT_API_ENDPOINT)
public class subjectcontroller {
    
 public static final String SUBJECT_API_ENDPOINT = "/subjects";

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@Valid @RequestBody CreateSubjectRequest createSubjectRequest) {
        Subject subject = subjectService.createSubject(createSubjectRequest);
        return ResponseEntity.ok().body(subject);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable(value = "subjectId") long subjectId) throws SubjectNotFoundException {
        Subject subject = subjectService.findSubjectById(subjectId);
        return ResponseEntity.ok().body(subject);
    }

    @GetMapping
    public ResponseEntity<GetAllSubjectsResponse> getAllSubjects() {
        List<Subject> subjects = subjectService.findAllSubjects();
        GetAllSubjectsResponse getAllSubjectsResponse = new GetAllSubjectsResponse(subjects);
        return ResponseEntity.ok().body(getAllSubjectsResponse);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable long subjectId) throws SubjectNotFoundException {
        String message = "Successfully deleted subject with ID: " + String.valueOf(subjectId);
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().body(message);
    }
}
