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

    @Override
    public String toString() {
        return "Título: " + title +
                ", Artista: " + artist;
    }
}
