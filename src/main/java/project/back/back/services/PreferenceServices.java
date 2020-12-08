package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Preference;
import project.back.back.repository.PreferenceRepository;
import project.back.back.util.MultipartFileUploadClient;

import java.util.List;

@Service
public class PreferenceServices {

    @Autowired
    PreferenceRepository preferenceRepository;

    public void createPreference(Preference preference){preferenceRepository.save(preference);}

    public void createPreference(String label, String webThemeId, String urlImage ){
        Preference preference = new Preference();
        MultipartFileUploadClient multipartFileUploadClient = new MultipartFileUploadClient();
        multipartFileUploadClient.sendFile(urlImage);

        String idImage = multipartFileUploadClient.getResponse_media_upload();

        preference.setPreferenceLabel(label);
        preference.setWebsitethemeId(Integer.parseInt(webThemeId));
        preference.setPreferenceDescription("http://localhost:8080/api/v2/media/display/" + idImage);

        preferenceRepository.save(preference);
    }

    public List<Preference> preferenceList(){ return preferenceRepository.findAll();}

}
