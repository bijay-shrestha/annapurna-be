package edu.miu.annapurnabe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class User {
    private static final Character DISABLE = 'D';
    private static final Character ACTIVE = 'A';

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name="email", nullable = false)
    private String email;
    @Column(name="username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "status")
    private Character status = ACTIVE;

    public void disable(){
        this.status = DISABLE;
    }
}
