package lecture2.homework2.musiclibrary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MusicLibrary {

    // Представим, что new HashSet<>() = набор треков (плейлист).
    // Музыкальная библиотека состоит из жанров и плейлистов, соответствующих этим жанрам.
    private final HashMap<String, HashSet<MusicTrack>> musicLibrary = new HashMap<>();

    public void addMusicTrack(MusicTrack musicTrack) {
        // Cоздать новый плейлист по жанру. Если жанр уже существует, вернуть плейлист по данному жанру.
        musicLibrary.putIfAbsent(musicTrack.getGenre(), new HashSet<>());
        // Добавить трек в плейлист с соответствующим этому треку жанром.
        musicLibrary.get(musicTrack.getGenre())
                .add(musicTrack);
    }

    public void removeMusicTrack(MusicTrack musicTrack) {
        // Удалить трек из плейлиста с соответствующим этому треку жанром.
        musicLibrary.get(musicTrack.getGenre()).remove(musicTrack);
    }

    public HashSet<String> getTracksByGenre(String genre) {
        // Инициализируем список названий треков musicTrackNames.
        HashSet<String> musicTrackNames = new HashSet<>();

        // Проходим по всем энтри в musicLibrary.
        for (Map.Entry<String, HashSet<MusicTrack>> genreEntry : musicLibrary.entrySet()) {
            String genreInLibrary = genreEntry.getKey();

            // Если жанр совпал, получаем плейлист треков данного жанра.
            if (genreInLibrary.equals(genre)) {
                HashSet<MusicTrack> musicTracks = genreEntry.getValue();

                // Проходимся по плейлисту и добавляем в список названий треков (musicTrackName) названия треков подходящего жанра.
                for (MusicTrack musicTrack : musicTracks) {
                    musicTrackNames.add(musicTrack.getName());
                }
                // Возвращаем список названий треков с подходящим жанром.
                return musicTrackNames;
            }
        }
        // Если соответствующий жанр не был найден, возвращаем пустой список названий треков.
        return musicTrackNames;
    }

    public void printTracksByGenre(String genre) {
        //Получаем набор названий музыкальных треков из метода по получению названию треков по жанру.
        HashSet<String> musicTrackNames = getTracksByGenre(genre);

        // Выводим в консоль каждую песню из отфильтрованного по жанру набора названий музыкальных треков.
        for (String musicTrackName : musicTrackNames) {
            System.out.println(musicTrackName);
        }
    }
}
