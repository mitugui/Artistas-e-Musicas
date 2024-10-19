package br.com.mitugui.screensound.repository;

import br.com.mitugui.screensound.models.Artist;
import br.com.mitugui.screensound.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Optional<Artist> findByNameContainingIgnoreCase(String name);

    @Query("SELECT s FROM Artist a JOIN a.songs s WHERE a.name ILIKE %:name%")
    List<Song> searchSongsByArtist(String name);
}
