/**
 * Created by Valentina on 12.12.2016.
 */
import configuration.MainConfig;
import domain.Album;
import domain.Musician;
import domain.Song;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import repository.AlbumRepo;
import repository.MusicianRepo;
import repository.SongRepo;


public class Application {

    public static void main(String[] args) {

        UserAlbum album = new UserAlbumImpl(2L);

      //  album.showAll();
        Song song=new Song("Кто я", 100L);
        Song song1=new Song("Осколок льда", 100L);
        Song song2=new Song("Дай руку мне", 100L);

        album.addSong(song);
        album.addSong(song1);
        album.addSong(song2);



//
//        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
//        ctx.registerShutdownHook();
////
//        final PlatformTransactionManager transactionalManager = ctx.getBean(PlatformTransactionManager.class);
//        final TransactionTemplate tt = new TransactionTemplate(transactionalManager);
//        final MusicianRepo musicianRepo = ctx.getBean(MusicianRepo.class);
//        final SongRepo songRepo = ctx.getBean(SongRepo.class);
//        final AlbumRepo albumRepo = ctx.getBean(AlbumRepo.class);



//        inTransaction(tt, () -> {
//            final Musician musician = musicianRepo.save(new Musician("Valery", "Kipelov"));
//            System.out.println(" Музыкант: "+musician.getId()+" Имя:"+musician.getFirstName()+" Фамилия"+musician.getLastName());
//            System.out.println("++++++++++++++++++++++++++++++++");
//        });
//       // Создаём книгу
//        inTransaction(tt, () -> {
//            final Musician musician = musicianRepo.findFirstByFirstNameAndLastName("Andrey", "Cherkovskiy");
//            final Long id = musicianRepo.findFirstByFirstNameAndLastName("Valery", "Kipelov").getId();
//
//            System.out.println(" Музыкант: "+musician.getId()+" Имя:"+musician.getFirstName()+" Фамилия"+musician.getLastName());
//            System.out.println("++++++++++++++++++++++++++++++++");
//        });

//
//        inTransaction(tt, ()->{
//          //  final Musician author = musicianRepo.save(new Musician("Andrey", "Cherkovskiy"));
//            final Album song = albumRepo.save(new Album(2L, "MyMysic"));
//        }) ;

//        inTransaction(tt, () -> {
//            final Album album = albumRepo.findByIdUser(2L);
//            album.getSongList().add(new Song("Пророк", 200L));
//        });


//
////        //Назначаем на книгу автора
//        inTransaction(tt, () -> {
//            final Musician author = musicianRepo.findFirstByFirstNameAndLastName("Andrey", "Cherkovskiy");
//            author.getAudioList().add(new Song("Java book", 200L));
//        });

        //Смотрим какие книги написал автор
//        inTransaction(tt, () -> {
//            final Musician author = musicianRepo.findFirstByFirstNameAndLastName("Andrey", "Cherkovskiy");
//            System.out.println(author.getAudioList());
//        });
//
//        //Смотрим кто написал книгу
//        inTransaction(tt, () -> {
//            final Song book = songRepo.findFirstByName("Hello");
//            System.out.println(book.getMusicianList());
//        });

//        //Назначаем на книгу ещё одного автора
//        inTransaction(tt, () -> {
//            final Song book = bookRepo.findFirstByName("Java book");
//            final Musician author = musicianRepo.save(new Musician("Joshua", "Bloch"));
//            author.getAudioList().add(book);
//        });
//
//        //Удаляем первого автора
//        inTransaction(tt, () -> {
//            final Musician author = musicianRepo.findFirstByFirstNameAndLastName("Andrey", "Cherkovskiy");
//            musicianRepo.delete(author);
//        });
//
//        //Смотрим кто написал книгу
//        inTransaction(tt, () -> {
//            final Song book = songRepo.findFirstByName("Java book");
//            System.out.println(book.getMusicianList());
//        });

     //   ctx.close();
    }


//    private static void inTransaction(TransactionTemplate transactionTemplate, Runnable action) {
//        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                action.run();
//            }
//        });
//    }
}
