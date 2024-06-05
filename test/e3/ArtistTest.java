package e3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArtistTest {
    @Test
    public void testSortByNaturalOrder() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");

        List<Artist> artists = new ArrayList<>(Arrays.asList(artist2, artist1));
        Artist.sortByNaturalOrder(artists);
        assertEquals("ID001", artists.get(0).getId());
        assertEquals("ID002", artists.get(1).getId());
    }

    @Test
    public void testSortByRatingComparator() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");

        artist1.addRating(4.5);
        artist1.addRating(3.8);

        artist2.addRating(5.0);
        artist2.addRating(4.2);

        List<Artist> artists = new ArrayList<>(Arrays.asList(artist2, artist1));
        Artist.sortByComparator(artists, Artist.RATING_COMPARATOR);
        assertEquals("ID001", artists.get(0).getId());
        assertEquals("ID002", artists.get(1).getId());
    }

    @Test
    public void testCalculateAverageRating() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addRating(4.0);
        artist.addRating(3.5);
        artist.addRating(4.2);

        double averageRating = Artist.calculateAverageRating(artist.getRatingsList());
        assertEquals(3.9, averageRating, 0.01); // Ajusta la tolerancia según sea necesario
    }

    @Test
    public void testCalculateEclecticism() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addGenre("Rock");
        artist.addGenre("Pop");
        artist.addGenre("Jazz");
        artist.addGenre("Rock"); // Duplicado, no debería afectar a la eclecticism

        int eclecticism = artist.calculateEclecticism();
        assertEquals(3, eclecticism);
    }

    @Test
    public void testEclecticismComparator() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        artist1.addGenre("Rock");
        artist1.addGenre("Pop");

        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");
        artist2.addGenre("Jazz");

        Artist artist3 = new Artist("Artist3", "ID003", "2000-10-20", "Country3");
        artist3.addGenre("Rock");
        artist3.addGenre("Pop");
        artist3.addGenre("Jazz");

        List<Artist> artists = new ArrayList<>(Arrays.asList(artist1, artist2, artist3));

        // Ordenar la lista por eclecticism en orden ascendente
        artists.sort(Artist.ECLECTICISM_COMPARATOR);

        // Comprobar el orden esperado
        assertEquals("ID002", artists.get(0).getId());
        assertEquals("ID001", artists.get(1).getId());
        assertEquals("ID003", artists.get(2).getId());
    }

    @Test
    public void testAgeComparatorAscending() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");
        Artist artist3 = new Artist("Artist3", "ID003", "2000-10-20", "Country3");

        List<Artist> artists = new ArrayList<>(Arrays.asList(artist1, artist2, artist3));

        // Ordenar la lista por edad en orden ascendente
        artists.sort(Artist.AGE_COMPARATOR_ASCENDING);

        // Comprobar el orden esperado
        assertEquals("ID003", artists.get(0).getId());
        assertEquals("ID001", artists.get(1).getId());
        assertEquals("ID002", artists.get(2).getId());
    }

    @Test
    public void testNationalityComparatorDescending() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");
        Artist artist3 = new Artist("Artist3", "ID003", "2000-10-20", "Country3");

        List<Artist> artists = new ArrayList<>(Arrays.asList(artist1, artist2, artist3));

        // Ordenar la lista por nacionalidad en orden descendente
        artists.sort(Artist.NATIONALITY_COMPARATOR_DESCENDING);

        // Comprobar el orden esperado
        assertEquals("ID003", artists.get(0).getId());
        assertEquals("ID002", artists.get(1).getId());
        assertEquals("ID001", artists.get(2).getId());
    }
    @Test
    public void testAddAlbum() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addAlbum("Album1");
        artist.addAlbum("Album2");

        List<String> albums = artist.getAlbumList();
        assertEquals(2, albums.size());
        assertTrue(albums.contains("Album1"));
        assertTrue(albums.contains("Album2"));
    }

    @Test
    public void testAddGenre() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addGenre("Rock");
        artist.addGenre("Pop");

        List<String> genres = artist.getGenreList();
        assertEquals(2, genres.size());
        assertTrue(genres.contains("Rock"));
        assertTrue(genres.contains("Pop"));
    }

    @Test
    public void testAddRating() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addRating(4.5);
        artist.addRating(3.8);

        List<Double> ratings = artist.getRatingsList();
        assertEquals(2, ratings.size());
    }

    @Test
    public void testGetAlbum() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addAlbum("Album1");
        artist.addAlbum("Album2");

        assertEquals("Album1", artist.getAlbum("Album1"));
        assertEquals("Album2", artist.getAlbum("Album2"));
        assertThrows(IllegalArgumentException.class, () -> artist.getAlbum("NonExistingAlbum"));
    }

    @Test
    public void testGetGenre() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        artist.addGenre("Rock");
        artist.addGenre("Pop");

        assertEquals("Rock", artist.getGenre("Rock"));
        assertEquals("Pop", artist.getGenre("Pop"));
        assertThrows(IllegalArgumentException.class, () -> artist.getGenre("NonExistingGenre"));
    }

    @Test
    public void testGetNationality() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        assertEquals("Country3", artist.getNationality());
    }

    @Test
    public void testGetBirthDate() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        assertEquals("1980-03-20", artist.getBirthDate());
    }

    @Test
    public void testGetName() {
        Artist artist = new Artist("TestArtist", "ID003", "1980-03-20", "Country3");
        assertEquals("TestArtist", artist.getName());
    }

    @Test
    public void testAddArtistToArtistList() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");

        ArtistList artistList = new ArtistList();
        artistList.addArtist(artist1);
        artistList.addArtist(artist2);

        List<Artist> artists = artistList.getArtists();
        assertEquals(2, artists.size());
        assertTrue(artists.contains(artist1));
        assertTrue(artists.contains(artist2));
    }

    @Test
    public void testGetArtistsFromArtistList() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");

        ArtistList artistList = new ArtistList();
        artistList.addArtist(artist1);
        artistList.addArtist(artist2);

        List<Artist> artists = artistList.getArtists();
        assertEquals(2, artists.size());
        assertTrue(artists.contains(artist1));
        assertTrue(artists.contains(artist2));
    }

    @Test
    public void testRemoveArtistFromArtistList() {
        Artist artist1 = new Artist("Artist1", "ID001", "1990-01-01", "Country1");
        Artist artist2 = new Artist("Artist2", "ID002", "1985-05-15", "Country2");

        ArtistList artistList = new ArtistList();
        artistList.addArtist(artist1);
        artistList.addArtist(artist2);

        artistList.removeArtist(artist1);

        List<Artist> artists = artistList.getArtists();
        assertEquals(1, artists.size());
        assertFalse(artists.contains(artist1));
        assertTrue(artists.contains(artist2));
    }


}