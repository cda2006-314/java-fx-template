package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.MemberReportsComment;
import project.back.back.repository.MemberReportsCommentRepository;

import java.util.List;

@Service
public class MemberReportsCommentService {
    @Autowired
    MemberReportsCommentRepository memberReportsCommentRepository;

    public List<MemberReportsComment> reportsCommentList(){ return memberReportsCommentRepository.findAll();}
}
