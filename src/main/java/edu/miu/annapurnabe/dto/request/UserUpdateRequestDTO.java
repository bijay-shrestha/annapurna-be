package edu.miu.annapurnabe.dto.request;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author bijayshrestha on 6/25/22
 * @project annapurna-be
 */
@Data
public class UserUpdateRequestDTO implements Serializable {
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;
    private Character status;
    private boolean subscribed;
}
