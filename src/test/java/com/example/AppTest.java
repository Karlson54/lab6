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
        cinema.bookSeats(1, 1, new int[]{1, 2, 3});
        assertTrue(cinema.checkAvailability(1, 7));
    }

    @Test
    public void testCancelBooking() {
        cinema.bookSeats(2, 2, new int[]{4, 5, 6});
        cinema.cancelBooking(2, 2, new int[]{5, 6});
        cinema.printhall(2);
        assertTrue(cinema.checkAvailability(2, 3));
    }

    @Test
    public void testCheckAvailability() {
        cinema.bookSeats(3, 1, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 2, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 3, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 4, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 5, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 6, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 7, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 8, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 9, new int[]{8, 9, 10,});
        cinema.bookSeats(3, 10, new int[]{8, 9, 10,});
        assertFalse(cinema.checkAvailability(3, 18));
    }

    @Test
    public void testPrintHall() {
        cinema.printhall(4);
    }
}
