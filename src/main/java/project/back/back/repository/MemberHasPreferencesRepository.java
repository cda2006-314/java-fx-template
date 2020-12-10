package project.back.back.repository;

import org.hibernate.HibernateException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.back.back.model.MemberHasPreferences;
import project.back.back.model.MemberHasPreferencesPK;

import java.io.Serializable;
import java.util.List;


@Repository
public interface MemberHasPreferencesRepository extends JpaRepository<MemberHasPreferences, MemberHasPreferencesPK> {

    @Override
    List<MemberHasPreferences> findAll(Sort sort);
    List<MemberHasPreferences> findAllByMemberByMemberId(int memberId);

    @Override
    <S extends MemberHasPreferences> S save(S entity);

    List<MemberHasPreferences> findAllByMemberId(int memberId);


}
