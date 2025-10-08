package com.coding.bappa.LearningRESTAPIs.controller;

import com.coding.bappa.LearningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1L, "Bappa Pal", "bappa.pal@gmail.com");
    }
}
