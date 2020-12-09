package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
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

    public void memberAddPreferences(Member member, int preferenceId){
        MemberHasPreferences memberHasPreferences = new MemberHasPreferences();
        memberHasPreferences.setMemberId(member.getMemberId());
        memberHasPreferences.setPreferenceId(preferenceId);
memberHasPreferences.setMemberByMemberId(member);
Optional<Preference> optionalPreference = preferenceRepository.findById(preferenceId);
        Preference preference = new Preference();
if(optionalPreference.isPresent()) {
     preference = optionalPreference.get();
}
memberHasPreferences.setPreferenceByPreferenceId(preference);
        MemberHasPreferencesPK memberHasPreferencesPK = new MemberHasPreferencesPK(member.getMemberId(), preferenceId);
        memberHasPreferencesRepository.save(memberHasPreferencesPK);

    }

    public List<MemberHasPreferences> listMemberPreferences(int memberId){
        return memberHasPreferencesRepository.findAllByMemberId(memberId);
    }
}
