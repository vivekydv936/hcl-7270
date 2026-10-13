package com.hcl.library;

import com.hcl.library.exception.BorrowLimitExceededException;
import com.hcl.library.exception.ItemNotAvailableException;
import com.hcl.library.exception.ItemNotFoundException;
import com.hcl.library.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final int MAX_BORROW_LIMIT = 3;

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("Effective Java", 2018, "Joshua Bloch", "978-0134685991"));
        items.add(new Magazine("National Geographic", 2023, 405));
        items.add(new DVD("Inception", 2010, 148));
        items.add(new Book("Clean Code", 2008, "Robert C. Martin", "978-0132350884"));
        items.add(new DVD("Interstellar", 2014, 169));

        StringBuilder sb = new StringBuilder();
        sb.append("--- Items and Late Fees (5 Days Late) ---\n");
        for (LibraryItem item : items) {
            sb.append(item.getTitle())
              .append(" | Late Fee: $")
              .append(item.lateFee(5))
              .append("\n");
        }
        System.out.println(sb.toString());

        Member member1 = new Member("Alice Smith", "alice@gmail.com");
        Member member2 = new Member("Bob Johnson");
        System.out.println(member1);
        System.out.println(member2);

        try {
            new Member("Charlie", "invalid-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }

        System.out.println("\n--- Borrowing Items ---");
        borrowItem(member1, items.get(0), items);
        borrowItem(member1, items.get(1), items);
        borrowItem(member1, items.get(2), items);
        borrowItem(member1, items.get(3), items);

        borrowItem(member2, items.get(0), items);
        borrowItemById(member2, 9999, items);

        System.out.println("\n--- Returning Item ---");
        returnItem(member1, items.get(0));
        borrowItem(member2, items.get(0), items);

        System.out.println("\n--- Sorted Items (by Title) ---");
        Collections.sort(items);
        for (LibraryItem item : items) {
            System.out.println(item);
        }
    }

    public static void borrowItem(Member member, LibraryItem item, List<LibraryItem> inventory) {
        try {
            if (!inventory.contains(item)) {
                throw new ItemNotFoundException("Item not found in inventory.");
            }
            if (member.getBorrowedItems().size() >= MAX_BORROW_LIMIT) {
                throw new BorrowLimitExceededException("Borrow limit of " + MAX_BORROW_LIMIT + " exceeded for " + member.getName());
            }
            if (!item.isAvailable()) {
                throw new ItemNotAvailableException("Item '" + item.getTitle() + "' is not available.");
            }

            item.borrow();
            member.addBorrowedItem(item);
            System.out.println(member.getName() + " borrowed: " + item.getTitle());

        } catch (ItemNotFoundException e) {
            System.out.println("Not Found Error: " + e.getMessage());
        } catch (ItemNotAvailableException e) {
            System.out.println("Availability Error: " + e.getMessage());
        } catch (BorrowLimitExceededException e) {
            System.out.println("Limit Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void borrowItemById(Member member, int itemId, List<LibraryItem> inventory) {
        try {
            LibraryItem found = null;
            for (LibraryItem item : inventory) {
                if (item.getId() == itemId) {
                    found = item;
                    break;
                }
            }
            if (found == null) {
                throw new ItemNotFoundException("Item with ID " + itemId + " not found.");
            }
            borrowItem(member, found, inventory);
        } catch (ItemNotFoundException e) {
            System.out.println("Not Found Error: " + e.getMessage());
        }
    }

    public static void returnItem(Member member, LibraryItem item) {
        if (item != null) {
            item.giveBack();
            member.removeBorrowedItem(item);
            System.out.println(member.getName() + " returned: " + item.getTitle());
        }
    }
}
