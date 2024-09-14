package lecture2.homework2.musiclibrary;

public class MusicTrack {

    private final String name;
    private final String artist;
    private final String genre;

    public MusicTrack(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }
}
