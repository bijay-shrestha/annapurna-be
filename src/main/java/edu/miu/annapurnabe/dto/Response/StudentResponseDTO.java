package edu.miu.annapurnabe.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO implements Serializable {
    private Integer studentId;
    private String fullName;
    private String username;
    private LocalDate dob;
    private Character status;
    private boolean subscribed;
}
