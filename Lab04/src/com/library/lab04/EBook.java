package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSize;
    private static final double DEFAULT_PRICE = 99.0;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, DEFAULT_PRICE);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String u) {
        this.downloadUrl = u;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double s) {
        this.fileSize = s;
    }

    @Override
    public void printSummary() {
        System.out.printf("EBook[Title='%s', Size='%.2f MB', Status='%s']%n",
                getTitle(), fileSize, isAvailable() ? "Available" : "Borrowed");
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + getTitle() + "' from URL: " + downloadUrl);
        System.out.println("Starting online stream... connected!");
        System.out.println("You can now read the book online without downloading.");
    }

    @Override
    public void download() {
        System.out.println("Downloading '" + getTitle() + "' from URL: " + downloadUrl);
        System.out.printf("Downloading file... (%.2f MB)%n", fileSize);
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now read the book offline.");
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05;
    }
}
