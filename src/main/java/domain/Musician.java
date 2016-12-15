package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Musician implements Serializable{

    private static final long serialVersionUID = 7575453446572029611L;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "musician_songs", joinColumns = @JoinColumn(name = "musician_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "songs_id", referencedColumnName = "ID"))
    private List<Song> audioList = new ArrayList<>();

    public Musician() {
    }

    public Musician(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public List<Song> getAudioList() {
        return audioList;
    }

    public void setAudioList(List<Song> audioList) {
        this.audioList = audioList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName +
                '}';
    }
}
