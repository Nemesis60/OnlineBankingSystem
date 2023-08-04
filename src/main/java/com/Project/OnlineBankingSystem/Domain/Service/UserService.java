package com.Project.OnlineBankingSystem.Domain.Service;

import com.Project.OnlineBankingSystem.Domain.Model.User;
import com.Project.OnlineBankingSystem.Domain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        // need validation OKAY
        return userRepository.save(user);
    }
    public Page<User> getAllUsers(Pageable pagination) {
        return userRepository.findAll(pagination);
    }
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
