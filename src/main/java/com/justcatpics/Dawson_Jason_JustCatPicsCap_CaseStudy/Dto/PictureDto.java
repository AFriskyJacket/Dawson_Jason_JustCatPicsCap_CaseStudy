package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.Dto;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.model.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class PictureDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private User user;

    @NotEmpty
    private Set<String> tags = new LinkedHashSet<>();
}
