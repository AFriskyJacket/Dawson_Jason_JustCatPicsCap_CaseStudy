package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto.UserDto;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto studentDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}

