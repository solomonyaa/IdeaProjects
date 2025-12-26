package dev.lpa;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String UNDERLINE = "\033[4m";

    private String name;
    private int numOfRows;
    private int seatsInRow;
    private NavigableSet<Seat> seats;

    public Theatre(String name, int numOfRows, int totalSeats) {

        this.name = name;

        if (numOfRows <= 26) {
            this.seatsInRow = totalSeats / numOfRows;
            this.numOfRows = numOfRows;
        } else {
            this.seatsInRow = 10;
            this.numOfRows = 10;
        }

        Comparator<Seat> seatComparator = Comparator.comparing(Seat::toString);
        this.seats = new TreeSet<>(seatComparator);

        // ASCII (A = 65)
        for (int i = 65; i < 65 + this.numOfRows; i++) {
            for (int j = 1; j <= seatsInRow; j++) {
                Seat s = new Seat((char) i, j);
                this.seats.add(s);
            }
        }
    }

    public void printSeatMap() {

        System.out.println("-".repeat(this.seatsInRow + 60));
        System.out.println(UNDERLINE + this.name + "'s Theatre Map" + RESET);
        System.out.println(RED + "Red" + RESET + " = reserved seat"
                + GREEN + "\nGreen" + RESET + " = vacant seat");

        seats.forEach(seat -> {
            System.out.print(seat + RESET + " | ");
            if (seat.seatNumInRow == seatsInRow) {
                System.out.println();
            }
        });
        System.out.println("-".repeat(this.seatsInRow + 60));
    }

    //returns whether a seat was reserved
    public boolean reserveSeat(char row, int seatNumInRow) {

        Seat s1 = new Seat(row, seatNumInRow);
        Seat s2 = seats.ceiling(s1);

        if (s2 != null && s1.seatNumInRow == s2.seatNumInRow && !s2.isReserved) {
            s2.isReserved = true;
            return true;
        } else {
            return false;
        }
    }

    //returns the number of seats actually reserved
    public int reserveSeats(char row, int seatNumInRow, int NumOfSeats, boolean toHigher) {

        int count = 0;

        if (toHigher) {
            for (int i = seatNumInRow; i < seatNumInRow + NumOfSeats; i++) {
                if (reserveSeat(row, i, true)) {
                    count++;
                }
            }
        } else {
            for (int i = seatNumInRow; i > seatNumInRow - NumOfSeats; i--) {
                if (reserveSeat(row, i, false)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean reserveSeat(char row, int seatNumInRow, boolean toHigher) {

        Seat s1 = new Seat(row, seatNumInRow);
        Seat s2;

        if (toHigher) {
            s2 = seats.ceiling(s1);
        } else {
            s2 = seats.floor(s1);
        }

        if (s2 != null && s1.seatNumInRow == s2.seatNumInRow && !s2.isReserved) {
            s2.isReserved = true;
            return true;
        } else {
            return false;
        }
    }

    public int reserveSeats(char fromRow, char toRow) {

        int reserved = 0;

        if (fromRow > toRow) {
            return 0;
        }

        for (int i = fromRow; i <= toRow; i++) {
            for (int j = 1; j <= this.seatsInRow; j++) {

                Seat s1 = new Seat((char) i, j);
                var s2 = seats.ceiling(s1);
                if (s2 != null && s1.seatNumInRow == s2.seatNumInRow && !s2.isReserved) {
                    s2.isReserved = true;
                    reserved++;
                }
            }
        }
        return reserved;
    }


    public boolean reserveSeats(char row, int from, int to) {

        int count = 0;

        if (Character.toUpperCase(row) < 65 || Character.toUpperCase(row) > numOfRows + 65)
            return false;
        if (from < 1 || to > seatsInRow || from > to)
            return false;

        Seat sFrom = new Seat(row, from);
        Seat sTo = new Seat(row, to);

        var subSet = this.seats.subSet(sFrom, true, sTo, true);

        for (Seat seat : subSet) {
            if (seat != null && !seat.isReserved) {
                seat.isReserved = true;
                count++;
            }
        }

        return (count == to - from + 1);
    }

    private class Seat implements Comparable<Seat> {

        private char row;
        private int seatNumInRow;
        private boolean isReserved;

        public Seat(char row, int seatNumInRow) {

            if (Character.isLetter(row)) {
                this.row = Character.toUpperCase(row);
            }
            if (seatNumInRow > 0 && seatNumInRow <= seatsInRow) {
                this.seatNumInRow = seatNumInRow;
            }
            this.isReserved = false;
        }

        @Override
        public String toString() {
            String numOfZeros = seatNumInRow >= 10 ? "0" : "00";
            String color = this.isReserved ? RED : GREEN;
            return color + row + numOfZeros + seatNumInRow;
        }

        @Override
        public int compareTo(Seat o) {
            return this.toString().compareTo(o.toString());
        }
    }
}
