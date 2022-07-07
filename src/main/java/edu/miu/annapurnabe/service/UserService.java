package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.UserResponseDTO;
import edu.miu.annapurnabe.dto.request.UserUpdateRequestDTO;
import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public interface UserService {

    List<UserResponseDTO> getUsers();

    UserResponseDTO getUserById(Integer studentId);

    UserResponseDTO registerUsers(UserResponseDTO userResponseDTO);

    UserResponseDTO updateUser(Integer id, UserUpdateRequestDTO userUpdateRequestDTO);

    UserResponseDTO deleteUser(Integer id);
}
