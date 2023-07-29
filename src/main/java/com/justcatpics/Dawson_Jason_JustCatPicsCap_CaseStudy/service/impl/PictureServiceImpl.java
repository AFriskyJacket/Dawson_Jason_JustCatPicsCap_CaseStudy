package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service.impl;


import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto.PictureDto;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto.UserDto;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.PictureMetaData;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.picture.Picture;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.repository.PictureRepository;
import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PictureServiceImpl implements PictureService {


    private final PictureRepository pictureRepository;


    @Override
    public void savePicture(PictureDto pictureDto) {
        PictureMetaData pictureMetaData = new PictureMetaData();

        pictureMetaData.setId(pictureDto.getId());
        pictureMetaData.setName(pictureDto.getName());
        pictureMetaData.setUser(pictureDto.getUser());
        pictureMetaData.setTags(pictureDto.getTags());

        pictureRepository.save(pictureMetaData);
        //then save the picture data
    }

    @Override
    public PictureDto findPictureByName(String name) {
        return mapToPictureDto(pictureRepository.findByName(name), new Picture());
    }

    @Override
    public List<PictureDto> findAllPictureByUser(User user) {
        List<PictureMetaData> pictureMetaData = pictureRepository.findByUser(user);

        return pictureMetaData.stream().map(pictureMetaData1 ->
                mapToPictureDto(pictureMetaData1, new Picture()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PictureDto> findAllPictureByTag(String tag) {
        Set<PictureMetaData> pictureMetaData = pictureRepository.findByTags(tag);

        return pictureMetaData.stream().map(pictureMetaData1 ->
                        mapToPictureDto(pictureMetaData1, new Picture()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PictureDto> getXPictures(int x) {
        List<PictureMetaData> pictureMetaData = pictureRepository.findAll();
        Collections.shuffle(pictureMetaData);
        List<PictureDto> pictureDtos = pictureMetaData.stream().limit(x).map(metaData->
                mapToPictureDto(metaData, new Picture())).collect(Collectors.toList());
        //then grab the images
        return  pictureDtos;
    }

    private PictureDto mapToPictureDto(PictureMetaData metaData, Picture picture) {
        PictureDto pictureDto = new PictureDto();

        pictureDto.setName(metaData.getName());
        pictureDto.setUser(metaData.getUser());
        pictureDto.setTags(metaData.getTags());

        return pictureDto;
    }
}
