package domain;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="SONGS")
public class Song implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;


    private Musician musician;

    @Column(name = "DURATION")
    private Long duration;

    public Song() {
    }

    public Song(String name, Long duration ) {
        this.name = name;
        this.duration = duration;
     //   this.authorList = authorList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Musician getMusician() {
        return musician;
    }

    public void setMusician (Musician musician) {
        this.musician = musician;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Musician="+musician+
                ", duration=" + duration +
                '}';
    }
}
