package com.coding.bappa.LearningRESTAPIs.controller;

import com.coding.bappa.LearningRESTAPIs.dto.StudentDto;
import com.coding.bappa.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student")
    public List<StudentDto> getStudent(){
        //return new StudentDto(1L, "Bappa Pal", "bappa.pal@gmail.com");
        return studentService.getAllStudent();
    }
}
