package br.com.mitugui.screensound.main;

import br.com.mitugui.screensound.repository.ArtistRepository;

import java.util.Scanner;

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
    }

    private void registerSongs() {
    }

    private void listSongs() {
    }

    private void searchSongByArtist() {
    }

    private void searchArtistData() {
    }
}
