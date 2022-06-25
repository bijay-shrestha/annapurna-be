package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.Response.StudentResponseDTO;

import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public interface StudentService {

    List<StudentResponseDTO> getStudents();
}
