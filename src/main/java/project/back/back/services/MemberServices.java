package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.repository.MemberstatusRepository;

@Service
public class MemberServices {


    @Autowired
    MemberstatusRepository memberstatusRepository;



}
