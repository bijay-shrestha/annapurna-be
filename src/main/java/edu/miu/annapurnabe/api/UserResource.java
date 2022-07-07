package edu.miu.annapurnabe.api;

import edu.miu.annapurnabe.dto.request.UserResponseDTO;
import edu.miu.annapurnabe.dto.request.UserUpdateRequestDTO;
import edu.miu.annapurnabe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.API_V1_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.UserResourceConstant.USER_BASE;
import static edu.miu.annapurnabe.constant.WebResourceKeyConstant.UserResourceConstant.USER_ID;

/**
 * @author bijayshrestha on 6/24/22
 * @project annapurna-be
 */
@RestController
@RequestMapping(API_V1_BASE + USER_BASE)
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers(){
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping(USER_ID)
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") Integer id){
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserResponseDTO
                                                                                                     userResponseDTO) {
        return new ResponseEntity<>(userService.registerUsers(userResponseDTO), HttpStatus.CREATED);
    }

    @PutMapping(USER_ID)
    public ResponseEntity<UserResponseDTO> updateStudent(@PathVariable("userId") Integer id,
                                                         @RequestBody UserUpdateRequestDTO userUpdateRequestDTO) {
        UserResponseDTO userResponseDTO = userService.updateUser(id, userUpdateRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @DeleteMapping(USER_ID)
    public ResponseEntity<UserResponseDTO> deleteStudent(@PathVariable("userId") Integer id) {
       UserResponseDTO studentToBeDeleted = userService.deleteUser(id);
        return ResponseEntity.ok().body(studentToBeDeleted);
    }
}
