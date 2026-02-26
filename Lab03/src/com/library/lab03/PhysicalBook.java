package com.library.lab03;

public class PhysicalBook extends LibraryItem {
    private String shelfLocation;
    private double price;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn);
        this.price = price;
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        super.displayDetails();
        System.out.println("  - Price: " + price + " Baht");
        System.out.println("  - Shelf Location: " + shelfLocation);
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
}
