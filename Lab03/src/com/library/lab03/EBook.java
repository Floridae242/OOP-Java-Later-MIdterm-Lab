package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn);
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println("  - Download URL: " + downloadUrl);
        System.out.println("  - File Size: " + fileSize + " MB");
        if (getReturnDueDate() != null) {
            System.out.println("  - Return Due Date: " + getReturnDueDate());
        } else {
            System.out.println("  - Return Due Date: N/A (E-book is available)");
        }
        System.out.println();
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0;
    }
}
