public class BookingAgent {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre rodgerNYC = new Theatre("Richard rodgers", rows, totalSeats);

        rodgerNYC.printSeatMap();

        bookSeat(rodgerNYC, 'A', 3);
        bookSeat(rodgerNYC, 'D', 9);

        bookSeat(rodgerNYC, 'A', 19);
        bookSeat(rodgerNYC, 'Z', 3);

        bookSeats(rodgerNYC, 4, 'B', 3, 10);
        bookSeats(rodgerNYC, 6, 'B', 'C', 3, 10);
        bookSeats(rodgerNYC, 6, 'M', 'Z', 3, 10);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your reserved seat is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat) {
        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: " + minRow + " - " + maxRow);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat) {
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }
}

