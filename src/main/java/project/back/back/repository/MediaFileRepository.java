package project.back.back.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import project.back.back.model.MediaFile;


@Repository
public interface MediaFileRepository extends MongoRepository<MediaFile, String> {

}
