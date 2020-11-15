package project.back.back.services;

import project.back.back.model.Api;
import project.back.back.model.Fonts;
import project.back.back.model.Picture;

import project.back.back.repository.ApiRepository;
import project.back.back.repository.FontsRepository;
import project.back.back.repository.PictureRepository;
import project.back.back.repository.WebSiteThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebSiteThemeServices {

@Autowired
WebSiteThemeRepository webSiteThemeRepository;
@Autowired
ApiRepository apiRepository;
@Autowired
FontsRepository fontsRepository;
@Autowired
PictureRepository pictureRepository;

public void createApi(Api api){apiRepository.save(api);}

public void createFonts(Fonts fonts){fontsRepository.save(fonts);}

public void createPicture(Picture picture){pictureRepository.save(picture); }





}
