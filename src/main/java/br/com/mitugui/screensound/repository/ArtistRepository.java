package br.com.mitugui.screensound.repository;

import br.com.mitugui.screensound.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {}
