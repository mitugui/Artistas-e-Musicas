package br.com.mitugui.screensound.main;

import br.com.mitugui.screensound.models.Artist;
import br.com.mitugui.screensound.models.ArtistType;
import br.com.mitugui.screensound.models.Song;
import br.com.mitugui.screensound.repository.ArtistRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ArtistRepository repository;

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

    public void displayMenu() {
        var option = -1;

        while (option != 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar artistas
                    2- Cadastrar músicas
                    3- Listar músicas
                    4- Buscar músicas por artistas
                    5- Pesquisar dados sobre um artista
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerSongs();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchSongByArtist();
                    break;
                case 5:
                    searchArtistData();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void registerArtists() {
        String keepGoing = "s";
        while(keepGoing.equalsIgnoreCase("s")) {
            System.out.println("Informe o nome desse artista: ");
            var name = scanner.nextLine();
            System.out.println("Informe o tipo desse artista (solo, dupla, grupo ou banda): ");
            var type = scanner.nextLine();

            try {
                ArtistType artistType = ArtistType.fromPortuguese(type);
                Artist artist = new Artist(name, artistType);
                repository.save(artist);
                System.out.println("Artista cadastrado com sucesso!");
            } catch (IllegalArgumentException e) {
                String validTypes = Arrays.stream(ArtistType.values())
                        .map(ArtistType::getArtistTypeInPortuguese)
                        .collect(Collectors.joining(", "));

                System.out.println("Tipo \"" + type + "\" inválido!");
                System.out.println("Os tipos válidos são os seguintes: " + validTypes);
                System.out.println("Tente novamente!");
            }
            System.out.println("Deseja continuar (s/n)?");
            keepGoing = scanner.nextLine();
        }
    }

    private void registerSongs() {
        System.out.println("Cadastrar música de que artista?");
        var name = scanner.nextLine();
        Optional<Artist> artist = repository.findByNameContainingIgnoreCase(name);
        if (artist.isPresent()) {
            System.out.println("Informe o título da música: ");
            var songName = scanner.nextLine();
            Song song = new Song(songName);
            song.setArtist(artist.get());
            artist.get().getSongs().add(song);
            repository.save(artist.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void listSongs() {
    }

    private void searchSongByArtist() {
    }

    private void searchArtistData() {
    }
}