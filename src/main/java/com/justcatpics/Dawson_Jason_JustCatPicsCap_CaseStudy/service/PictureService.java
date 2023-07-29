package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service;


import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto.PictureDto;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.PictureMetaData;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.picture.Picture;

import java.util.List;

public interface PictureService {

    void savePicture(PictureDto pictureDto);

    PictureDto findPictureByName(String name);

    List<PictureDto> findAllPictureByUser(User user);

    List<PictureDto> findAllPictureByTag(String tag);

    List<PictureDto> getXPictures(int x);
}
