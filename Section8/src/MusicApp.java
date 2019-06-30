import java.util.ArrayList;

public class MusicApp {
    private ArrayList<Album> albums = new ArrayList<>();
    private ArrayList<Playlist> playlists = new ArrayList<>();

    public void run() {
        int option;
        while (true) {
            printStartMenu();
            option = Utils.getOption(4);
            switch (option) {
                case 1:
                    openPlaylist();
                    break;
                case 2:
                    createPlaylist();
                    break;
                case 3:
                    createAlbum();
                    break;
                case 4:
                    openAlbum();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void printStartMenu() {
        System.out.println("/*** START MENU ***/");
        System.out.println("1. Open playlist");
        System.out.println("2. Create playlist");
        System.out.println("3. Create album");
        System.out.println("4. Open album");
        System.out.println("0. Quit");
        System.out.println();
    }

    public void createPlaylist() {
        String name;
        while (true) {
            System.out.println("Enter new playlist name:");
            name = Utils.getStringInput(20);
            if (name.equals("0"))
                return;
            else if (addPlaylist(name))
                return;
        }
    }

    public void openPlaylist() {
        int size = playlists.size();
        if (size == 0) {
            System.out.println("There are no playlists created");
            return;
        }

        int option;
        System.out.println("/*** PLAYLISTS ***/");
        listPlaylists(true);
        System.out.println("Choose a playlist: ");
        option = Utils.getOption(size);
        if (option == 0)
            return;

        --option;
        this.playlists.get(option).start(albums);
    }

    public void createAlbum() {
        String name;
        while (true) {
            System.out.println("Enter new album name:");
            name = Utils.getStringInput(20);
            if (name.equals('0'))
                return;
            else if (addAlbum(name))
                return;
        }
    }

    public void openAlbum() {
        int size = albums.size();
        if (size == 0) {
            System.out.println("There are no albums created");
            return;
        }

        int option;
        System.out.println("/*** ALBUMS ***/");
        Utils.listAlbums(albums,true);
        System.out.println("Choose an album: ");
        option = Utils.getOption(size);
        if (option == 0)
            return;

        --option;
        this.albums.get(option).start();
    }

    public boolean addAlbum(String name) {
        Album album = getAlbum(name);
        if (album != null) {
            System.out.println("Album " + name + " already exists. Cannot create");
            return false;
        }

        this.albums.add(new Album(name));
        System.out.println("Album " + name + " created");
        return true;
    }

    public boolean addPlaylist(String name) {
        Playlist playlist = getPlaylist(name);
        if (playlist != null) {
            System.out.println("Playlist " + name + " already exists. Cannot create");
            return false;
        }

        this.playlists.add(new Playlist(name));
        System.out.println("Playlist " + name + " created");
        return true;
    }

    private Album getAlbum(String albumName) {
        for (Album album : albums) {
            if (album.getName().equals(albumName)) {
                return album;
            }
        }

        return null;
    }

    private Album getAlbum(int index) {
        return albums.get(index);
    }

    private Playlist getPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(playlistName)) {
                return playlist;
            }
        }

        return null;
    }

    private Playlist getPlaylist(int index) {
        return playlists.get(index);
    }

    private void listPlaylists(boolean showSize) {
        int i = 1;
        System.out.println("/************/");
        System.out.println("Playlists:");
        for (Playlist playlist : playlists) {
            if (showSize)
                System.out.println("[" + i + "]: " + playlist.getName() + ", size: " + playlist.getSize());
            else
                System.out.println("[" + i + "]: " + playlist.getName());
            ++i;
        }
        System.out.println("/************/");
        System.out.println();
    }
}
