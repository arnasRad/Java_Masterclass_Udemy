import model.Artist;
import model.Datasource;
import model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.err.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_NONE);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Wanted Dead Or Alive", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getArtistName() +
                    ", Album name = " + artist.getAlbumName() +
                    ", Track = " + artist.getTrack());
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        if (datasource.createViewForSongArtists()) {
            System.out.println("Succeeded creating artist info view");
        } else {
            System.out.println("Failed creating artist info view...");
        }

//        if (datasource.dropSongInfoView()) {
//            System.out.println("Succeeded droping artist info view");
//        } else {
//            System.out.println("Failed droping artist info view...");
//        }

//        songArtists = datasource.querySongInfoView("Go Your Own Way");
//        songArtists = datasource.querySongInfoView("Heartless");

        // potential SQL Injection attack
        // for example, user may enter 'Go Your Own Way" or 1=1 or "' as input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();

        songArtists = datasource.querySongInfoView(title);
        if (songArtists == null || songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist songArtist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + songArtist.getArtistName() +
                    ", Album name = " + songArtist.getAlbumName() +
                    ", Track number = " + songArtist.getTrack());
        }

        datasource.close();
    }
}
