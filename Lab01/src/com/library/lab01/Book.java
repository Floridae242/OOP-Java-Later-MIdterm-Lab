package com.library.lab01;

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

    public void checkOut() {
        if (status.equals("Available")) {
            status = "Borrowed";
            this.returnDueDate = LocalDate.now().plusDays(14);
            System.out.println("Book '" + title + "' has been checked out successfully.");
            System.out.println("Return Due Date: " + this.returnDueDate);
        } else {
            System.out.println("Book '" + title + "' is already borrowed. Cannot check out.");
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