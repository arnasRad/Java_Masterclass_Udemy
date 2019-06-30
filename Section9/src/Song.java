import java.util.ArrayList;

public class Song {
    private String title;
    private double duration;
    private Album album = null;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private boolean playing = false;

    public Song(String title, double duration, Album album, Playlist playlist) {
        this.title = title;
        this.duration = duration;
        this.album = album;
        this.playlists.add(playlist);
    }

    public Song(String title, double duration, Album album) {
        this(title, duration, album, null);
    }

    public Song(String title, double duration) {
        this(title, duration, null, null);
    }

    public Song(String title, int minutes, int seconds) {
        this.title = title;
        this.duration = Utils.getTimeAsDouble(minutes, seconds);
    }

    public void start() {
        if (!this.playing) {
            this.playing = true;
            System.out.println(this.title + " started");
        } else {
            System.out.println("Song " + this.title + " already playing.");
        }
    }

    public void stop() {
        if (this.playing) {
            this.playing = false;
            System.out.println(this.title + " stopped");
        } else {
            System.out.println("Song " + this.title + " already stopped");
        }
    }

    public void showInfo(boolean showAlbum, boolean showPlaylist) {
        System.out.println("Current song: " +
                getSongInfoString(showAlbum,showPlaylist));
    }

    public String getTitle() {
        return title;
    }

    public String getAlbumName() {
        return album.getName();
    }

    public double getDuration() {
        return duration;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void listPlaylists() {
        int i = 1;
        for(Playlist playlist : playlists) {
            System.out.println("[" + i + "]: " + playlist.getName());
            ++i;
        }
    }

    public String getPlaylistsString() {
        int i = 1;
        StringBuilder playlistList = new StringBuilder();
        for(Playlist playlist : playlists) {
            playlistList.append("[").append(i)
                    .append("]: ").append(playlist.getName());
            ++i;
        }

        return playlistList.toString();
    }

    public boolean isPlaying() { return this.playing; }

    public String getSongInfoString(boolean showAlbum, boolean showPlaylists) {
        String info = "Title: " + title + ", duration: " + Utils.getDoubleAsTime(duration);
        if (album != null && showAlbum)
            info += ", album: " + album.getName() + "; ";
        if (playlists != null && showPlaylists)
            info += ", playlists: " + getPlaylistsString() + "; ";

        return info;
    }

    public String getSongInfoString() {
        return  getSongInfoString(false, false);
    }
}
