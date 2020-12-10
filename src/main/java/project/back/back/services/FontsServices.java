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
        String idImage = multipartFileUploadClient.getResponse_media_upload();
        System.out.println("1er Id Image");
        fonts.setFontsUrl("http://localhost:8080/api/v2/media/display/" + idImage);

        multipartFileUploadClient.sendFile(contenu);
        String idContenu = multipartFileUploadClient.getResponse_media_upload();
        System.out.println("Retour contenu");
        fonts.setFontsContenu("http://localhost:8080/api/v2/media/download/" + idContenu);
        fonts.setFontsLabel(fontLabel);
        fontsRepository.save(fonts);
    }

    public Optional<Fonts> findById(int fontId){return fontsRepository.findById(fontId);}
    public void deleteFont(Fonts fonts){fontsRepository.delete(fonts);}

}
