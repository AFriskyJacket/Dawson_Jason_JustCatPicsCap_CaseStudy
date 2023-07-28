package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmailIgnoreCase(String email);
}