package edu.miu.annapurnabe.service;

import edu.miu.annapurnabe.dto.request.UserRequestDTO;
import edu.miu.annapurnabe.dto.request.UserUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.UserResponseDTO;

import java.util.List;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
public interface UserService {

    List<UserResponseDTO> getUsers();

    UserResponseDTO getUserById(Integer studentId);

    UserResponseDTO registerUsers(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(Integer id, UserUpdateRequestDTO userUpdateRequestDTO);

    UserResponseDTO deleteUser(Integer id);
}
