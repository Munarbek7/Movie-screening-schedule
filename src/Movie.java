import java.io.Serializable;

public class Movie implements Serializable {
    private String id;
    private String title;
    private String theater;
    private String time;

    public Movie(String id, String title, String theater, String time) {
        this.id = id;
        this.title = title;
        this.theater = theater;
        this.time = time;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getTheater() { return theater; }
    public String getTime() { return time; }

    public void setTitle(String title) { this.title = title; }
    public void setTheater(String theater) { this.theater = theater; }
    public void setTime(String time) { this.time = time; }

    public String toString() {
        return String.format("ID: %s | Title: %s | Theater: %s | Time: %s", id, title, theater, time);
    }
}
