package com.library.lab04;

public class LibraryMovie implements DigitalContent {
    private String title;
    private String director;
    private String streamingUrl;
    private int durationMinutes;
    private int year;
    private String genre;
    private double price;

    public LibraryMovie(String title, String director, String streamingUrl,
            int durationMinutes, int year, String genre, double price) {
        this.title = title;
        this.director = director;
        this.streamingUrl = streamingUrl;
        this.durationMinutes = durationMinutes;
        this.year = year;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getStreamingUrl() {
        return streamingUrl;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming movie '" + title + "' (" + year + ")");
        System.out.println("Director: " + director + " | Genre: " + genre + " | Duration: " + durationMinutes + " min");
        System.out.println("URL: " + streamingUrl);
        System.out.println("Starting stream... connected! Enjoy the movie!");
    }

    @Override
    public void download() {
        System.out.println("Downloading movie '" + title + "' from: " + streamingUrl);
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now watch '" + title + "' offline.");
    }
}
