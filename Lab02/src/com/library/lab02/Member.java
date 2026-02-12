package com.library.lab02;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;
    private static final int MAX_BORROW_LIMIT = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_BORROW_LIMIT;
    }

    public void addBorrowedBook(Book book) {
        if (canBorrow()) {
            borrowedBooks.add(book);
        }
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Books Borrowed: " + borrowedBooks.size() + "/" + MAX_BORROW_LIMIT);
        if (!borrowedBooks.isEmpty()) {
            System.out.println("Borrowed Books:");
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle());
            }
        }
        System.out.println("-".repeat(40));
    }
}
