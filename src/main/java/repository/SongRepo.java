package repository;

import domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
public interface  SongRepo  extends JpaRepository<Song, Long> {

        Song findFirstByName(String name);
        Song findFirstById(Long id);
        List<Song> findByName(String name);
    }

