package com.Project.OnlineBankingSystem.Domain.Controller;


import com.Project.OnlineBankingSystem.Domain.DTO.UserDTO;
import com.Project.OnlineBankingSystem.Domain.DTO.UserPatchDTO;
import com.Project.OnlineBankingSystem.Domain.Model.User;
import com.Project.OnlineBankingSystem.Domain.Model.Address;
import com.Project.OnlineBankingSystem.Domain.DTO.AddressPatchDTO;
import com.Project.OnlineBankingSystem.Domain.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable pagination) {
        Page<User> users = userService.getAllUsers(pagination);
        Page<UserDTO> usersDTO = users.map(UserDTO::fromEntity);
        return ResponseEntity.ok(usersDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserPatchDTO userPatchDTO) {
        User user = userService.getUser(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        User updatedMapDto = mapUserDtoToUser(userPatchDTO, user);
        User updatedUser = userService.saveUser(updatedMapDto);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        if (!userService.getUser(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    private User mapUserDtoToUser(UserPatchDTO userPatchDTO, User user) {
        if (userPatchDTO.getLastName() != null) {
            user.setLastName(userPatchDTO.getLastName());
        }if (userPatchDTO.getFirstName() != null) {
            user.setFirstName(userPatchDTO.getFirstName());
        }if (userPatchDTO.getBornDate() != null) {
            user.setBornDate(userPatchDTO.getBornDate());
        }if (userPatchDTO.getUsername() != null) {
            user.setUsername(userPatchDTO.getUsername());
        }if (userPatchDTO.getEmail() != null) {
            user.setEmail(userPatchDTO.getEmail());
        }if (userPatchDTO.getPassword() != null) {
            user.setPassword(userPatchDTO.getPassword());
        }if (userPatchDTO.getRol() != null) {
            user.setRol(userPatchDTO.getRol());
        }if (userPatchDTO.getPhoneNumber() != null) {
            user.setPhoneNumber(userPatchDTO.getPhoneNumber());
        }

        if (userPatchDTO.getAddressPatchDTO() != null) {
            AddressPatchDTO addressPatchDTO = userPatchDTO.getAddressPatchDTO();
            Address address = user.getAddress();

            if (addressPatchDTO.getCity() != null) {
                address.setCity(addressPatchDTO.getCity());
            }
            if (addressPatchDTO.getStreet() != null) {
                address.setStreet(addressPatchDTO.getStreet());
            }
            if (addressPatchDTO.getZipCode() != null) {
                address.setZipCode(addressPatchDTO.getZipCode());
            }
        }
        return user;
    }
}
