package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Fonts;
import project.back.back.repository.FontsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FontsServices {

    @Autowired
    FontsRepository fontsRepository;

    public List<Fonts> fontsList(){return fontsRepository.findAll();}
    public void createFont(Fonts fonts){fontsRepository.save(fonts);}
    public Optional<Fonts> findById(int fontId){return fontsRepository.findById(fontId);}
    public void deleteFont(Fonts fonts){fontsRepository.delete(fonts);}

}
