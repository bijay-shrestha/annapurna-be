package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.model.UserRole;
import edu.miu.annapurnabe.repository.UserRoleRepository;
import edu.miu.annapurnabe.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bijayshrestha on 7/6/22
 * @project annapurna-be
 */
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole saveUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }
}
