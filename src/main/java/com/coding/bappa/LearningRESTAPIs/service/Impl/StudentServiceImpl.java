package com.coding.bappa.LearningRESTAPIs.service.Impl;

import com.coding.bappa.LearningRESTAPIs.dto.StudentDto;
import com.coding.bappa.LearningRESTAPIs.entity.Student;
import com.coding.bappa.LearningRESTAPIs.repository.StudentRepository;
import com.coding.bappa.LearningRESTAPIs.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students
                .stream()
                .map(student-> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }
}
