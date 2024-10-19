package br.com.mitugui.screensound.models;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    private Artist artist;

    public Song() {}

    public Song(String songName) {
        this.title = songName;
    }

    public String getTitle() {
        return title;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Título: " + title +
                ", Artista: " + artist.getName();
    }
}
