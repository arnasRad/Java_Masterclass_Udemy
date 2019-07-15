import model.Artist;
import model.Datasource;
import model.SongArtist;

import java.util.List;

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

        datasource.close();
    }
}
