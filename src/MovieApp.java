import java.util.Scanner;

public class MovieApp {
    private static Scanner scanner = new Scanner(System.in);
    private static MovieManager manager = new MovieManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getInt("Enter choice: ");

            switch (choice) {
                case 1 -> createMovie();
                case 2 -> viewAllMovies();
                case 3 -> updateMovie();
                case 4 -> deleteMovie();
                case 5 -> manager.generateReport();
                case 6 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Movie Screening Schedule ---");
        System.out.println("1. Add Movie");
        System.out.println("2. View Movies");
        System.out.println("3. Update Movie");
        System.out.println("4. Delete Movie");
        System.out.println("5. Generate Report");
        System.out.println("6. Exit");
    }

    private static void createMovie() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine().trim();

        if (manager.findById(id) != null) {
            System.out.println("Movie with this ID already exists.");
            return;
        }

        String title = getNonEmpty("Enter Title: ");
        String theater = getNonEmpty("Enter Theater: ");
        String time = getNonEmpty("Enter Time (e.g., 18:30): ");

        manager.addMovie(new Movie(id, title, theater, time));
        System.out.println("Movie added.");
    }

    private static void viewAllMovies() {
        System.out.println("\n--- Movie List ---");
        for (Movie movie : manager.getAllMovies()) {
            System.out.println(movie);
        }
    }

    private static void updateMovie() {
        String id = getNonEmpty("Enter movie ID to update: ");
        Movie movie = manager.findById(id);

        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        String title = getNonEmpty("New Title: ");
        String theater = getNonEmpty("New Theater: ");
        String time = getNonEmpty("New Time: ");

        manager.updateMovie(id, title, theater, time);
        System.out.println("Movie updated.");
    }

    private static void deleteMovie() {
        String id = getNonEmpty("Enter movie ID to delete: ");
        if (manager.deleteMovie(id)) {
            System.out.println("Movie deleted.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    // Validation methods
    private static String getNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty.");
        }
    }

    private static int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
