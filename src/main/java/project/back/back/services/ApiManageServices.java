package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Api;
import project.back.back.repository.ApiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApiManageServices {

    @Autowired
    ApiRepository apiRepository;

    public List<Api> listApi(){return apiRepository.findAll();}
    public void createApi(Api api){apiRepository.save(api);}
    public void deleteApi(Api api){apiRepository.delete(api);}
    public Optional<Api> findById(int apiId){
        Optional<Api> api =  apiRepository.findById(apiId); return api;}

}
