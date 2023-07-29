package com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.controller;

import com.justcatpics.Dawson_Jason_JustCatPicsCap_CaseStudy.service.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("pictures",  pictureService.getXPictures(5));
        return "index";
    }
}
