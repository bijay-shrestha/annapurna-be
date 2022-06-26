package edu.miu.annapurnabe.api;

import edu.miu.annapurnabe.dto.request.StudentRequestDTO;
import edu.miu.annapurnabe.dto.request.StudentUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.StudentResponseDTO;
import edu.miu.annapurnabe.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.StudentResourceConstant.STUDENT_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.StudentResourceConstant.STUDENT_ID;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + STUDENT_BASE)
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping(STUDENT_ID)
    public ResponseEntity<?> getStudentById(@PathVariable("studentId") Long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<?> registerStudent(@RequestBody StudentRequestDTO studentRequestDTO) throws URISyntaxException {
        return new ResponseEntity<>(studentService.registerStudent(studentRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(STUDENT_ID)
    public ResponseEntity<?> updateStudent(@PathVariable("studentId") Long id,
                                           @RequestBody StudentUpdateRequestDTO studentUpdateRequestDTO)
            throws Exception{
        StudentResponseDTO studentResponseDTO = studentService.updateStudent(id, studentUpdateRequestDTO);
        return ResponseEntity.ok().body(studentResponseDTO);
    }

    @DeleteMapping(STUDENT_ID)
    public ResponseEntity<?> deleteStudent(@PathVariable("studentId") Long id) throws Exception{
        StudentResponseDTO studentToBeDeleted = studentService.deleteStudent(id);
        return ResponseEntity.ok().body(studentToBeDeleted);
    }
}
