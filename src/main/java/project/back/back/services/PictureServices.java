package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Picture;
import project.back.back.repository.PictureRepository;
import project.back.back.util.MultipartFileUploadClient;

import java.util.List;

@Service
public class PictureServices {
@Autowired
    PictureRepository pictureRepository;

public void createPicture(String urlFile){
    Picture picture = new Picture();
    MultipartFileUploadClient uploadClient = new MultipartFileUploadClient();
    uploadClient.sendFile(urlFile);
    String idPicture = uploadClient.getResponse_media_upload();

    picture.setPictureLabel(idPicture);
    picture.setPictureUrl("http://localhost:8080/api/v2/media/display/" + idPicture);
    pictureRepository.save(picture);
    System.out.println(picture);}

public void createPicture(String label, String urlFile){

    Picture picture = new Picture();
    MultipartFileUploadClient uploadClient = new MultipartFileUploadClient();
    uploadClient.sendFile(urlFile);
    String idPicture = uploadClient.getResponse_media_upload();

    picture.setPictureLabel(label);
    picture.setPictureUrl("http://localhost:8080/api/v2/media/display/"  + idPicture);
    pictureRepository.save(picture);
}

public void deletePicture(Picture picture){pictureRepository.delete(picture);}
public List<Picture> pictureList(){return pictureRepository.findAll();}


}
