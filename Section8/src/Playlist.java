import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
    private String name;
    private LinkedList<Song> songs = new LinkedList<>();
    private ListIterator<Song> songListIterator = songs.listIterator();
    private boolean goingForward = true;

    public Playlist(String playlistName) {
        this.name = playlistName;
    }

    public void start(ArrayList<Album> albums) {
        int option;
        int index = songListIterator.nextIndex();
        Song song = null;
        if (songListIterator.hasNext())
            song = songListIterator.next();

        while (true) {
            if (song != null)
                song.showInfo(true, false);
            else
                System.out.println("Playlist is currently empty.");

            printMenu();
            option = Utils.getOption(6);
            if (option == 0)
                return;

            switch (option) {
                case 1:
                    if (song != null) {
                        if (song.isPlaying())
                            song.stop();
                        else
                            song.start();
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if(songListIterator.hasPrevious())
                            songListIterator.previous();
                        goingForward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        if (song != null)
                            song.stop();

                        index = songListIterator.previousIndex();
                        song = songListIterator.previous();
                    } else {
                        System.out.println("Current song is first in playlist");
                    }
                    break;
                case 3:
                    if (!goingForward) {
                        if(songListIterator.hasNext())
                            songListIterator.next();
                        goingForward = true;
                    }
                    if (songListIterator.hasNext()) {
                        if (song != null)
                            song.stop();

                        index = songListIterator.nextIndex();
                        song = songListIterator.next();
                    } else {
                        System.out.println("Current song is last in playlist");
                    }
                    break;
                case 4:
                    if (song != null) {
                        String songName = song.getTitle();
                        songListIterator.remove();
                        System.out.println("Song " + songName + " removed");
                    } else
                        System.out.println("Cannot remove from empty playlist");
                    break;
                case 5:
                    Song tempSong = getSongFromAlbums(albums);
                    if (tempSong != null) {
                        if (addSong(tempSong)) {
                            song = songListIterator.previous();
                            goingForward = false;
                        }
                        //song = tempSong;
                    }
                    break;
                case 6:
                    listSongs(index);
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    private void printMenu() {
        System.out.println("/*** PLAYLIST " + name + " ***/");
        System.out.println("1. Start/stop");
        System.out.println("2. Previous");
        System.out.println("3. Next");
        System.out.println("4. Remove current song");
        System.out.println("5. Add song");
        System.out.println("6. Song list");
        System.out.println("0. Quit");
    }

    private Song getSongFromAlbums(ArrayList<Album> albums) {
        if (albums.size() == 0) {
            System.out.println("There are no albums to choose from");
            return null;
        }

        Utils.listAlbums(albums, true);
        System.out.println("Choose album index: ");
        int index = Utils.getOption(albums.size());
        if (index == 0)
            return null;

        Album album = albums.get(index - 1);
        if (album.getSize() == 0) {
            System.out.println("Album " + album.getName() + " is empty");
            return null;
        }
        album.listSongs();

        System.out.println("Choose song to add to playlist " + name);
        index = Utils.getOption(album.getSize());
        if (index == 0)
            return null;

        return(album.getSong(index - 1));
    }

    public boolean addSong(Song song) {
        Song tempSong = getSong(song.getTitle());
        if (tempSong != null) {
            System.out.println("Song " + song.getTitle() + " already exists in playlist " + getName());
            return false;
        }

        song.addPlaylist(this);
        this.songListIterator.add(song);
        //this.songs.add(song);
        System.out.println("Song " + song.getTitle() +
                " successfully added from album " + song.getAlbumName() +
                " to playlist " + name);
        return true;
    }

    public boolean removeSong(int index) {
        int albumSize = getSize();
        if (index < 0 || index >= albumSize)
            return false;

        this.songs.remove(index);
        return true;
    }

    public int getSize() {
        return songs.size();
    }

    public Song getSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public void listSongs(int currentSongIndex) {
        int i = 0;
        String currentSong = "";
        System.out.println("/************/");
        System.out.println("Playlist " + this.name);
        for (Song song : songs) {
            if (currentSongIndex == i)
                currentSong = "-> ";
            else
                currentSong = "";
            ++i;
            System.out.println(currentSong + "[" + i + "]: " + song.getSongInfoString(true, true));
        }
        System.out.println("/************/");
        System.out.println();
    }
}
