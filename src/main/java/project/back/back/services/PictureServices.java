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
    String reponse = uploadClient.getResponse_media_upload();

    String idPicture = reponse.substring(25,49);
    picture.setPictureLabel(idPicture);
    picture.setPictureUrl("http://localhost:8090/api/v1/media/display/" + idPicture + "?api-key=");
    pictureRepository.save(picture);
    System.out.println(picture);}

public void createPicture(String label, String urlFile){

    Picture picture = new Picture();
    MultipartFileUploadClient uploadClient = new MultipartFileUploadClient();
    uploadClient.sendFile(urlFile);
    String reponse = uploadClient.getResponse_media_upload();
    String idPicture = reponse.substring(25,49);
    picture.setPictureLabel(label);
    picture.setPictureUrl("http://localhost:8090/api/v1/media/display/" + idPicture + "?api-key=");
    pictureRepository.save(picture);
}

public void deletePicture(Picture picture){pictureRepository.delete(picture);}
public List<Picture> pictureList(){return pictureRepository.findAll();}


}
