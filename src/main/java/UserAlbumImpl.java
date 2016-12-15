import configuration.MainConfig;
import domain.Album;
import domain.Musician;
import domain.Song;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AlbumRepo;
import repository.MusicianRepo;
import repository.SongRepo;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Valentina on 14.12.2016.
 */
public class UserAlbumImpl implements UserAlbum {
    ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
    final MusicianRepo musicianRepo = ctx.getBean(MusicianRepo.class);
    final SongRepo songRepo = ctx.getBean(SongRepo.class);
    final AlbumRepo albumRepo = ctx.getBean(AlbumRepo.class);
    final PlatformTransactionManager transactionalManager;
    final TransactionTemplate tt;

    private Album album;
    Long idUser;
    UserAlbumImpl(Long idUser) {
        ctx.registerShutdownHook();
        transactionalManager = ctx.getBean(PlatformTransactionManager.class);
        tt = new TransactionTemplate(transactionalManager);
        this.idUser=idUser;

    }

    @Override
    public void addSong(Song song) {
        inTransaction(tt, () -> {
           album = albumRepo.findByIdUser(idUser);
            album.getSongList().add(songRepo.save(song));

//            final Song author = songRepo.findFirstByName(song.getName());
//            author.setMusician(new Musician("Valery", "Kipelov"));

//           // album.getSongList().add(new Song("Test", 20L));
//
//
//            album.getSongList().add(new Song("Дыхание любви", 200L));
        });
    }

    @Override
    public Song findSongForAll(String name) {
        final Song song = songRepo.findFirstByName(name);
        return song;
    }

    @Override
    public Song findSong(String name) {

            for (Song s : album.getSongList()) {
                if (s.getName().equals(name))
                    return s;
            }
            return null;
        }
        @Override
        public void deleteSong (Song song){
            inTransaction(tt, () -> {
                Iterator iter = album.getSongList().iterator();
                while (iter.hasNext()) {
                    if (iter.next().equals(song))
                        iter.remove();
                }
            });
//        final Song song = musicianRepo.findFirstByFirstNameAndLastName("Andrey", "Cherkovskiy");
//        musicianRepo.delete(author);

        }

        @Override
        public void editSong (Song song){

        }

    @Override
    public void showAll() {

    }


    private void inTransaction(TransactionTemplate transactionTemplate, Runnable action) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                action.run();
            }
        });
    }
}
