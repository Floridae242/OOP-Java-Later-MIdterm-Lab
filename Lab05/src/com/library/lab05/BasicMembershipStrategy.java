package com.library.lab05;

public class BasicMembershipStrategy implements MembershipStrategy {
    private static final int BORROW_LIMIT = 1;
    private static final int LOAN_PERIOD = 14;
    private static final double MEMBERSHIP_COST = 0.0;

    @Override
    public int getBorrowLimit() {
        return BORROW_LIMIT;
    }

    @Override
    public int getLoanPeriodDays() {
        return LOAN_PERIOD;
    }

    @Override
    public double applyLateFeeDiscount(double baseFee) {

        return baseFee;
    }

    @Override
    public String getMembershipType() {
        return "Basic Member";
    }

    @Override
    public double getMembershipCost() {
        return MEMBERSHIP_COST;
    }

    @Override
    public boolean hasUnlimitedBorrowing() {
        return false;
    }
}
