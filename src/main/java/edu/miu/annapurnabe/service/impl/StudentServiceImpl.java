package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.dto.Response.StudentResponseDTO;
import edu.miu.annapurnabe.repository.StudentRepository;
import edu.miu.annapurnabe.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository,
                              ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<StudentResponseDTO> getStudents() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(
                        student,
                        StudentResponseDTO.class))
                .collect(Collectors.toList());
    }
}
