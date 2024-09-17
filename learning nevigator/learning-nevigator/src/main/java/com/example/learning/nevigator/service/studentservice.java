package com.example.learning.nevigator.service;

import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.exception.subjectnotregisterexception;
import com.example.learning.nevigator.exchange.registerStudentRequest;
import com.example.learning.nevigator.models.studententity;

public interface studentservice {
studententity registeredStudent(registerStudentRequest registerStudentRequest);
    
studententity FindStudentById(long id) throws studentNotFoundexception;
studententity EnrolledStudentBySubject(long id, long id) throws studentNotFoundexception,subjectnotregisterexception;
studententity RegisterStudentByExam(long id, long id) throws studentNotFoundexception,examNotFoundexception,subjectNotFoundexception;
List <student> findAllStudents();
 
void deregisterStudent(long id) throws studentNotFoundexception;

    
}
