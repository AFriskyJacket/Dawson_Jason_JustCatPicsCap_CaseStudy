package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.PictureMetaData;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface PictureRepository extends JpaRepository<PictureMetaData, UUID> {
    List<PictureMetaData> findByUser(User user);
    Set<PictureMetaData> findByUser_Id(Long id);

    PictureMetaData findByName(String name);

    Set<PictureMetaData> findByTags(String tags);

    void deleteByName(String name);
}