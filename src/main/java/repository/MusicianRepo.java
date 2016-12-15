package repository;

/**
 * Created by Valentina on 12.12.2016.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import domain.Musician;

import java.util.List;

public interface MusicianRepo extends JpaRepository<Musician, Long> {

    Musician findFirstByFirstNameAndLastName(String firstName, String lastName);

}
