package edu.miu.annapurnabe.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import edu.miu.annapurnabe.dto.request.StudentRequestDTO;
import edu.miu.annapurnabe.dto.request.StudentUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.StudentResponseDTO;
import edu.miu.annapurnabe.model.Student;
import edu.miu.annapurnabe.repository.StudentRepository;
import edu.miu.annapurnabe.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static edu.miu.annapurnabe.constant.BCryptConstant.COST;
import static edu.miu.annapurnabe.constant.StringConstant.StatusConstant.DELETE;

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

    @Override
    public StudentResponseDTO getStudentById(Integer studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isPresent()){
            return modelMapper.map(student.get(), StudentResponseDTO.class);
        }else{
            throw new IllegalStateException("Student Not Found");
        }
    }

    @Override
    public StudentResponseDTO registerStudent(StudentRequestDTO studentRequestDTO) {
        Student studentRequest = modelMapper.map(studentRequestDTO, Student.class);
        studentRequest.setPassword(BCrypt.withDefaults().hashToString(COST,
                studentRequest.getPassword().toCharArray()));
        Student student = studentRepository.save(studentRequest);
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO updateStudent(Integer id, StudentUpdateRequestDTO studentUpdateRequestDTO)
    throws Exception{
        Student toBeUpdatedStudent = modelMapper.map(studentUpdateRequestDTO, Student.class);
        Student student = studentRepository.findById(id).orElseThrow(()-> new Exception("Student Not Found"));
        studentRepository.save(updateStudent(toBeUpdatedStudent, student));
        return modelMapper.map(student, StudentResponseDTO.class);
    }

    @Override
    public StudentResponseDTO deleteStudent(Integer id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(()-> new Exception("Student Not Found"));
        student.setStatus(DELETE);
        return modelMapper.map(studentRepository.save(student), StudentResponseDTO.class);
    }

    protected Student updateStudent(Student toBeUpdatedStudent, Student existingStudent){
        existingStudent.setFullName(toBeUpdatedStudent.getFullName());
        existingStudent.setEmail(toBeUpdatedStudent.getEmail());
        existingStudent.setDob(toBeUpdatedStudent.getDob());
        existingStudent.setStatus(toBeUpdatedStudent.getStatus());
        existingStudent.setSubscribed(toBeUpdatedStudent.isSubscribed());
        return existingStudent;
    }
}
