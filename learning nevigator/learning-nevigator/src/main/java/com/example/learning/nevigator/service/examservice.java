package com.example.learning.nevigator.service;

import com.example.learning.nevigator.dto.exam;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.subjectnotregisterexception;
import com.example.learning.nevigator.exchange.createExamrequest;
import com.example.learning.nevigator.models.examentity;

import java.util.List;




public interface examservice {
    exam createExam(createExamrequest createexamrequest) throws subjectnotregisterexception;

    List<exam> findAllExams();
    exam findExamById(long id) throws examNotFoundexception;



    String deleteExam(Long examId) throws examNotFoundexception;
}

