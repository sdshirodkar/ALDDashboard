package com.example.ald.entities;

public class Fund {

    private Integer BorrowerId;

    public Integer getBorrowerId() {
        return BorrowerId;
    }

    public void setBorrowerId(Integer borrowerId) {
        BorrowerId = borrowerId;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "BorrowerId=" + BorrowerId +
                '}';
    }
}
