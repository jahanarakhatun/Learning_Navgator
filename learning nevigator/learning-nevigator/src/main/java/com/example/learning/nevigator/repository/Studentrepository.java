package com.example.learning.nevigator.repository;
import java.util.List;

import com.example.learning.nevigator.dto.student;
//import com.example.learning.nevigator.dto.student;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.studententity;
//import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.subjectentity;

public interface Studentrepository extends JpaRepository<studententity,Long>{
    List<subjectentity> findAll();
    
}
