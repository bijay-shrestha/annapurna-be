package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT s FROM User s WHERE s.id=:id AND s.status='A'")
    Optional<User> findById(Integer id);
    
    @Query("SELECT s FROM User s WHERE s.status='A'")
    Collection<User> getAllActiveUsers();

    @Query("SELECT s FROM User s WHERE s.userId=:userId OR s.email=:email OR s.username=:username")
    Optional<User> findByUserIdOrUsernameOrEmail(Integer userId, String email, String username);

    @Query("SELECT s FROM User s WHERE s.username=:username")
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
