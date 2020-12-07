package project.back.back.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import project.back.back.model.WebsitethemeHasApi;

import java.util.List;
import java.util.Optional;

public interface WebsitethemeHasApiRepository extends JpaRepository<WebsitethemeHasApi, Integer> {

    @Override
    List<WebsitethemeHasApi> findAllById(Iterable<Integer> integers);

    @Transactional
    @Query(value="select API_ID from WEBSITETHEME_HAS_API where WEBSITETHEME_ID= :webId", nativeQuery = true)
    List<Integer> findApi(int webId);
}
