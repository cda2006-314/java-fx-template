package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.Member;
import project.back.back.model.Memberstatus;
import project.back.back.repository.MemberRepository;
import project.back.back.repository.MemberstatusRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServices {


    @Autowired
    MemberstatusRepository memberstatusRepository;
    @Autowired
    MemberRepository memberRepository;

public void createMember(Member member){memberRepository.save(member);}

public void changeStatusMembre(int memberId){memberstatusRepository.updateMemberStatus(memberId);}

public Member findById(Integer memberId){
    Optional<Member> optionalMember = Optional.ofNullable(memberRepository.findMemberByMemberId(memberId));
  Member member = optionalMember.get();
    return member; }

public void updateMember(Integer memberId){createMember(findById(memberId));}

public List<Member> listMember(){ return memberRepository.findAll(); }

public List<Memberstatus> listMemberStatus(){
    List<Memberstatus> memberL = null;
    memberL =  (List<Memberstatus>) memberstatusRepository.findAll();
    return memberL;}

    public Member getById(int id){
        return memberRepository.getOne(id);
    }

}
