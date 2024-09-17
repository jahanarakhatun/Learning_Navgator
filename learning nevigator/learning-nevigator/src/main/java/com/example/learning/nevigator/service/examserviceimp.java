package com.example.learning.nevigator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.learning.nevigator.dto.exam;
//import com.example.learning.exchange.CreateExamRequest;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exchange.createExamrequest;
import com.example.learning.nevigator.models.examentity;
import com.example.learning.nevigator.repository.Examrepository;
import com.example.learning.nevigator.repository.examrepositoryservice;
//import com.example.learning.nevigator.repository.Examrepository;
import com.example.learning.nevigator.repository.subjectrepository;

public class examserviceimp implements examservice{
    @Autowired
    private examrepositoryservice examRepositoryService;

    @Override
    public exam createExam(createExamrequest createExamRequest) throws SubjectNotFoundException {
        long subjectId = createExamRequest.getSubjectId();
        exam exam = examrepositoryservice.createExam(subjectId);
        return exam;
    }

    @Override
    public exam findExamById(long examId) throws examNotFoundexception {
        exam exam = examRepositoryService.findExamById(examId);
        return exam;
    }

    @Override
    public List<exam> findAllExams() {
        List<exam> exams = examRepositoryService.findAllExams();
        return exams;
    }

    @Override
    public void deleteExam(long examId) throws examNotFoundexception {
        examRepositoryService.deleteExam(examId);
    }
    
}