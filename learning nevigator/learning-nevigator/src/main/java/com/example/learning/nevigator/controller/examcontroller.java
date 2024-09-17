package com.example.learning.nevigator.controller;

import java.util.List;

import com.example.learning.nevigator.exchange.createExamrequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.learning.nevigator.dto.exam;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.exchange.getAllExamresponse;
import com.example.learning.nevigator.service.examservice;
import com.example.learning.nevigator.service.examserviceimp;
;

@RestController
@RequestMapping(examcontroller.EXAM_API_ENDPOINT)
public class examcontroller {
    
 public static final String EXAM_API_ENDPOINT = "/exams";

    @Autowired
    private examservice examService;
    @Autowired
    private examserviceimp examserviceimp;

    @PostMapping
    public ResponseEntity<exam> createExam(@RequestBody @Validated createExamrequest createExamRequest) throws subjectNotFoundexception {
        exam exam = examserviceimp.createExam(createExamRequest);
        return ResponseEntity.ok().body(exam);
    }

    @GetMapping("/{examId}")
    public ResponseEntity<exam> getExamById(@PathVariable(value = "examId") long examId) throws examNotFoundexception {
        exam exam = examserviceimp.findExamById(examId);
        return ResponseEntity.ok().body(exam);
    }

    @GetMapping
    public ResponseEntity<getAllExamresponse> getAllExams() {
        List<exam> exams = examserviceimp.findAllExams();
        getAllExamresponse getAllExamsResponse = new getAllExamresponse(exams);
        return ResponseEntity.ok().body(getAllExamsResponse);
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable long examId) throws examNotFoundexception {
        String message = "Successfully deleted exam with ID: " + String.valueOf(examId);
        examserviceimp.deleteExam(examId);
        return ResponseEntity.ok().body(message);
    }
}
