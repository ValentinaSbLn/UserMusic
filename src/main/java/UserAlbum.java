import domain.Song;

/**
 * Created by Valentina on 14.12.2016.
 */
public interface UserAlbum {
    void addSong(Song song);
    Song findSongForAll(String name);
    Song findSong(String name);
    void deleteSong(Song song);
    void editSong(Song song);
    void showAll();
}
