package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Webcontent;
import project.back.back.repository.WebContentRepository;

import java.util.List;

@Service
public class WebContentServices {

@Autowired
    WebContentRepository webContentRepository;

public List<Webcontent> webcontentList(){return webContentRepository.findAll();}
}
