package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
