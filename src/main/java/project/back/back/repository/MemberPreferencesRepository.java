package project.back.back.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import project.back.back.model.MemberPreferences;

public interface MemberPreferencesRepository extends MongoRepository<MemberPreferences, Long> {

    MemberPreferences findByMembreId(int memberId);

}
