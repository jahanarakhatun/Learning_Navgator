package com.example.learning.nevigator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.learning.nevigator.dto.exam;
import com.example.learning.nevigator.exception.examNotFoundexception;
//import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.exception.subjectnotregisterexception;
import com.example.learning.nevigator.models.examentity;

public interface Examrepository extends JpaRepository<examentity, Long> {

    exam createExam(long subjectId) throws subjectnotregisterexception;

    exam findExamById(long examId) throws examNotFoundexception;

    List<exam> findAllExams();

    void deleteExam(long examId) throws examNotFoundexception;
    }    

