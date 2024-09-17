package com.example.learning.nevigator.globalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.http.ResponseEntity;

import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
//import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exception.subjectnotregisterexception;

//import lombok.EqualsAndHashCode.Exclude;
@ControllerAdvice
public class globalexception {
    
@ExceptionHandler(studentNotFoundexception.class)
    ResponseEntity<String> handleSubjectNotFoundException(studentNotFoundexception ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }
    @ExceptionHandler(subjectNotFoundexception.class)
    ResponseEntity<String> handleSubjectNotFoundException(subjectNotFoundexception ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(examNotFoundexception.class)
    ResponseEntity<String> handleExamNotFoundException(examNotFoundexception ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(404).body(message);
    }

    @ExceptionHandler(subjectnotregisterexception.class)
    ResponseEntity<String> handleSubjectNotEnrolledException(subjectnotregisterexception ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(403).body(message);
    }
    
}
