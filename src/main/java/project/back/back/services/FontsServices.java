package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Fonts;
import project.back.back.repository.FontsRepository;
import project.back.back.util.MultipartFileUploadClient;

import java.util.List;
import java.util.Optional;

@Service
public class FontsServices {

    @Autowired
    FontsRepository fontsRepository;

    public List<Fonts> fontsList(){return fontsRepository.findAll();}
    public void createFont(Fonts fonts){fontsRepository.save(fonts);}

    public void createFont(String fontLabel, String fontImage, String contenu){
        Fonts fonts = new Fonts();
        MultipartFileUploadClient multipartFileUploadClient = new MultipartFileUploadClient();

        multipartFileUploadClient.sendFile(fontImage);
        String envoiImage = multipartFileUploadClient.getResponse_media_upload();
        System.out.println("1er Id Image");
        String idImage = envoiImage.substring(25,49);
        fonts.setFontsUrl("http://localhost:8090/api/v1/media/display/" + idImage + "?api-key=");

        multipartFileUploadClient.sendFile(contenu);
        String reponseContenu = multipartFileUploadClient.getResponse_media_upload();
        System.out.println("Retour contenu");
        String idContenu= reponseContenu.substring(25,49);
        fonts.setFontsContenu(idContenu);

        fontsRepository.save(fonts);
    }

    public Optional<Fonts> findById(int fontId){return fontsRepository.findById(fontId);}
    public void deleteFont(Fonts fonts){fontsRepository.delete(fonts);}

}
