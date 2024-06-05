package e3;


import java.util.ArrayList;
import java.util.List;

public class ArtistList {
    private List<Artist> artists;

    public ArtistList() {
        this.artists = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public void removeArtist(Artist artist){
        this.artists.remove(artist);
    }

    public List<Artist> getArtists() {
        return new ArrayList<Artist>(this.artists);
    }

}
