package project.back.back.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.back.back.model.MemberPreferences;
import project.back.back.model.Preference;
import project.back.back.repository.MemberPreferencesRepository;

@Service
public class MemberPreferencesServices {

    @Autowired
    MemberPreferencesRepository memberPreferencesRepository;
    @Autowired
    PreferenceServices preferenceServices;

    public Preference findByMemberId(int memberId){
      MemberPreferences memberPreferences = memberPreferencesRepository.findByMembreId(memberId);
      int preferenceId = memberPreferences.getPreferenceId();

      Preference preference = preferenceServices.getPreferenceById(preferenceId);
      return preference;
    }

    public String createPreferenceToMember(int memberId, int preferenceId){
        MemberPreferences memberPreferences = new MemberPreferences();
        memberPreferences.setMembreId(memberId);
        memberPreferences.setPreferenceId(preferenceId);
        Long id = Long.valueOf(memberId + "" + preferenceId);
        memberPreferences.setId(id);
        memberPreferencesRepository.insert(memberPreferences);
        return "" + memberPreferences.getId();
    }
}
