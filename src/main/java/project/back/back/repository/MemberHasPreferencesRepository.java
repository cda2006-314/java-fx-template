package project.back.back.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.back.back.model.MemberHasPreferences;
import project.back.back.model.MemberHasPreferencesPK;

import java.util.List;


@Repository
public interface MemberHasPreferencesRepository extends JpaRepository<MemberHasPreferences, MemberHasPreferencesPK> {

    @Override
    List<MemberHasPreferences> findAll(Sort sort);
    List<MemberHasPreferences> findAllByMemberByMemberId(int memberId);

    @Override
    <S extends MemberHasPreferences> S save(S entity);

    void save(MemberHasPreferencesPK memberHasPreferencesPK);

    List<MemberHasPreferences> findAllByMemberId(int memberId);
}
