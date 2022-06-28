package edu.miu.annapurnabe.dto.request;

import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Data
public class StudentRequestDTO implements Serializable {
    private Integer studentId;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private boolean subscribe;
}
