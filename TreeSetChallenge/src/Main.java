import dev.lpa.Theatre;

public class Main {

    public static void main(String[] args) {

        Theatre t1 = new Theatre("Cinema City", 10, 120);
        boolean wasReserved = t1.reserveSeat('D', 7);
        t1.reserveSeat('G', 3);
        t1.printSeatMap();
        System.out.println("D007 Reserved? " + wasReserved);

        var res1 = t1.reserveSeats('D', 10, 2, false);
        var res2 = t1.reserveSeats('A', 3, 2, true);
        var res3 = t1.reserveSeats('F', 8, 7, false);
        int res4 = t1.reserveSeats('B', 'A');

        t1.printSeatMap();
        System.out.println("seats reserved = " + res1);
        System.out.println("seats reserved = " + res2);
        System.out.println("seats reserved = " + res3);
        System.out.println("seats reserved = " + res4);


        var res5 = t1.reserveSeats('I', 2, 11);
        System.out.println("Number of seats requested was reserved = " + res5);
        var res6 = t1.reserveSeats('b', 10, 11);
        t1.printSeatMap();
    }
}