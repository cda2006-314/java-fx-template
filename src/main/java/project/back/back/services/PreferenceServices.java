package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Preference;
import project.back.back.repository.PreferenceRepository;
import project.back.back.util.MultipartFileUploadClient;

@Service
public class PreferenceServices {

    @Autowired
    PreferenceRepository preferenceRepository;

    public void createPreference(Preference preference){preferenceRepository.save(preference);}

    public void createPreference(String label, String webThemeId, String urlImage ){
        Preference preference = new Preference();
        MultipartFileUploadClient multipartFileUploadClient = new MultipartFileUploadClient();
        multipartFileUploadClient.sendFile(urlImage);

        String response_SendImage = multipartFileUploadClient.getResponse_media_upload();
        String idImage = response_SendImage.substring(25,49);

        preference.setPreferenceLabel(label);
        preference.setWebsitethemeId(Integer.parseInt(webThemeId));
        preference.setPreferenceDescription("http://localhost:8090/api/v1/media/display/" + idImage + "?api-key=");

        preferenceRepository.save(preference);
    }


}
