package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Memberslist;
import project.back.back.repository.MemberslistRepository;

import java.util.List;

@Service
public class MemberslistServices {

    @Autowired
    MemberslistRepository memberslistRepository;

    public List<Memberslist> listMembersGroup(){return memberslistRepository.findAll();}


}
