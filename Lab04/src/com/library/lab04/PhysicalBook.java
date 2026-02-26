package com.library.lab04;

public class PhysicalBook extends LibraryItem implements Taxable {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price);
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String s) {
        this.shelfLocation = s;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        System.out.println("  - Title: " + getTitle());
        System.out.println("  - Author: " + getAuthor());
        System.out.println("  - ISBN: " + getIsbn());
        System.out.println("  - Price: " + getPrice() + " Baht");
        System.out.println("  - Shelf Location: " + shelfLocation);
        System.out.println("  - Status: " + (isAvailable() ? "Available" : "Borrowed"));
        if (getReturnDueDate() != null) {
            System.out.println("  - Return Due Date: " + getReturnDueDate());
        } else {
            System.out.println("  - Return Due Date: N/A (Book is available)");
        }
        System.out.println();
    }

    @Override
    public void printSummary() {
        System.out.println("PhysicalBook[Title='" + getTitle() + "', Location='" + shelfLocation + "', Status='"
                + (isAvailable() ? "Available" : "Borrowed") + "']");
    }

    @Override
    public double calculateLateFee(int days) {
        return 5.0 * days;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.07;
    }
}
