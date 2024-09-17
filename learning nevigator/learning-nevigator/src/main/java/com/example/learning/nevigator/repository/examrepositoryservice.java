package com.example.learning.nevigator.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.learning.nevigator.dto.exam;
import com.example.learning.nevigator.exception.examNotFoundexception;
import com.example.learning.nevigator.exception.studentNotFoundexception;
//import com.example.learning.nevigator.exception.subjectNotFoundexception;
import com.example.learning.nevigator.models.examentity;
import com.example.learning.nevigator.models.subjectentity;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy.Provider;

public class examrepositoryservice implements Examrepository {
  @Autowired
    private Examrepository examRepository;

    @Autowired
    private subjectrepository subjectRepository;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;
@Autowired
private exam exam;
    
    public exam createExam(long subjectId) throws studentNotFoundexception {
        String message = "Could not find subject with ID: " + String.valueOf(subjectId);
        ModelMapper modelMapper = modelMapperProvider.get();

        examentity examEntity = new examentity();
        subjectentity subjectEntity = subjectrepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(message));

        examEntity.setSubjectEntity(subjectEntity);
        exam exam = modelMapper.map(Examrepository.save(examEntity), com.example.learning.nevigator.dto.exam.class);
        return exam;
    }
   public exam findExamById(long examId) throws examNotFoundexception {
        String message = "Could not find exam with ID: " + String.valueOf(examId);
        ModelMapper modelMapper = modelMapperProvider.get();
        examentity examEntity = Examrepository.findById(examId).orElseThrow(() -> new ExamNotFoundException(message));
        exam exam = modelMapper.map(examEntity, exam.class);
        return exam;
    }
     public List<exam> findAllExams() {
        List<examentity> examEntities = Examrepository.findAll();
        List<exam> exams = mapToExamList(examEntities);
        return exams;
    }
     public void deleteExam(long examId) throws examNotFoundexception {
        String message = "Could not find exam with ID: " + String.valueOf(examId);
        examentity examEntity = ((Object) examRepository.findById(examId)).orElseThrow(() -> new ExamNotFoundException(message));
        examRepository.delete(examEntity);
    }
    
    private List<exam> mapToExamList(List<examentity> examEntities) {
        List<exam> exams = new ArrayList<>();
        ModelMapper modelMapper = modelMapperProvider.get();

        for(examentity examEntity : examEntities) {
            exam exam = modelMapper.map(examEntity, exam.class);
            exams.add(exam);
        }
        
        return exams;
    }
}


}
