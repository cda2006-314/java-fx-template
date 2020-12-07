package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.repository.WebsitethemeHasApiRepository;

import java.util.List;

@Service
public class WebSitethemeHasApiServices {

    @Autowired
    WebsitethemeHasApiRepository websitethemeHasApiRepository;

    public List<Integer> giveApiId(Integer webId){return websitethemeHasApiRepository.findApi(webId);}


}
