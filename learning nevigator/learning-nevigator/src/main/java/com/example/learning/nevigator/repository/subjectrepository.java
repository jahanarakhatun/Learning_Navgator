package com.example.learning.nevigator.repository;
import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.subjectentity;

import java.util.List;

import javax.security.auth.Subject;

import org.springframework.data.repository.JpaRepository;

public interface subjectrepository extends JpaRepository<subjectentity,Long>{


    
}
