package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Valentina on 12.12.2016.
 */
@Entity
public class Album implements Serializable{


    private static final long serialVersionUID = -4986378998998935987L;



    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERID")
    private Long idUser;

    @Column(name = "NAME")
    private String name;

   // @OneToMany(mappedBy = "name")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "album_songs", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "ID"))
    private List<Song> songList = new LinkedList<>();

    public Album(){
    }
    public Album(Long idUser, String name) {
        this.idUser = idUser;
        this.name = name;

    }
    public Long getId() {
        return id;
    }
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }


    @Override
    public String toString() {
        return "Album{" +
                ", songList=" + songList +
                '}';
    }
}
