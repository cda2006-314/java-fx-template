package project.back.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.back.back.model.Picture;

public interface PictureRepository  extends JpaRepository<Picture, Integer> {
}
