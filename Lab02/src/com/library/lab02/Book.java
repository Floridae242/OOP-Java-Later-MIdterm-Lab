package com.library.lab02;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDueDate;

    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }


    public void printSummary() {
        System.out.println("Book[Title='" + title + "', Status='" + status + "']");
    }

    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price + "฿");
        System.out.println("Status: " + status);
        if (returnDueDate != null) {
            System.out.println("Return Due Date: " + returnDueDate);
        } else {
            System.out.println("Return Due Date: N/A (Book is available)");
        }
        System.out.println("-".repeat(40));
    }

    public void checkOut(Member borrower) {
        if (status.equals("Available")) {
            // Check if member can borrow (hasn't reached limit)
            if (borrower.canBorrow()) {
                status = "Borrowed";
                this.returnDueDate = LocalDate.now().plusDays(14);
                borrower.addBorrowedBook(this);
                
                // Print success message as required
                System.out.println("Book '" + title + "' has been checked out successfully.");
                System.out.println("Book " + title + " has been borrowed by " + borrower.getName() + ".");
                System.out.println("Return Due Date: " + this.returnDueDate);
            } else {
                // This case should be handled by the caller, but we provide a message
                System.out.println("Member " + borrower.getName() + " has reached the borrow limit (" 
                    + borrower.getBorrowedCount() + ").");
                System.out.println("Borrow request denied for member " + borrower.getName() + ".");
            }
        } else {
            System.out.println("Error: Book '" + title + "' is already borrowed and cannot be checked out again.");
        }
    }

    public void returnBook() {
        if (status.equals("Borrowed")) {
            status = "Available";
            this.returnDueDate = null;
            System.out.println("Book '" + title + "' has been returned successfully.");
        } else {
            System.out.println("Book '" + title + "' is not currently borrowed. Cannot return.");
        }
    }
}
