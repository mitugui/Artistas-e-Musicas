package br.com.mitugui.screensound.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ArtistType type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs = new ArrayList<>();

    public Artist() {}

    public Artist(String name, ArtistType artistType) {
        this.name = name;
        this.type = artistType;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Nome: " + name +
                ", Tipo: " + type +
                ", Músicas: " + songs;
    }
}
