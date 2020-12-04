package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Api;
import project.back.back.repository.ApiRepository;
import project.back.back.util.MultipartFileUploadClient;

import java.util.List;
import java.util.Optional;

@Service
public class ApiManageServices {

    @Autowired
    ApiRepository apiRepository;

    public List<Api> listApi(){return apiRepository.findAll();}
    public void createApi(Api api){
    apiRepository.save(api);}

    public void createApi(String label, String description, String apiContent){
        Api api = new Api();
        MultipartFileUploadClient multipartFileUploadClient = new MultipartFileUploadClient();
        multipartFileUploadClient.sendFile(apiContent);
        String reponseUpload =  multipartFileUploadClient.getResponse_media_upload();
        String idApi = reponseUpload.substring(25,49);
        api.setApiLabel(label);
        api.setApiContenu("http://localhost:8090/api/v1/media/display/" + idApi + "?api-key=");
        api.setApiDescription(description);
        apiRepository.save(api);
    }

    public void deleteApi(Api api){apiRepository.delete(api);}
    public Optional<Api> findById(int apiId){
        Optional<Api> api =  apiRepository.findById(apiId); return api;}

}
