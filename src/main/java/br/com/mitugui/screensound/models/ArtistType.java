package br.com.mitugui.screensound.models;

public enum ArtistType {
    SOLO("Solo"),
    DUO("Dupla"),
    GROUP("Grupo"),
    BAND("Banda");

    private final String artistTypeInPortuguese;

    ArtistType(String artistTypeInPortuguese) {
        this.artistTypeInPortuguese = artistTypeInPortuguese;
    }

    public String getArtistTypeInPortuguese() {
        return artistTypeInPortuguese;
    }

    public static ArtistType fromPortuguese(String artistTypeInPortuguese) {
        for (ArtistType artistType : ArtistType.values()) {
            if (artistType.getArtistTypeInPortuguese().equalsIgnoreCase(artistTypeInPortuguese)) {
                return artistType;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: "
                + artistTypeInPortuguese);
    }
}
