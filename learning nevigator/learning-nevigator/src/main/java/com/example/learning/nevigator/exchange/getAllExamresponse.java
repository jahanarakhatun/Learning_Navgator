package com.example.learning.nevigator.exchange;

import java.util.List;

import com.example.learning.nevigator.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class getAllExamresponse {
    private List<exam> exams;
}
