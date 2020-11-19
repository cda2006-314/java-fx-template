package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Picture;
import project.back.back.repository.PictureRepository;

import java.util.List;

@Service
public class PictureServices {
@Autowired
    PictureRepository pictureRepository;

public void createPicture(Picture picture){pictureRepository.save(picture);}
public void deletePicture(Picture picture){pictureRepository.delete(picture);}
public List<Picture> pictureList(){return pictureRepository.findAll();}


}
