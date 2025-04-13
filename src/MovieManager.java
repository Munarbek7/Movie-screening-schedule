import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MovieManager {
    private static final String FILE_NAME = "movies.txt";
    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieManager() {
        loadFromFile();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
        saveToFile();
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    public Movie findById(String id) {
        return movieList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void updateMovie(String id, String title, String theater, String time) {
        Movie movie = findById(id);
        if (movie != null) {
            movie.setTitle(title);
            movie.setTheater(theater);
            movie.setTime(time);
            saveToFile();
        }
    }

    public boolean deleteMovie(String id) {
        Movie movie = findById(id);
        if (movie != null) {
            movieList.remove(movie);
            saveToFile();
            return true;
        }
        return false;
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(movieList);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            movieList = (ArrayList<Movie>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data.");
        }
    }

    public void generateReport() {
        System.out.println("\n--- Report ---");
        System.out.println("Total movies: " + movieList.size());

        Map<String, Long> byTheater = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getTheater, Collectors.counting()));

        byTheater.forEach((theater, count) -> System.out.println("Theater: " + theater + " | Movies: " + count));
    }
}
