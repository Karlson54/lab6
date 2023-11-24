package com.example;

public class App {
    private int[][][] seats;

    public App() {
        seats = new int[5][10][20];
    }

    public void bookSeats(int hallNumber, int row, int[] seatsToBook) {
        for (int seat : seatsToBook) {
            int updatedHallNumber = hallNumber - 1;
            int updatedRow = row - 1;
            int updatedSeat = seat - 1;

            if (updatedRow >= 0 && updatedRow < seats[updatedHallNumber].length
                    && updatedSeat >= 0 && updatedSeat < seats[updatedHallNumber][updatedRow].length
                    && seats[updatedHallNumber][updatedRow][updatedSeat] == 0) {

                seats[updatedHallNumber][updatedRow][updatedSeat] = 1;
                System.out.println(
                        "Seat " + seat + " in row " + row + " in hall " + hallNumber + " booked.");
            } else {
                System.out.println("Seat " + seat + " in row " + row + " in hall " + hallNumber
                        + " cannot be booked.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seatsToCancel) {
        for (int seat : seatsToCancel) {
            int updatedHallNumber = hallNumber - 1;
            int updatedRow = row - 1;
            int updatedSeat = seat - 1;

            if (updatedRow >= 0 && updatedRow < seats[updatedHallNumber].length
                    && updatedSeat >= 0 && updatedSeat < seats[updatedHallNumber][updatedRow].length
                    && seats[updatedHallNumber][updatedRow][updatedSeat] == 1) {

                seats[updatedHallNumber][updatedRow][updatedSeat] = 0;
                System.out.println(
                        "Cancellation of seat " + seat + " in row " + row + " in hall " + hallNumber + " successful.");
            } else {
                System.out.println(
                        "Seat " + seat + " in row " + row + " in hall " + hallNumber + " was not booked.");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        int updatedHallNumber = hallNumber - 1;
        for (int row = 0; row < seats[updatedHallNumber].length; row++) {
            for (int seat = 0; seat <= seats[updatedHallNumber][row].length - numSeats; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seats[updatedHallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    System.out.println(
                            numSeats + " seats available in row " + (row + 1) + " in hall " + hallNumber + ".");
                    return true;
                }
            }
        }
        System.out.println(numSeats + " seats not available in hall " + hallNumber + ".");
        return false;
    }

    public void printhall(int hallNumber) {
        int updatedHallNumber = hallNumber - 1;
        System.out.println("Seating arrangement in hall " + hallNumber + ":");
        for (int row = 0; row < seats[updatedHallNumber].length; row++) {
            System.out.print("Row " + (row + 1) + ": ");
            for (int seat = 0; seat < seats[updatedHallNumber][row].length; seat++) {
                System.out.print(seats[updatedHallNumber][row][seat] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        App cinema = new App();
        cinema.bookSeats(1, 1, new int[] { 4, 5, 6 });
        cinema.printhall(1);
        cinema.checkAvailability(1, 18);
        cinema.cancelBooking(1, 3, new int[] { 5, 6 });
        cinema.printhall(1);
    }
}