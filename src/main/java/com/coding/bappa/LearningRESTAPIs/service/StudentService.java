package com.coding.bappa.LearningRESTAPIs.service;

import com.coding.bappa.LearningRESTAPIs.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudent();
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    boolean deleteStudent(Long id);
}
