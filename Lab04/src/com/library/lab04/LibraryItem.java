package com.library.lab04;

import java.time.LocalDate;

public class LibraryItem {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private boolean isAvailable;
    private LocalDate returnDueDate;
    private Member borrower;

    public LibraryItem(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.isAvailable = true;
        this.returnDueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate d) {
        this.returnDueDate = d;
    }

    public void displayDetails() {
        System.out.println("  - Title: " + title);
        System.out.println("  - ISBN: " + isbn);
        System.out.println("  - Status: " + (isAvailable ? "Available" : "Borrowed"));
        if (returnDueDate != null) {
            System.out.println("  - Return Due Date: " + returnDueDate);
        } else {
            System.out.println("  - Return Due Date: N/A (Item is available)");
        }
    }

    public void printSummary() {
        System.out.println(
                "LibraryItem[Title='" + title + "', Status='" + (isAvailable ? "Available" : "Borrowed") + "']");
    }

    public void checkOut(Member borrower) {
        if (isAvailable) {
            if (borrower.canBorrow()) {
                isAvailable = false;
                this.returnDueDate = LocalDate.now().plusDays(14);
                this.borrower = borrower;
                borrower.addBorrowedItem(this);
                System.out.println("Item '" + title + "' has been checked out successfully.");
                System.out.println("Item '" + title + "' has been borrowed by " + borrower.getName() + ".");
                System.out.println("Return Due Date: " + this.returnDueDate);
            } else {
                System.out.println("Member " + borrower.getName() + " has reached the borrow limit ("
                        + borrower.getBorrowedCount() + ").");
                System.out.println("Borrow request denied for member " + borrower.getName() + ".");
            }
        } else {
            System.out.println("Error: Item '" + title + "' is already borrowed and cannot be checked out again.");
        }
    }

    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            this.returnDueDate = null;
            if (this.borrower != null) {
                this.borrower.removeBorrowedItem(this);
                this.borrower = null;
            }
            System.out.println("Item '" + title + "' has been returned successfully.");
        } else {
            System.out.println("Item '" + title + "' is not currently borrowed. Cannot return.");
        }
    }

    public double calculateLateFee(int days) {
        return 0.0;
    }
}
