import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {

        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> playlist) {
        int index = trackNum - 1;

        if (index >= 0 && index < songs.size()) {
            var song = songs.get(index);

            if (!playlist.contains(song)) {
                playlist.add(song);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        var song = findSong(title);

        if ((song != null) && !playlist.contains(song)) {
            playlist.add(song);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.name + " - " + this.artist + "\n");
        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            str.append(i + 1).append(". ");
            str.append(song.getTitle()).append("\n");
        }
        return str.toString();
    }
}
