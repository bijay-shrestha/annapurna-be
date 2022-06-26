package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.StudentRequestDTO;
import edu.miu.annapurnabe.dto.request.StudentUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.StudentResponseDTO;

import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public interface StudentService {

    List<StudentResponseDTO> getStudents();

    StudentResponseDTO getStudentById(Long studentId);

    StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO);

    StudentResponseDTO updateStudent(Long id, StudentUpdateRequestDTO studentRequestDTO) throws Exception;

    StudentResponseDTO deleteStudent(Long id) throws Exception;
}
