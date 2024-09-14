package lecture2.homework2.musiclibrary;

public class Main {
    public static void main(String[] args) {

        MusicLibrary musicLibrary = new MusicLibrary();
        MusicTrack song1 = new MusicTrack("songName1", "artist1", "genre1");
        MusicTrack song2 = new MusicTrack("songName2", "artist2", "genre1");
        MusicTrack song3 = new MusicTrack("songName3", "artist3", "genre1");
        MusicTrack song4 = new MusicTrack("songName4", "artist4", "genre3");

        System.out.println("~Добавляем треки.");
        musicLibrary.addMusicTrack(song1);
        musicLibrary.addMusicTrack(song2);
        musicLibrary.addMusicTrack(song3);
        musicLibrary.addMusicTrack(song4);

        System.out.println("~Выводим все треки, которые соответствуют genre1:");
        musicLibrary.printTracksByGenre("genre1");

        System.out.println("~Удаляем песню с genre1.");
        musicLibrary.removeMusicTrack(song1);

        System.out.println("~Выводим все оставшиеся треки, которые соответствуют genre1:");
        musicLibrary.printTracksByGenre("genre1");
    }
}
