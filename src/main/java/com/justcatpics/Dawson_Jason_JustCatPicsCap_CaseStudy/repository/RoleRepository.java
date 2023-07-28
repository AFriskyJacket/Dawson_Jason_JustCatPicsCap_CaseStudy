package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByNameIgnoreCase(String name);
}