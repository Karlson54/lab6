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

    public void printSeatingArrangement(int hallNumber) {
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

    public int[] findBestAvailable(int hallNumber, int numSeats) {
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
                            numSeats + " best available seats found in row " + (row + 1) + " in hall " + hallNumber + ".");
                    return new int[]{row + 1, seat + 1};
                }
            }
        }
        System.out.println("No best available seats found in hall " + hallNumber + ".");
        return null;
    }

    public void autoBook(int hallNumber, int numSeats) {
        int[] bestAvailable = findBestAvailable(hallNumber, numSeats);
        if (bestAvailable != null) {
            int row = bestAvailable[0];
            int startSeat = bestAvailable[1];

            for (int i = startSeat; i < startSeat + numSeats; i++) {
                seats[hallNumber - 1][row - 1][i - 1] = 1;
            }

            System.out.println(
                    numSeats + " best available seats booked in row " + row + " in hall " + hallNumber + ".");
        } else {
            System.out.println("No best available seats booked in hall " + hallNumber + ".");
        }
    }

    public static void main(String[] args) {
        App cinema = new App();
        cinema.bookSeats(1, 5, new int[] { 1, 2, 3 });
        cinema.printSeatingArrangement(1);
        cinema.checkAvailability(1, 18);
        cinema.cancelBooking(1, 5, new int[] { 1, 2 ,3});
        cinema.autoBook(1, 3);
        cinema.printSeatingArrangement(1);
    }
}