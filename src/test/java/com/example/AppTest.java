package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    private App cinema;

    @Before
    public void setUp() {
        cinema = new App();
    }

    @Test
    public void testBookSeats() {
        cinema.bookSeats(1, 1, new int[] { 1, 2, 3 });
        assertTrue(cinema.checkAvailability(1, 7));
    }

    @Test
    public void testCancelBooking() {
        cinema.bookSeats(2, 2, new int[] { 4, 5, 6 });
        cinema.cancelBooking(2, 2, new int[] { 5, 6 });
        cinema.printSeatingArrangement(2);
        assertTrue(cinema.checkAvailability(2, 3));
    }

    @Test
    public void testCheckAvailability() {
        cinema.bookSeats(3, 1, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 2, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 3, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 4, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 5, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 6, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 7, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 8, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 9, new int[] { 8, 9, 10, });
        cinema.bookSeats(3, 10, new int[] { 8, 9, 10, });
        assertFalse(cinema.checkAvailability(3, 18));
    }

    @Test
    public void testPrintHall() {
        cinema.printSeatingArrangement(4);
    }

    @Test
    public void testFindBestAvailable() {
        cinema.bookSeats(4, 1, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        cinema.bookSeats(4, 2, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        cinema.bookSeats(4, 3, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        int[] bestAvailable = cinema.findBestAvailable(4, 3);
        assertArrayEquals(new int[] { 1, 11 }, bestAvailable);
    }

    @Test
    public void testAutoBook() {
        cinema.bookSeats(5, 1, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 2, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 3, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 4, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 5, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 6, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 7, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 8, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 9, new int[] { 8, 9, 10, });
        cinema.bookSeats(5, 10, new int[] { 8, 9, 10, });
        cinema.autoBook(5, 11);
        cinema.printSeatingArrangement(5);
        assertFalse(cinema.checkAvailability(5, 11));
    }
}