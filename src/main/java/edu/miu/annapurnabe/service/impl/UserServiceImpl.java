package edu.miu.annapurnabe.service.impl;

import edu.miu.annapurnabe.dto.request.UserRequestDTO;
import edu.miu.annapurnabe.dto.request.UserUpdateRequestDTO;
import edu.miu.annapurnabe.dto.response.UserResponseDTO;
import edu.miu.annapurnabe.model.User;
import edu.miu.annapurnabe.repository.UserRepository;
import edu.miu.annapurnabe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static edu.miu.annapurnabe.constant.ExceptionMessageConstant.USER_ALREADY_EXIST;
import static edu.miu.annapurnabe.constant.ExceptionMessageConstant.USER_NOT_FOUND;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserResponseDTO> getUsers() {
        return userRepository.getAllActiveUsers().stream()
                .map(user -> modelMapper.map(
                        user,
                        UserResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDTO getUserById(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserResponseDTO.class);
        } else {
            throw new IllegalStateException(USER_NOT_FOUND);
        }
    }

    @Override
    public UserResponseDTO registerUsers(UserRequestDTO userRequestDTO) {
        Optional<User> isUserExist = userRepository.findByUserIdOrUsernameOrEmail(
                userRequestDTO.getUserId(),
                userRequestDTO.getEmail(),
                userRequestDTO.getUsername());
        if(isUserExist.isPresent()){
            throw new IllegalStateException(USER_ALREADY_EXIST);
        }
        User userRequest = modelMapper.map(userRequestDTO, User.class);
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        User user = userRepository.save(userRequest);
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Integer id, UserUpdateRequestDTO userUpdateRequestDTO) {
        User toBeUpdatedUser = modelMapper.map(userUpdateRequestDTO, User.class);
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(USER_NOT_FOUND));
        userRepository.save(updateUser(toBeUpdatedUser, user));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(USER_NOT_FOUND));
        user.disable();
        user.setSubscribed(false);
        return modelMapper.map(userRepository.save(user), UserResponseDTO.class);
    }

    protected User updateUser(User toBeUpdatedUser, User existingUser) {
        existingUser.setFullName(toBeUpdatedUser.getFullName());
        existingUser.setEmail(toBeUpdatedUser.getEmail());
        existingUser.setDateOfBirth(toBeUpdatedUser.getDateOfBirth());
        existingUser.setStatus(toBeUpdatedUser.getStatus());
        existingUser.setSubscribed(toBeUpdatedUser.isSubscribed());
        return existingUser;
    }

}
