package edu.miu.annapurnabe.repository;

import edu.miu.annapurnabe.model.DineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 6/28/22
 * @project annapurna-be
 */
@Repository
public interface DineTypeRepository extends JpaRepository<DineType, Integer> {
}
