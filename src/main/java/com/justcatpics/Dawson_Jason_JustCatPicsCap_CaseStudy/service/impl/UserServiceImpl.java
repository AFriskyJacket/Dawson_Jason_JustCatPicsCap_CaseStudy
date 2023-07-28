package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service.impl;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto.UserDto;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.Role;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository.RoleRepository;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository.UserRepository;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();

        user.setName(userDto.getUserName());
        user.setEmail(userDto.getEmail());

        // Encrypt the password using Spring Security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByNameIgnoreCase("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRole(role);
        userRepository.save(user);
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public User findUserByEmail(String email) {

        return userRepository.findByEmailIgnoreCase(email);
    }
    @Override
    public List<UserDto> findAllUsers() {
        List<User>users = userRepository.findAll();

        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }
    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(userDto.getUserName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}

