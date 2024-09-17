package com.example.learning.nevigator.exchange;

import java.util.List;

import com.example.learning.nevigator.dto.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class getAllStudentresponse {
    private List<student> students;
}
