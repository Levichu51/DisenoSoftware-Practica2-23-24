package e3;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Artist implements Comparable<Artist> {
    private final String name;
    private final String id;
    private final String birthDate;
    private final String nationality;
    private ArrayList<Double> ratings;
    private ArrayList<String> albums;
    private ArrayList<String> genres;


    public Artist(String name, String id, String birthDate, String nationality){
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.ratings = new ArrayList<Double>();
        this.albums = new ArrayList<String>();
        this.genres = new ArrayList<String>();
    }

    public String getName(){
        return this.name;
    }
    public String getId(){
        return this.id;
    }
    public String getNationality(){
        return this.nationality;
    }
    public String getBirthDate(){
        return this.birthDate;
    }

    public String getAlbum(String album){
        if(this.albums.contains(album)){
            return album;
        }else{
            throw new IllegalArgumentException("No existe el album");
        }
    }

    public String getGenre(String genre){
        if(this.genres.contains(genre)){
            return genre;
        }else{
            throw new IllegalArgumentException("No existe el genero");
        }
    }

    public ArrayList<String> getAlbumList(){
        return this.albums;
    }
    public ArrayList<String> getGenreList(){
        return this.genres;
    }
    public ArrayList<Double> getRatingsList(){
        return this.ratings;
    }


    public void addGenre(String genre){
        this.genres.add(genre);
    }
    public void addRating(Double rating){
        this.ratings.add(rating);
    }
    public void addAlbum(String album){
        this.albums.add(album);
    }


    @Override
    public int compareTo(Artist other) {
        return this.id.compareTo(other.id);
    }

    // Método para ordenar la lista de artistas por el orden natural (id)
    public static void sortByNaturalOrder(List<Artist> artists) {
        Collections.sort(artists);
    }

    public static void sortByComparator(List<Artist> artists, Comparator<Artist> comparator) {
        Collections.sort(artists, comparator);
    }


    // Comparador para la puntuación media del artista
    public static final Comparator<Artist> RATING_COMPARATOR = Comparator.comparingDouble(artist -> calculateAverageRating(artist.getRatingsList()));

    // Comparador para el eclecticismo del artista (número de géneros diferentes)
    public static final Comparator<Artist> ECLECTICISM_COMPARATOR = Comparator.comparingInt(artist -> artist.getGenreList().size());

    // Comparador basado en la edad del artista, de más a menos joven
    public static final Comparator<Artist> AGE_COMPARATOR_ASCENDING = Comparator.comparingInt(Artist::calculateAge);

    // Comparador basado en la nacionalidad del artista en orden decreciente
    public static final Comparator<Artist> NATIONALITY_COMPARATOR_DESCENDING = Comparator.comparing(Artist::getNationality, Comparator.reverseOrder());

    public static double calculateAverageRating(ArrayList<Double> ratings) {
        double sum = 0.0;

        if (ratings.isEmpty()) {
            return 0.0;
        }

        for (Double rating : ratings) {
            sum += rating;
        }

        return sum / ratings.size();
    }

    // Método auxiliar para calcular la edad
    public int calculateAge() {
        LocalDate birthDate = LocalDate.parse(this.birthDate);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);

        return period.getYears();
    }

    public int calculateEclecticism() { //vemos la variedad de generos del artista
        return new HashSet<>(genres).size();
    }



}
