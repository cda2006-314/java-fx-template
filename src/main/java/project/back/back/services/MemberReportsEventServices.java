package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.MemberReportsEvent;
import project.back.back.repository.MemberReportsEventRepository;

import java.util.List;

@Service
public class MemberReportsEventServices {

@Autowired
    MemberReportsEventRepository memberReportsEventRepository;

public List<MemberReportsEvent> reportsEventList(){return memberReportsEventRepository.findAll();}
}
