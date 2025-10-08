package com.coding.bappa.LearningRESTAPIs.service.Impl;

import com.coding.bappa.LearningRESTAPIs.dto.StudentDto;
import com.coding.bappa.LearningRESTAPIs.entity.Student;
import com.coding.bappa.LearningRESTAPIs.repository.StudentRepository;
import com.coding.bappa.LearningRESTAPIs.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .toList();
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        Student saved = studentRepository.save(student);
        return modelMapper.map(saved, StudentDto.class);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentDto.class))
                .orElse(null);
    }

    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Optional<Student> existingOpt = studentRepository.findById(id);
        if (existingOpt.isEmpty()) return null;

        Student existing = existingOpt.get();
        existing.setName(studentDto.getName());
        existing.setEmail(studentDto.getEmail());

        Student updated = studentRepository.save(existing);
        return modelMapper.map(updated, StudentDto.class);
    }

    @Override
    public boolean deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }
}
