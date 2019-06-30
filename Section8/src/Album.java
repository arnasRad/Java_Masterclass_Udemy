import java.util.LinkedList;

public class Album {
    private String name;
    private LinkedList<Song> songs = new LinkedList<>();

    public Album(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void start() {
        int option;

        while(true) {
            printMenu();
            option = Utils.getOption(6);
            if (option == 0)
                return;

            switch (option) {
                case 1:
                    listSongs();
                    break;
                case 2:
                    addSong();
                    break;
                case 3:
                    removeSong();
                    break;
                case 4:
                    showSongInfo();
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("/*** ALBUM " + name + " ***/");
        System.out.println("1. Song list");
        System.out.println("2. Add song");
        System.out.println("3. Remove song");
        System.out.println("4. Song info");
        System.out.println("0. Quit");
    }

    public void addSong(Song song) {
        Song tempSong = getSong(song.getTitle());
        if (tempSong != null) {
            System.out.println("Song " + song.getTitle() +
                    " is already in album " + this.name);
            return;
        }

        song.setAlbum(this);
        this.songs.add(song);
        System.out.println("Song " + song.getTitle() +
                " successfully added to album " + this.name);
    }

    private void addSong() {
        System.out.println("/*** ADD SONG ***/");
        System.out.println("Enter song name ");
        String name = Utils.getStringInput(25);
        System.out.println("Minutes: ");
        int minutes = Utils.getMinutesSecondsInput();
        System.out.println("Seconds: ");
        int seconds = Utils.getMinutesSecondsInput();

        addSong(new Song(name, minutes, seconds));
    }

    public Song getSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    public boolean removeSong(int index) {
        int albumSize = getSize();
        if (index < 0 || index >= albumSize)
            return false;

        this.songs.remove(index);
        return true;
    }

    private void removeSong() {
        int albumSize = getSize();
        System.out.println("/*** REMOVE SONG ***/");
        if (albumSize == 0) {
            System.out.println("Cannot remove from empty album");
            return;
        }

        listSongs();
        System.out.println("Enter song number you wish to remove from album " +
                this.name + ". Enter 0 to quit");
        int option = Utils.getOption(albumSize);
        if (option == 0)
            return;

        removeSong(option-1);
    }

    private void showSongInfo() {
        System.out.println("/*** SONG INFO ***/");

        int albumSize = getSize();
        if (albumSize == 0) {
            System.out.println("There are currently no songs in album " + getName());
            return;
        }

        listSongs();
        System.out.println("Enter song number to show it's info. Enter 0 to quit");
        int option = Utils.getOption(albumSize);
        if (option == 0)
            return;

        Song song = getSong(option-1);
        System.out.println(song.getSongInfoString(true, true));
    }

    public int getSize() {
        return songs.size();
    }

    public void listSongs() {
        int i = 1;
        System.out.println("/************/");
        System.out.println("Album " + this.name);
        for (Song song : songs) {
            System.out.println("[" + i + "]: " + song.getSongInfoString(true, false));
            ++i;
        }
        System.out.println("/************/");
        System.out.println();
    }
}
