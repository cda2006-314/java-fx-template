package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.back.back.model.Member;
import project.back.back.model.MemberHasPreferences;
import project.back.back.model.MemberHasPreferencesPK;
import project.back.back.model.Preference;
import project.back.back.repository.MemberHasPreferencesRepository;
import project.back.back.repository.MemberRepository;
import project.back.back.repository.PreferenceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberHasPreferencesService {

    @Autowired
    MemberHasPreferencesRepository memberHasPreferencesRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PreferenceRepository preferenceRepository;

    @Transactional
    public void memberAddPreferences(Member member, int preferenceId){
        MemberHasPreferences memberHasPreferences = new MemberHasPreferences();
        memberHasPreferences.setMemberId(member.getMemberId());
        memberHasPreferences.setPreferenceId(preferenceId);

memberHasPreferencesRepository.save(memberHasPreferences);


    }

    public List<MemberHasPreferences> listMemberPreferences(int memberId){
        return memberHasPreferencesRepository.findAllByMemberId(memberId);
    }
}
