package com.library.lab05;

import java.util.ArrayList;
import java.util.List;

/**
 * Member class - Updated for Strategy Pattern
 *
 * Now uses MembershipStrategy to determine:
 * - Borrow limits
 * - Loan periods
 * - Late fee discounts
 *
 * Members can change their strategy at runtime (upgrade/downgrade).
 */
public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems;
    private MembershipStrategy membershipStrategy;

    public Member(String memberId, String name, MembershipStrategy membershipStrategy) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedItems = new ArrayList<>();
        this.membershipStrategy = membershipStrategy;
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

    public void setMemberId(String id) {
        this.memberId = id;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public MembershipStrategy getMembershipStrategy() {
        return membershipStrategy;
    }

    public void setMembershipStrategy(MembershipStrategy membershipStrategy) {
        System.out.println("\n    🔄 [Strategy Changed] " + name + ": "
                + this.membershipStrategy.getMembershipType() + " → "
                + membershipStrategy.getMembershipType());
        this.membershipStrategy = membershipStrategy;
    }

    public boolean canBorrow() {
        if (membershipStrategy.hasUnlimitedBorrowing()) {
            return true;
        }
        return borrowedItems.size() < membershipStrategy.getBorrowLimit();
    }

    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public int getBorrowedCount() {
        return borrowedItems.size();
    }

    public double calculateLateFee(double baseFee) {
        return membershipStrategy.applyLateFeeDiscount(baseFee);
    }

    public void displayMemberInfo() {
        System.out.println("\n--- MEMBER INFORMATION ---");
        System.out.println("    ID: " + memberId);
        System.out.println("    Name: " + name);
        System.out.println("    Membership Type: " + membershipStrategy.getMembershipType());
        System.out.println("    Membership Cost: " + membershipStrategy.getMembershipCost() + " Baht");
        if (membershipStrategy.hasUnlimitedBorrowing()) {
            System.out.println("    Borrow Limit: Unlimited");
        } else {
            System.out.println("    Borrow Limit: " + membershipStrategy.getBorrowLimit());
        }
        System.out.println("    Currently Borrowed: " + borrowedItems.size());
        System.out.println("    Loan Period: " + membershipStrategy.getLoanPeriodDays() + " days");
    }
}
