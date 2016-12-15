package repository;

import domain.Album;
import domain.Musician;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Valentina on 12.12.2016.
 */
public interface  AlbumRepo extends JpaRepository<Album, Long> {
    Album findByIdUser(Long id);
}
