package com.library.lab03;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;
    private static final int MAX_BORROW_LIMIT = 3;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
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

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public boolean canBorrow() {
        return borrowedItems.size() < MAX_BORROW_LIMIT;
    }

    public void addBorrowedItem(LibraryItem item) {
        if (canBorrow()) {
            borrowedItems.add(item);
        }
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public void displayMemberInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
        System.out.println("Items Borrowed: " + borrowedItems.size() + "/" + MAX_BORROW_LIMIT);
        if (!borrowedItems.isEmpty()) {
            System.out.println("Borrowed Items:");
            for (LibraryItem item : borrowedItems) {
                System.out.println("  - " + item.getTitle());
            }
        }
        System.out.println("-".repeat(40));
    }
}
