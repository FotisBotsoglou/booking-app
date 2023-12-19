public class BookingApp {
    /**
     * A demonstration of a booking management application.
     */

    // Size of the rows of the array representing the seats.
    private static final int ROWS = 10;

    // Size of the columns of the array representing the seats.
    private static final  int COLS = 12;

    private static  boolean[][] seats = new boolean[ROWS][COLS];

    // A printing method that gives  a visual representation of the theater seats.
    private static void printSeatStatus() {
        System.out.println("Seat Status:");
        System.out.println("+"+"-".repeat(("empty".length()+3)*COLS)+"+");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print("| ");
                String status = seats[i][j] ? "X".repeat("empty".length()) : "Empty";
                System.out.print(status + " ");

            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("+"+"-".repeat(("empty".length()+3)*COLS)+"+");
        System.out.println();
    }
    // a validation method that checks the bounds of the array representing the theater seats.
    private  static boolean isValidSeat(int row, int column){
        return row >= 0 && row < ROWS && column >= 0 && column < COLS;
    }

    // the booking method that it is structured in a way to convert 1-based indexing to 0-based indexing.
    public  static  void  book(char column, int row) {
        int rowIndex = row - 1;
        int columnIndex = column - 'A';

        if (isValidSeat(rowIndex, columnIndex)) {
            if (!seats[rowIndex][columnIndex]) {
                seats[rowIndex][columnIndex] = true;
                System.out.println("You booked seat: "+ (char) (columnIndex + 'A')+"("+(rowIndex + 1)+").");
            } else {
                System.out.println("Seat " + (char) (columnIndex + 'A')+"("+(rowIndex + 1)+")." + " is already booked.");
            }
        }
        else System.out.println("Invalid seat.Please try again.");
    }

    public static void cancel(char column,int row){
        int rowIndex = row-1;
        int columnIndex = column - 'A';

        if (isValidSeat(rowIndex,columnIndex)){
            if (seats[rowIndex][columnIndex]){
                seats[rowIndex][columnIndex] = false;
                System.out.println("Cancelation succesfull for seat: "+(char) (columnIndex + 'A')+"("+(rowIndex + 1)+").");
            }
            else {
                System.out.println("Seat: "+(char) (columnIndex + 'A')+"("+(rowIndex + 1)+")."+"is not booked.");
            }
        }
        else System.out.println("Invalid seat.Please try again.");
    }
    public static void main(String[] args) {
        book('A', 5);
        book('B', 10);
        book('C', 15);
        printSeatStatus();

        cancel('B', 10);
        printSeatStatus();
    }
}
